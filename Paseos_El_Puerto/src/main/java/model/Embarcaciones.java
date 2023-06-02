package model;

import java.io.Serializable;

public class Embarcaciones implements Serializable {
    private int idEmbarcacion, anio, idPropietario;
    private String nombre, modelo;
    private float longitud;


    public Embarcaciones() {}

    public Embarcaciones(int idEmbarcacion, String nombre, String modelo, float longitud, int anio, int idPropietario) {
    }

    public Embarcaciones(String nombre, String modelo, float longitud, int anio, int idPropietario) {
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

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }
}