package model;

public class Equipamiento {
    private int idEquipamiento;
    private String descripcion;
    private float costo;
    private String tipo;
    private int idEmbarcacion;

    public Equipamiento() {
    }

    public Equipamiento(int idEquipamiento, String descripcion, float costo, String tipo, int idEmbarcacion) {
        this.idEquipamiento = idEquipamiento;
        this.descripcion = descripcion;
        this.costo = costo;
        this.tipo = tipo;
        this.idEmbarcacion = idEmbarcacion;
    }

    public int getIdEquipamiento() {
        return idEquipamiento;
    }

    public void setIdEquipamiento(int idEquipamiento) {
        this.idEquipamiento = idEquipamiento;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdEmbarcacion() {
        return idEmbarcacion;
    }

    public void setIdEmbarcacion(int idEmbarcacion) {
        this.idEmbarcacion = idEmbarcacion;
    }
}
