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
        
        inicializaLista(this.listaPersonas);
    }

    
    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
    
    
    private static void inicializaLista(ArrayList <Persona> listaPersonas) {
        
        for (int i = 0; i < 10; i++) {
            listaPersonas.add(new Persona());
        }
    }
    
    private static Iterator<Persona> creaIterador(ArrayList <Persona> listaPersonas) {
        
        Iterator<Persona> it = listaPersonas.iterator();

        return it;
    }
    
    public boolean buscar(Persona p) {
        
        boolean b = false;
        
        Iterator<Persona> it = creaIterador(this.listaPersonas);
        
        while (it.hasNext()) {
            
            Persona p2 = new Persona();
            p2 = it.next();
           
            if ((p.getNombre().equals(p2.getNombre()) && (p.getContraseña().equals(p2.getContraseña())))) b = true;
        }
        
        return b;
    }
    
    public void añadir(Persona p) {
        
        listaPersonas.add(p);
    }
    
    public void eliminar(Persona p) {
        
        Iterator<Persona> it = creaIterador(this.listaPersonas);
    
        while (it.hasNext()) {
            
            Persona p2 = new Persona();
            p2 = it.next();
            
            if ((p.getNombre().equals(p2.getNombre())) && (p.getContraseña().equals(p2.getContraseña()))) it.remove();
        }
    }
    
    public void modificar(Persona p, Persona pnueva) {
        
        int cont = 0;
        
        Iterator<Persona> it = creaIterador(this.listaPersonas);
        
        while (it.hasNext()) {
            
            Persona p2 = new Persona();
            p2 = it.next();
           
            if ((p.getNombre().equals(p2.getNombre()) && (p.getContraseña().equals(p2.getContraseña())))) {
                this.listaPersonas.set(cont, pnueva);
            }
            
            cont++;
        }
    }
}