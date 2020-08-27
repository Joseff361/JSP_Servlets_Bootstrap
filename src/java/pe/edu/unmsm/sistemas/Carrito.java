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
    
    private ArrayList<Item> items = null;

    public Carrito() {
        items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void agregarItem(Item item) {
        this.items.add(item);
    }

    @Override
    public String toString() {
        return "Carrito{" + "items=" + items + '}';
    }
    
    
}
