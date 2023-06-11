package model;

import java.util.Date;

public class Mantenimiento {
    private int idMantenimiento, idEmbarcacion;
    private String descripcion;
    private float costo;
    private Date fechaInicio, fechaFin;

    public Mantenimiento() {
    }

    public Mantenimiento(int idMantenimiento, int idEmbarcacion, String descripcion, float costo, Date fechaInicio, Date fechaFin) {
        this.idMantenimiento = idMantenimiento;
        this.idEmbarcacion = idEmbarcacion;
        this.descripcion = descripcion;
        this.costo = costo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public int getIdEmbarcacion() {
        return idEmbarcacion;
    }

    public void setIdEmbarcacion(int idEmbarcacion) {
        this.idEmbarcacion = idEmbarcacion;
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
}
