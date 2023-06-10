package model;

import java.io.Serializable;
import java.sql.Date;

public class Clientes implements Serializable {
    private int idCliente, num_paseos;
    private String nombre, apellidoP, apellidoM, direccion, telefono, email;
    private Date fecha_nac;

    public Clientes(){}
    public Clientes(int idCliente, String nombre, String apellidoP, String apellidoM, String direccion, String telefono, String email, String fecha_nac) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fecha_nac = Date.valueOf(fecha_nac); }

    public Clientes(int idCliente) {
        this.idCliente = idCliente;
    }

    public Clientes(int idCliente, String nombre, String apellidoP, String apellidoM, String direccion,
                    String telefono, String email, String fecha_nac, int num_paseos) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fecha_nac = Date.valueOf(fecha_nac);
        this.num_paseos = num_paseos;
    }

    public Clientes(String nombre, String apellidoP, String apellidoM, String direccion, String telefono, String email, String fecha_nac) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fecha_nac = Date.valueOf(fecha_nac);    }


    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public int getNumPaseos(){
        return num_paseos;
    }
    public void setNumPaseos(int num_paseos) {
        this.num_paseos = num_paseos;
    }
}