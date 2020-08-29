/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas;

import java.util.ArrayList;

/**
 *
 * @author LuisGerman
 */
public class Usuarios {
    public static Usuarios listaDeUsuarios;
    private ArrayList<Usuario> usuarios = null;


    public Usuarios() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Jose", "Alberto", "Fernadez Figueroa","jose.fernandez30@unmsm.edu.pe", "jose.fernandez", "12345", "Calle Los Robles 899",4999, new Tarjeta("5166187454592415", 9, 2024, 585)));
        usuarios.add(new Usuario("Luis", "", "Esquivel Grados","luis.esquivel23@unmsm.edu.pe", "luis.esquivel", "12345", "Calle Los Robles 729",4999, new Tarjeta("5122130990316025", 8, 2024, 876)));
        usuarios.add(new Usuario("Sergio", "Tampau", "Dell","sergio.tampau@gmail.com", "sergio.tampau", "12345", "Calle Los Robles 644",4999, new Tarjeta("5417283622846051", 2, 2023, 268)));
    }

    public static Usuarios Singleton() {
        if ( listaDeUsuarios == null ) {
            listaDeUsuarios = new Usuarios();
        }
        return listaDeUsuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public Usuario getUserByCredentials(String username, String password){
        for(Usuario user: usuarios){
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }
    
}
