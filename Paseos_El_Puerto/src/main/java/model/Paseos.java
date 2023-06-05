package model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Duration;

public class Paseos implements Serializable {
    private int idPaseo, idEmbarcacion, idCliente, idPropietario;
    private Date fechaInicioPaseo, fechaFinPaseo;
    private String nombreEmbarcacion, nombrePropietario, nombreCliente;
    private float costoHora;

    public Paseos(int idEmbarcacion, int idCliente, String fechaInicio, String fechaFin) {
        this.idEmbarcacion = idEmbarcacion;
        this.idCliente = idCliente;
        this.fechaInicioPaseo = Date.valueOf(fechaInicio);
        this.fechaFinPaseo = Date.valueOf(fechaFin);
    }

    public Paseos(int idPaseo, int idEmbarcacion, int idCliente, String fechaInicio, String fechaFin) {
        this.idPaseo = idPaseo;
        this.idEmbarcacion = idEmbarcacion;
        this.idCliente = idCliente;
        this.fechaInicioPaseo = Date.valueOf(fechaInicio);
        this.fechaFinPaseo = Date.valueOf(fechaFin);
    }

    public Paseos() {

    }

    public Paseos(int idPaseo, Date fechaInicioPaseo, Date fechaFinPaseo, int idEmbarcacion, String nombreEmbarcacion, int idPropietario, String nombrePropietario, int idCliente, String nombreCliente, float costoHora) {
        this.idPaseo = idPaseo;
        this.fechaInicioPaseo = fechaInicioPaseo;
        this.fechaFinPaseo = fechaFinPaseo;
        this.idEmbarcacion = idEmbarcacion;
        this.nombreEmbarcacion = nombreEmbarcacion;
        this.idPropietario = idPropietario;
        this.nombrePropietario = nombrePropietario;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.costoHora = costoHora;
    }



    public int getIdPaseo() {
        return idPaseo;
    }

    public void setIdPaseo(int idPaseo) {
        this.idPaseo = idPaseo;
    }

    public int getIdEmbarcacion() {
        return idEmbarcacion;
    }

    public void setIdEmbarcacion(int idEmbarcacion) {
        this.idEmbarcacion = idEmbarcacion;
    }

    public void setNombreEmbarcacion(String nombreEmbarcacion) {
        this.nombreEmbarcacion = nombreEmbarcacion;
    }
    public String getNombreEmbarcacion(){
        return nombreEmbarcacion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFechaInicioPaseo() {
        return fechaInicioPaseo;
    }

    public void setFechaInicioPaseo(Date fechaInicioPaseo) {
        this.fechaInicioPaseo = fechaInicioPaseo;
    }

    public Date getFechaFinPaseo() {
        return fechaFinPaseo;
    }

    public void setFechaFinPaseo(Date fechaFin) {
        this.fechaFinPaseo = fechaFin;
    }


    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setNombreProp(String nombreProp) {
        this.nombrePropietario = nombreProp;
    }

    public String getNombreProp() {
        return nombrePropietario;
    }


    public void setCostoHora(float costoHora) {
        this.costoHora = costoHora;
    }

    public float getCostoHora() {
        return costoHora;
    }

    public String getEstadoPaseo(Date fechaFinPaseo, Date fechaFinContrato) {

        Date fechaActual = new Date(System.currentTimeMillis()); // Fecha actual
        int comparacion = fechaActual.compareTo(fechaFinPaseo);
        int comparacion2 = fechaActual.compareTo(fechaFinContrato);

        if (comparacion < 0 && comparacion2 > 0) {
            // La fecha actual es mayor que la fechas_fin de contrato y menor a la de paseo
            return "No disponible";
        } else if (comparacion > 0 && comparacion2 < 0) {
            // La fecha actual es menor que la fechas_fin de contrato y mayor a la de paseo
            return "Disponible";
        } else if (comparacion == 0 && comparacion2 == 0){
            // Las fechas son iguales
            return "Disponible";
        }
        else
            return "No disponible";
    }

    public float getMontoTotal (Date fechaInicioPaseo, Date fechaFinPaseo, float costoHora){

        // Convierte las fechas a Timestamp
        Timestamp timestamp1 = new Timestamp(fechaInicioPaseo.getTime());
        Timestamp timestamp2 = new Timestamp(fechaFinPaseo.getTime());

        // Calcula la diferencia en horas
        long diferenciaHoras = Duration.between(timestamp1.toLocalDateTime(), timestamp2.toLocalDateTime()).toHours();

        // Calcula el monto total a partir de la diferencia en horas * el costo por hora establecido en el contrato
        float monto_total = diferenciaHoras * costoHora;
        return monto_total;
    }

}
