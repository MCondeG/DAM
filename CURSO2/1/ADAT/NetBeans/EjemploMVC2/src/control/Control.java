/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

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
    
    public static void main(String args[]) {
        
        boolean coincidencia = false;
        
        do {
            input.pedirDatos();
        
            pInput.setNombre(input.getUsuario());
            pInput.setContraseña(input.getContraseña());
            
            coincidencia = verificar(pInput, datos);

            if (coincidencia) {
                input.mostrarVerificacion();
                menu();
            }
            else input.mostrarError();
        } while (!coincidencia);
    }
    
    public static void menu() {
        
        int n = 0;
        
        do{
            n = input.mostrarMenu(n);
            
            switch (n) {
                case 1:
                    input.pedirDatos();
                    pInput.setNombre(input.getUsuario());
                    pInput.setContraseña(input.getContraseña());
                    datos.añadir(pInput);
                    break;
                    
                case 2:
                    extraerPersona();
                    break;
            }
        } while (n == 1 || n == 2);
        
    }
    
    public static boolean verificar (Persona p, Modelo datos) {
        
        boolean b = false;
        
        Persona p2 = new Persona();
        p2 = datos.buscar(p);
        
        if (p2 != null) b = true;
        
        return b;
    }
    
    public static void extraerPersona() {
        
        input.salto();
        
        Iterator<Persona> it = datos.getListaPersonas().iterator();
                    
        while (it.hasNext()){
                        
            Persona p = new Persona();
            p = it.next();
                        
            input.listar(p);    
        }
        
        input.salto();
        input.salto();
    }
}