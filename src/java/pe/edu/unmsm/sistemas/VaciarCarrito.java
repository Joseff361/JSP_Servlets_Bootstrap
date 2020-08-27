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
public class VaciarCarrito {

    public VaciarCarrito() {
    }
    
    
    public String pagar(PaymentStrategy paymentMethod, String costo){
        return paymentMethod.pagar(costo);
    }
}
