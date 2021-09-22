/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.*;

/**
 *
 * @author Ahbyss
 */
public class Datos {
    
    private ArrayList <Persona> listaPersonas;
    
    
    public Datos() {
        this.listaPersonas = new ArrayList <Persona> ();
        
        inicializaLista();
    }

    
    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
    
    
    private void inicializaLista() {
        
        for (int i = 0; i < 10; i++) {
            this.listaPersonas.add(new Persona());
        }
    }
}
