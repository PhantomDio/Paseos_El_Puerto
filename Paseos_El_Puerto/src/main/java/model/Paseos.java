package model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Duration;

public class Paseos {
    private int idPaseo, idEmbarcacion, idCliente;
    private Date fechaInicioPaseo, fechaFinPaseo;

    public Paseos(int idEmbarcacion, int idCliente, String fechaInicio, String fechaFin) {
        this.idEmbarcacion = idEmbarcacion;
        this.idCliente = idCliente;
        this.fechaInicioPaseo = Date.valueOf(fechaInicio);
        this.fechaFinPaseo = Date.valueOf(fechaFin);
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

