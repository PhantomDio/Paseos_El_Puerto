package model;

import java.io.Serializable;
import java.sql.Date;

public class Embarcaciones implements Serializable {
    private int idEmbarcacion, anio, idPropietario;
    private String nombre, modelo, estado, nombreProp;
    private Date fechaFinPaseo, fechaFinContrato;
    private float costoHora, longitud;


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
            return estado = "Vencido";
        } else if (comparacion < 0) {
            // La fecha actual es menor que fecha2
            return estado = "Vigente";
        } else {
            // Las fechas son iguales
            return estado = "Vigente";
        }
    }
    public String getEstadoPaseo(Date fechaFinPaseo, Date fechaFinContrato) {

        Date fechaActual = new Date(System.currentTimeMillis()); // Fecha actual
        int comparacion = fechaActual.compareTo(fechaFinPaseo);
        int comparacion2 = fechaActual.compareTo(fechaFinContrato);

        if (comparacion < 0 && comparacion2 > 0) {
            // La fecha actual es mayor que la fechas_fin de contrato y menor a la de paseo
            return estado = "No disponible";
        } else if (comparacion > 0 && comparacion2 < 0) {
            // La fecha actual es menor que la fechas_fin de contrato y mayor a la de paseo
            return estado = "Disponible";
        } else if (comparacion == 0 && comparacion2 == 0){
            // Las fechas son iguales
            return estado = "Disponible";
        }
        else
            return estado = "No disponible";
    }

}