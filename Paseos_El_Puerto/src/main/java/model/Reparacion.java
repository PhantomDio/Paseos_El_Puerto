package model;
public class Reparacion {
    private int idReparacion;
    private int idMantenimiento;
    private String descripcion;
    private float costo;

    public Reparacion() {
    }

    public Reparacion(int idReparacion, int idMantenimiento, String descripcion, float costo) {
        this.idReparacion = idReparacion;
        this.idMantenimiento = idMantenimiento;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public int getIdReparacion() {
        return idReparacion;
    }

    public void setIdReparacion(int idReparacion) {
        this.idReparacion = idReparacion;
    }

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
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
}
