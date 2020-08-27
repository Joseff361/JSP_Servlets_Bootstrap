/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas;

/**
 *
 * @author Usuario
 */
public class TarjetaDeCreditoStrategy implements PaymentStrategy{

    private String nombre;
    private String numeroDeTarjeta;
    private String cvv;
    private String fechaDeExpiracion;

    public TarjetaDeCreditoStrategy(String nombre, String numeroDeTarjeta, String cvv, String fechaDeExpiracion) {
        this.nombre = nombre;
        this.numeroDeTarjeta = numeroDeTarjeta;
        this.cvv = cvv;
        this.fechaDeExpiracion = fechaDeExpiracion;
    }

    public TarjetaDeCreditoStrategy(){}
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroDeTarjeta() {
        return numeroDeTarjeta;
    }

    public void setNumeroDeTarjeta(String numeroDeTarjeta) {
        this.numeroDeTarjeta = numeroDeTarjeta;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getFechaDeExpiracion() {
        return fechaDeExpiracion;
    }

    public void setFechaDeExpiracion(String fechaDeExpiracion) {
        this.fechaDeExpiracion = fechaDeExpiracion;
    }

    
    @Override
    public String pagar(String cantidad) {
        return "S/." + cantidad + " en productos pagados con exito via tarjeta de credito!";
    }
    
}
