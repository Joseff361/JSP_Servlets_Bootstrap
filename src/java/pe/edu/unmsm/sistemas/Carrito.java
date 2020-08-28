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
        return this.items;
    }

    public void agregarItem(Item item) {
        this.items.add(item);
    }

    @Override
    public String toString() {
        return "Carrito{" + "items=" + items + '}';
    }
    
    public void eliminarItem(Item item){
//        int indice = this.items.indexOf(item);
        System.out.println("NombreCarrito" + item.getNombre());
//        System.out.println("Indice: " + indice);
        this.items.remove(item);
    }
    
    public Item getItem(String nombre){
        for (Item item: this.items){
            if(item.getNombre().equals(nombre)){
                return item;
            }
        }
        return null;
    }
    
    public void actualizarCantidadItem(String nombre, int cantidad){
        Item item = getItem(nombre);
        if(item!=null){
            item.setCantidad(cantidad);
        }
    }
}
