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
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    public void añadirUsuario(String nombre) {
        
        this.usuarios.add(new Usuario(nombre));
    }
}