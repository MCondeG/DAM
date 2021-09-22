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
public class ListaViviendas {
    
    private ArrayList<Vivienda> viviendas;
    
    
    public ListaViviendas() {
        
        this.viviendas = new ArrayList<>();
        inicializa(this.viviendas);
    }

    
    public ArrayList<Vivienda> getViviendas() {
        return viviendas;
    }

    public void setViviendas(ArrayList<Vivienda> viviendas) {
        this.viviendas = viviendas;
    }
    
    
    private static void inicializa(ArrayList<Vivienda> viviendas) {
        
        for (int i = 0; i<10; i++) {
            
            viviendas.add(new Vivienda(i, true));
        }
        
        viviendas.get(0).setDireccion("calle pepito perez");
        viviendas.get(1).setDireccion("calle perico de los palotes");
        viviendas.get(2).setDireccion("calle estrella betelgeuse");
        viviendas.get(3).setDireccion("calle corral de la encarnacion");
        viviendas.get(4).setDireccion("calle enrique apruebame");
        viviendas.get(5).setDireccion("calle nervion");
        viviendas.get(6).setDireccion("calle julio verne");
        viviendas.get(7).setDireccion("calle luis de morales");
        viviendas.get(8).setDireccion("calle mar de alboran");
        viviendas.get(9).setDireccion("calle lopez de gomara");
    }
}