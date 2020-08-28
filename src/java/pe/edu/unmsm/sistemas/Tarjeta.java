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
public class Tarjeta {
    String numero;
    int mesVencimiento;
    int diaVencimiento;
    int CVV;

    public Tarjeta() {
    }

    public Tarjeta(String numero, int mesVencimiento, int diaVencimiento, int CVV) {
        this.numero = numero;
        this.mesVencimiento = mesVencimiento;
        this.diaVencimiento = diaVencimiento;
        this.CVV = CVV;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getMesVencimiento() {
        return mesVencimiento;
    }

    public void setMesVencimiento(int mesVencimiento) {
        this.mesVencimiento = mesVencimiento;
    }

    public int getDiaVencimiento() {
        return diaVencimiento;
    }

    public void setDiaVencimiento(int diaVencimiento) {
        this.diaVencimiento = diaVencimiento;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }
    
    
}