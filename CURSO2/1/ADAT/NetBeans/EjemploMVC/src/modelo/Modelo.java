/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datos.*;
import java.util.*;


/**
 *
 * @author Ahbyss
 */
public class Modelo {
    
    private Datos datosUser;
    private ArrayList <Persona> usuarios;
    
    
    public Modelo() {
        this.datosUser = new Datos();
        this.usuarios = datosUser.getListaPersonas();
    }

    
    public Datos getDatosUser() {
        return datosUser;
    }

    public void setDatosUser(Datos datosUser) {
        this.datosUser = datosUser;
    }

    public ArrayList <Persona> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList <Persona> usuarios) {
        this.usuarios = usuarios;
    }  
}