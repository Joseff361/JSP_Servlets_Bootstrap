/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Carrito {
    
    private ArrayList<String> items = null;

    public Carrito() {
        items = new ArrayList<>();
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }
    
    public String agregar(String item){
        return item;
    }
    
    
}
