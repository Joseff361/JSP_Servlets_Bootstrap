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
public class PaypalStrategy implements PaymentStrategy{

    private String correo;
    private String password;

    public PaypalStrategy(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }
    
    public PaypalStrategy(){}

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    @Override
    public String pagar(String cantidad) {
        return "S/." + cantidad + " en productos pagados con exito via Paypal!";
    }
    
    

}
