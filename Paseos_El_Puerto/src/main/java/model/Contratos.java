package model;

import java.io.Serializable;
import java.sql.Date;

public class Contratos implements Serializable {
        private int idContrato, idEmbarcacion;
        private Date fechaInicio, fechaFin;
        private float costoHora;
        private String estado;

        public Contratos() {

        }

        public Contratos(String fechaInicio, int idContrato, String fechaFin, float costoHora) {
        this.idContrato = idContrato;
        this.costoHora = costoHora;
        this.fechaFin = Date.valueOf(fechaFin);
        this.fechaInicio = Date.valueOf(fechaInicio);
    }
    public Contratos(int idEmbarcacion, String fechaInicio, String fechaFin, float costoHora) {
        this.idEmbarcacion = idEmbarcacion;
        this.costoHora = costoHora;
        this.fechaFin = Date.valueOf(fechaFin);
        this.fechaInicio = Date.valueOf(fechaInicio);
    }

    public Contratos(int idContrato, int idEmbarcacion, String fechaInicio, String fechaFin, float costoHora) {
        this.idContrato = idContrato;
        this.idEmbarcacion = idEmbarcacion;
        this.costoHora = costoHora;
        this.fechaFin = java.sql.Date.valueOf(fechaFin);
        this.fechaInicio = java.sql.Date.valueOf(fechaInicio);
    }

    public int getIdContrato() {
            return idContrato;
        }

        public void setIdContrato(int idContrato) {
            this.idContrato = idContrato;
        }

        public int getIdEmbarcacion() {return idEmbarcacion; }

        public void setIdEmbarcacion(int idEmbarcacion) {
            this.idEmbarcacion = idEmbarcacion;
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

        public float getCostoHora() {
            return costoHora;
        }

        public void setCostoHora(float costoHora) {
            this.costoHora = costoHora;
        }

    public String getEstado(Date fechaFin) {

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

}