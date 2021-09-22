/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.Iterator;
import vista.Vista;
import modelo.*;

/**
 *
 * @author MRCon
 */
public class Control {
    
    private static Vista input = new Vista();
    private static Modelo datos = new Modelo();
    private static Persona pInput = new Persona();
    
    
    public Control() {
        
    }
    
    
    public boolean verificar (Persona p) {
        
        boolean b = false;
        
        Persona p2 = new Persona();
        p2 = datos.buscar(p);
        
        if (p2 != null) b = true;
        
        return b;
    }
    
    public void añadirPersona(String user, String pass) {
        
        datos.añadir(new Persona(user, pass));
    }
    
    public void eliminarPersona(Persona p) {
        
        datos.eliminar(p);
    }
    
    public ArrayList<Persona> extraerPersonas() {
        
        return datos.getListaPersonas();
    }
        
//        Iterator<Persona> it = datos.getListaPersonas().iterator();
//                    
//        while (it.hasNext()){
//                        
//            Persona p = new Persona();
//            p = it.next();
//                        
//            input.listar(p);
//        }
//    }
}//