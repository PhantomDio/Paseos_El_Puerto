package model;

import datos.EmbarcacionesDAO;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Embarcaciones implements Serializable {
    private int idEmbarcacion, anio, idPropietario;
    private String nombre, modelo, nombreProp;
    private Date fechaFinPaseo, fechaFinContrato;
    private float costoHora, longitud;
    private boolean id_embarcacion;
    private Date fechaFinMantenimiento;


    public Embarcaciones() {}

    public Embarcaciones(int idEmbarcacion, String nombre, String modelo, float longitud, int anio) {
        this.idEmbarcacion = idEmbarcacion;
        this.nombre = nombre;
        this.modelo = modelo;
        this.longitud = longitud;
        this.anio = anio;
    }

    public Embarcaciones(String nombre, String modelo, float longitud, int anio, int idPropietario) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.longitud = longitud;
        this.anio = anio;
        this.idPropietario = idPropietario;
    }


    public int getIdEmbarcacion() {
        return idEmbarcacion;
    }

    public void setIdEmbarcacion(int idEmbarcacion) {
        this.idEmbarcacion = idEmbarcacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getIdPropietario() {
        return idPropietario;
    }
    public void setnombreProp(String nombreProp) {
        this.nombreProp = nombreProp;
    }
    public String getNombreProp(){
        return nombreProp;
    }

    public Date getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(Date fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }

    public Date getFechaFinPaseo() {
        return fechaFinPaseo;
    }
    public void setFechaFinPaseo(Date fechaFinPaseo) {
        this.fechaFinPaseo = fechaFinPaseo;
    }


    public float getCostoHora() {
        return costoHora;
    }
    public void setCostoHora(float costoHora) {
        this.costoHora = costoHora;
    }


    public String getEstadoContrato(Date fechaFin) {

        Date fechaActual = new Date(System.currentTimeMillis()); // Fecha actual
        int comparacion = fechaActual.compareTo(fechaFin);

        if (comparacion > 0) {
            // La fecha actual es mayor que fechaFin
            return "Vencido";
        } else if (comparacion < 0) {
            // La fecha actual es menor que fechaFin
            return "Vigente";
        } else {
            // Las fechas son iguales
            return "Vigente";
        }
    }

    public String getEstado(int idEmbarcacion, Date fechaFinContrato) {
        EmbarcacionesDAO embarDAO = new EmbarcacionesDAO();

        Date fechaFinPaseo = embarDAO.getUltimaFechaFinPaseo(idEmbarcacion);
        fechaFinPaseo = fechaFinPaseo != null ? fechaFinPaseo : Date.valueOf("0001-01-01");

        ArrayList<Date> fechasMantenimiento = embarDAO.getUltimasFechasMantenimiento(idEmbarcacion);

        Date fechaIniMantenimiento = fechasMantenimiento.size() >= 1 ? fechasMantenimiento.get(0) : null;
        Date fechaFinMantenimiento = fechasMantenimiento.size() >= 2 ? fechasMantenimiento.get(1) : null;

        if (fechaIniMantenimiento != null && fechaFinMantenimiento == null) {
            fechaFinMantenimiento = Date.valueOf("9999-12-31");
        } else if (fechaIniMantenimiento == null && fechaFinMantenimiento == null) {
            fechaFinMantenimiento = Date.valueOf("0001-01-01");
        }

        ArrayList<Date> fechasReparacion = embarDAO.getUltimasFechasReparacion(idEmbarcacion);
        Date fechaIniReparacion = fechasReparacion.size() >= 1 ? fechasReparacion.get(0) : null;
        Date fechaFinReparacion = fechasReparacion.size() >= 2 ? fechasReparacion.get(1) : null;
        if (fechaIniReparacion != null && fechaFinReparacion == null) {
            fechaFinReparacion = Date.valueOf("9999-12-31");
        } else if (fechaIniReparacion == null && fechaFinReparacion == null) {
            fechaFinReparacion = Date.valueOf("0001-01-01");
        }

        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaFinP = fechaFinPaseo.toLocalDate();
        LocalDate fechaFinC = fechaFinContrato.toLocalDate();
        LocalDate fechaFinM = fechaFinMantenimiento != null ? fechaFinMantenimiento.toLocalDate() : null;
        LocalDate fechaFinR = fechaFinReparacion != null ? fechaFinReparacion.toLocalDate() : null;

        boolean disponiblePaseo = fechaActual.isAfter(fechaFinP);
        boolean disponibleContrato = fechaActual.isBefore(fechaFinC);
        boolean disponibleMantenimiento = fechaActual.isAfter(fechaFinM) || fechaActual.isEqual(fechaFinM);
        boolean disponibleReparacion = fechaActual.isAfter(fechaFinR) || fechaActual.isEqual(fechaFinR);

        if (disponiblePaseo && disponibleContrato && disponibleMantenimiento && disponibleReparacion) {
            return "Disponible";
        } else if (!disponiblePaseo && !disponibleContrato && !disponibleMantenimiento && !disponibleReparacion) {
            return "No Disponible";
        }

        return "No disponible";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Embarcaciones other = (Embarcaciones) o;
        return idEmbarcacion == other.idEmbarcacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmbarcacion);
    }

}