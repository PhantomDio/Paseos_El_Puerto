package model;

import java.sql.Date;

public class Personal {
    private int idPersonal;
    private String nombre, apellidoP, apellidoM, direccion, telefono, email;
    private float costoHora;
    private Date fecha_nac;

    public Personal() {
    }

    public Personal(int idPersonal, String nombre, String apellidoP, String apellidoM, String direccion,
                    String telefono, String email, float costoHora, String fecha_nac) {
        this.idPersonal = idPersonal;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.costoHora = costoHora;
        this.fecha_nac = Date.valueOf(fecha_nac);
    }

    public Personal(String nombre, String apellidoP, String apellidoM, String direccion, String telefono, String email, float costoHora, String fecha_nac) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
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

    public float getCostoHora() {
        return costoHora;
    }
    public void setCostoHora(float costoHora) {
        this.costoHora = costoHora;
    }
}
