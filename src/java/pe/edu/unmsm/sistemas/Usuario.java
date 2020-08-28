/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas;

/**
 *
 * @author LuisGerman
 */
public class Usuario {
    String nombre1;
    String nombre2;
    String apellido;
    String email;
    String username;
    String password;
    String direccion;
    int codigoPostal;
    Tarjeta tarjeta;

    public Usuario() {
    }

    public Usuario(String nombre1, String nombre2, String apellido, String email, String username, String password, String direccion, int codigoPostal, Tarjeta tarjeta) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido = apellido;
        this.email = email;
        this.username = username;
        this.password = password;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.tarjeta = tarjeta;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
    
}
