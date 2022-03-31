/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author manuelconde
 */
public class Ruta {
    
    private String nombre;
    private ArrayList<Tramo> tramos;
    
    
    public Ruta() {
        
    }
    
    public Ruta(String nombre) {
        
        this.nombre = nombre;
        this.tramos = new ArrayList<Tramo>();
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Tramo> getTramos() {
        return tramos;
    }

    public void setTramos(ArrayList<Tramo> tramos) {
        this.tramos = tramos;
    }
}