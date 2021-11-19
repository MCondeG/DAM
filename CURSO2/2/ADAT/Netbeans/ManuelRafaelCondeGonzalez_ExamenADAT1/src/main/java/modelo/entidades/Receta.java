/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades;

import java.util.ArrayList;

/**
 *
 * @author manuelconde
 */
public class Receta {
    
    private int id_receta;
    private String nombre;
    private float totalKcal;
    private ArrayList<Ingrediente> lista;
    
    
    public Receta(){
        
    }
    
    public Receta(int id_receta, String nombre, float totalKcal) {
        
        this.id_receta = id_receta;
        this.nombre = nombre;
        this.totalKcal = totalKcal;
        this.lista = new ArrayList<>();
    }

    
    public int getId_receta() {
        return id_receta;
    }

    public void setId_receta(int id_receta) {
        this.id_receta = id_receta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getTotalKcal() {
        return totalKcal;
    }

    public void setTotalKcal(float totalKcal) {
        this.totalKcal = totalKcal;
    }

    public ArrayList<Ingrediente> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Ingrediente> lista) {
        this.lista = lista;
    }
}