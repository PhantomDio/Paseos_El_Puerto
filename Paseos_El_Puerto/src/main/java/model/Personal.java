package model;

import datos.PersonalDAO;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class Personal implements Serializable {
    private int idPersonal;
    private String nombre, apellidoP, apellidoM, direccion, telefono, email, sexo;
    private float costoHora;
    private Date fecha_nac;

    public Personal() {
    }

    public Personal(int idPersonal, String nombre, String apellidoP, String apellidoM, String direccion,
                    String telefono, String email, String sexo, float costoHora, String fecha_nac) {
        this.idPersonal = idPersonal;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.sexo = sexo;
        this.costoHora = costoHora;
        this.fecha_nac = Date.valueOf(fecha_nac);
    }

    public Personal(String nombre, String apellidoP, String apellidoM, String direccion, String telefono, String email, String sexo, float costoHora, String fecha_nac) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.sexo = sexo;
        this.costoHora = costoHora;
        this.fecha_nac = Date.valueOf(fecha_nac);
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(float costoHora) {
        this.costoHora = costoHora;
    }

    public int getEdad(Date fecha_nac) {
        LocalDate fechaNac = fecha_nac.toLocalDate();
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaNac, fechaActual).getYears();
    }

    public String getEstado(int idPersonal) {
        PersonalDAO personalDAO = new PersonalDAO();
        Date fechaFinPaseo = personalDAO.getUltimaFechaFinPaseo(idPersonal);
        fechaFinPaseo = fechaFinPaseo != null ? fechaFinPaseo : Date.valueOf("0001-01-01");
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaFin = fechaFinPaseo.toLocalDate(); // Convertir a LocalDate

        int comparacion = fechaActual.compareTo(fechaFin);
        System.out.println(comparacion);
        if (comparacion <= 0) {
            // La fecha actual es menor o igual a la fecha final del paseo
            return "No disponible";
        }
        return "Disponible";
    }
}
