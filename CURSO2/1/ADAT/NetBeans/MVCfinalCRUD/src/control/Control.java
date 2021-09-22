/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import vista.Vista;
import modelo.*;

/**
 *
 * @author MRCon
 */
public class Control {
    
    private Vista input;
    private Modelo datos;
    
    
    public Control(Vista input) {
        
        this.input = input;
        this.datos = new Modelo();
    }
    
    
    public boolean verificar (String user, String pass) {
        
        Persona p = new Persona(user, pass);
        
        return (datos.buscar(p));
    }
    
    public void añadirPersona(String user, String pass) {
        
        Persona p = new Persona(user, pass);
        
        datos.añadir(p);
    }
    
    public void eliminarPersona(String user, String pass) {
        
        Persona p = new Persona(user, pass);
        
        datos.eliminar(p);
    }
   
    public void modificarPersona(String user, String pass, String user2, String pass2) {
        
        Persona p = new Persona(user, pass);
        Persona pnueva = new Persona(user2, pass2);
        
        datos.modificar(p, pnueva);
    }
    
    public ArrayList<Persona> extraerPersonas() {
       
        return (datos.getListaPersonas());
    }
}