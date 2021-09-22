/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author MRCon
 */
public class Modelo {
    
    private ArrayList <Persona> listaPersonas;
    
    
    public Modelo() {
        this.listaPersonas = new ArrayList<> ();
        
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
    
    public Persona buscar(Persona input) {
        
        Iterator<Persona> it = this.listaPersonas.iterator();
        
        Persona p2 = new Persona();
        p2 = null;
        
        while (it.hasNext()) {
            
            Persona p = it.next();
           
            if ((p.getNombre().equals(input.getNombre()) && (p.getContraseña().equals(input.getContraseña())))) p2 = p;
        }
        
        return p2;
    }
    
    public void añadir(Persona p) {
        
        listaPersonas.add(p);
    }
}