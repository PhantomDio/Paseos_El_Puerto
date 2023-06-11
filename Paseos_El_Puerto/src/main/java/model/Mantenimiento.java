package model;

import java.sql.Date;

public class Mantenimiento {
    private int idMantenimiento, idEmbarcacion;
    private String descripcion;
    private float costo;
    private Date fechaInicio, fechaFin;

    public Mantenimiento() {
    }

    public Mantenimiento(int idMantenimiento, int idEmbarcacion, String descripcion, float costo, String fechaInicio, String fechaFin) {
        this.idMantenimiento = idMantenimiento;
        this.idEmbarcacion = idEmbarcacion;
        this.descripcion = descripcion;
        this.costo = costo;
        this.fechaInicio = Date.valueOf(fechaInicio);
        this.fechaFin = Date.valueOf(fechaFin);
    }

    public Mantenimiento(int idEmbarcacion, String descripcion, float costo, String fechaInicio) {
        this.idEmbarcacion = idEmbarcacion;
        this.descripcion = descripcion;
        this.costo = costo;
        this.fechaInicio = Date.valueOf(fechaInicio);
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

    public String getEstado(Date fechaFin) {
        Date fechaActual = new Date(System.currentTimeMillis()); // Fecha actual
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
