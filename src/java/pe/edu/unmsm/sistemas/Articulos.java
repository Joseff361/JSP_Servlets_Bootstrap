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
public class Articulos {
    private static Articulos catalogo;
    
    private ArrayList<Articulo> articulos = null;

    private Articulos() {
        articulos = new ArrayList<>();
        articulos.add( new Articulo("P1", "Aceite", 10, 30,"A1"));
        articulos.add( new Articulo("P2", "Arroz", 5, 37,"A2"));
        articulos.add( new Articulo("P3", "Fideos", 7, 23, "A3"));
        articulos.add( new Articulo("P4", "Leche", 4, 21, "A4"));
        articulos.add( new Articulo("P5", "Ajinomen", 1, 50, "A5"));
        articulos.add( new Articulo("P6", "Gaseosa", 7, 90, "A6"));
        articulos.add( new Articulo("P7", "Sal", 1, 21, "A7"));
        articulos.add( new Articulo("P8", "Ceral", 4, 12, "A8"));
        articulos.add( new Articulo("P9", "Papel", 3, 121, "A9"));
        articulos.add( new Articulo("P10", "Legia",2, 32, "A10"));
        articulos.add( new Articulo("P11", "Quaker", 4, 41, "A11"));
        articulos.add( new Articulo("P12", "Blue Label", 640 , 12,  "A12"));
    }

    public static Articulos Singleton() { //LazyInitializedSingleton 
        if ( catalogo == null ) {
            catalogo = new Articulos();
        }
        return catalogo;
    }
    
    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

}
