package model;

import java.util.Date;

public class Mantenimiento {
    private int idMantenimiento;
    private int idEmbarcacion;
    private int idProveedor;
    private Date fechaInicio;
    private Date fechaFin;
    private float costo;

    public Mantenimiento() {
    }

    public Mantenimiento(int idMantenimiento, int idEmbarcacion, int idProveedor, Date fechaInicio, Date fechaFin, float costo) {
        this.idMantenimiento = idMantenimiento;
        this.idEmbarcacion = idEmbarcacion;
        this.idProveedor = idProveedor;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
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

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
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

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
}
