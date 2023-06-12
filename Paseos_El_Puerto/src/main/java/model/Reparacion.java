package model;

import java.io.Serializable;
import java.sql.Date;

public class Reparacion implements Serializable {

    private int idReparacion, idEmbarcacion, idPaseo;
    private String descripcion;
    private float costo;
    private Date fechaInicio, fechaFin;


    public Reparacion(int idReparacion, int idEmbarcacion, int idPaseo, String descripcion, float costo, String fechaInicio, String fechaFin) {
        this.idReparacion = idReparacion;
        this.idEmbarcacion = idEmbarcacion;
        this.idPaseo = idPaseo;
        this.descripcion = descripcion;
        this.costo = costo;
        this.fechaInicio = Date.valueOf(fechaInicio);
        this.fechaFin = Date.valueOf(fechaFin);
    }

    public Reparacion(int idEmbarcacion, String descripcion, float costo, String fechaInicio) {
        this.idEmbarcacion = idEmbarcacion;
        this.descripcion = descripcion;
        this.costo = costo;
        this.fechaInicio = Date.valueOf(fechaInicio);
    }

    public Reparacion() {

    }

    public int getIdReparacion() {
        return idReparacion;
    }
    public void setIdReparacion(int idReparacion) {
        this.idReparacion = idReparacion;
    }

    public int getIdEmbarcacion() {
        return idEmbarcacion;
    }
    public void setIdEmbarcacion(int idEmbarcacion) {
        this.idEmbarcacion = idEmbarcacion;
    }

    public int getIdPaseo() {
        return idPaseo;
    }
    public void setIdPaseo(int idPaseo) {
        this.idPaseo = idPaseo;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado(Date fechaFin) {
        Date fechaActual = new Date(System.currentTimeMillis()); // Fecha actual
        fechaFin = fechaFin != null ? fechaFin : Date.valueOf("9999-09-09");
        int comparacion = fechaActual.compareTo(fechaFin);

        if (comparacion > 0) {
            // La fecha actual es mayor que fecha2
            return "Finalizado";
        } else if (comparacion < 0) {
            // La fecha actual es menor que fecha2
            return "Activo";
        } else {
            // Las fechas son iguales
            return "Activo";
        }
    }

}
