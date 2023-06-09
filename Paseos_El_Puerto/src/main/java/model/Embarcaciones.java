package model;

import datos.EmbarcacionesDAO;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Embarcaciones implements Serializable {
    private int idEmbarcacion, anio, idPropietario;
    private String nombre, modelo, nombreProp;
    private Date fechaFinPaseo, fechaFinContrato;
    private float costoHora, longitud;
    private boolean id_embarcacion;


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
            // La fecha actual es mayor que fecha2
            return "Vencido";
        } else if (comparacion < 0) {
            // La fecha actual es menor que fecha2
            return "Vigente";
        } else {
            // Las fechas son iguales
            return "Vigente";
        }
    }
    public String getEstado(int idEmbarcacion, Date fechaFinContrato) {
        EmbarcacionesDAO embarDAO = new EmbarcacionesDAO();
        Date fechaFinPaseo = embarDAO.obtenerFechaFinPaseo(idEmbarcacion);
        fechaFinPaseo = fechaFinPaseo != null ? fechaFinPaseo : Date.valueOf("0001-01-01");

        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaFinP = fechaFinPaseo.toLocalDate();
        LocalDate fechaFinC = fechaFinContrato.toLocalDate();
        int comparacion = fechaActual.compareTo(fechaFinP);
        int comparacion2 = fechaActual.compareTo(fechaFinC);

        if (comparacion < 0 && comparacion2 > 0) {
            return "No disponible";
        } else if (comparacion > 0 && comparacion2 < 0) {
            return "Disponible";
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