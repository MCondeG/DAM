/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author manuelconde
 */
public class Tramo {
    
    private Posicion inicio;
    private Posicion fin;
    private int distancia;
    
    
    public Tramo() {
        
    }
    
    public Tramo(Posicion inicio, Posicion fin, int distancia) {
        
        this.inicio = inicio;
        this.fin = fin;
        this.distancia = distancia;
    }
    

    public Posicion getInicio() {
        return inicio;
    }

    public void setInicio(Posicion inicio) {
        this.inicio = inicio;
    }

    public Posicion getFin() {
        return fin;
    }

    public void setFin(Posicion fin) {
        this.fin = fin;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    } 
}