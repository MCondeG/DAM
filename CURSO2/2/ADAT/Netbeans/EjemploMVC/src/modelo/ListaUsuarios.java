/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author manuelconde
 */
public class ListaUsuarios {
 
    private ArrayList<Usuario> usuarios;
    
    
    public ListaUsuarios() {
        
        this.usuarios = new ArrayList<>();
        
        
        this.usuarios.add(new Usuario("usuario1", "usuario1"));
        this.usuarios.add(new Usuario("usuario2", "usuario2"));
        this.usuarios.add(new Usuario("usuario3", "usuario3"));
    }

    
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}