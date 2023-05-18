package model;

public class Embarcaciones {
    private int idEmbarcacion;
    private String modelo;
    private float longitud;
    private int anio;
    private int idPropietario;

    public Embarcaciones() {
    }

    public Embarcaciones(int idEmbarcacion, String modelo, float longitud, int anio, int idPropietario) {
        this.idEmbarcacion = idEmbarcacion;
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

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }
}
