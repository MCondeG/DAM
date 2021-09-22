/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author manuelconde
 */

import modelo.*;

public abstract class Controlador {
    
    public static ListaViviendas inicio() {
        
        ListaViviendas viviendas = new ListaViviendas();
        
        return viviendas;
    }
    
    public static void listar(ListaViviendas viviendas) {
        
        for (Vivienda v: viviendas.getViviendas()) {
            
            System.out.println(v);
        }
    }
    
    public static boolean comprobar(ListaViviendas viviendas, int cod) {
        
        boolean disp = viviendas.getViviendas().get(cod).isDisponible();
                
        return disp;
    }
    
    
    public static void alquilar(ListaViviendas viviendas, int cod, Usuario u) {
                
        viviendas.getViviendas().get(cod).setDisponible(false);
        ViviendasAlquiladas va = new ViviendasAlquiladas(viviendas.getViviendas().get(cod), u);
    }
}