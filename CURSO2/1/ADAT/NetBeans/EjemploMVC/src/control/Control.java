/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Modelo;
import datos.*;
import java.util.*;

/**
 *
 * @author Ahbyss
 */
public class Control {
    
    private String user;
    private String pass;
    private Modelo datos;
    private Boolean coincidencia;
    
    
    public Control(String user, String pass) {
        
        this.user = user;
        this.pass = pass;
        this.datos = new Modelo();
        this.coincidencia = compara(user, pass, datos);
    }

    
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Modelo getDatos() {
        return datos;
    }

    public void setDatos(Modelo datos) {
        this.datos = datos;
    }

    public Boolean getCoincidencia() {
        return coincidencia;
    }

    public void setCoincidencia(Boolean coincidencia) {
        this.coincidencia = coincidencia;
    }
    
    
    
    private boolean compara(String user, String pass, Modelo datos) {
        
        boolean b = false;
        
        Iterator<Persona> it = datos.getUsuarios().iterator();
        
        while (it.hasNext()) {
            
            Persona p = it.next();
            
            if ((this.user.equals(p.getNombre())) && (this.pass.equals(p.getContraseña()))) b = true;      
        }
        
        return b;
    }
}