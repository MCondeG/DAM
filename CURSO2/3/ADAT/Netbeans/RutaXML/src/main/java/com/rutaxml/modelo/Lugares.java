/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rutaxml.modelo;

import java.util.ArrayList;


public class Lugares {
    
    private ArrayList<Lugar> lugares;
    
    private static Lugares instance = null;
    
    
    private Lugares() {
        
        this.lugares = new ArrayList<Lugar>();
    }
    

    public ArrayList<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(ArrayList<Lugar> lugares) {
        this.lugares = lugares;
    }
    
    public static Lugares getInstance() {
        
        if (Lugares.instance == null) Lugares.instance = new Lugares();
        
        return Lugares.instance;
    }
    
    
    public void añadir(Lugar lugar) {
        this.lugares.add(lugar);
    }
    
    public void mostrar() {    
        for(Lugar l : this.lugares) System.out.println(l);
    }
}