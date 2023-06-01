package model;

import java.io.Serializable;
import java.sql.Date;

public class Propietarios implements Serializable {
    private int IdPropietario;
    private String nombre, apellidoP, apellidoM, direccion, telefono, email;
    private Date fecha_nac;

    public Propietarios() {
    }

    public Propietarios(int IdPropietario) {
        this.IdPropietario = IdPropietario;
    }

    public Propietarios(int IdPropietario, String nombre, String apellidoP, String apellidoM, String direccion, String telefono, String email, String fecha_nac) {
        this.IdPropietario = IdPropietario;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fecha_nac = java.sql.Date.valueOf(fecha_nac);
    }

    public Propietarios(String nombre, String apellidoP, String apellidoM, String direccion, String telefono, String email, String fecha_nac) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fecha_nac = java.sql.Date.valueOf(fecha_nac);    }


    public int getIdPropietario() {
        return IdPropietario;
    }
    public void setIdPropietario(int IdPropietario) {
        this.IdPropietario = IdPropietario;
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
    public void setFecha_nac(java.sql.Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

}