/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author manuelconde
 */
public class Vivienda {
    
    private int cod;
    private String direccion;
    private boolean disponible;
    
    
    public Vivienda() {
        
    }
    
    public Vivienda(int cod, boolean disponible) {
        
        this.cod = cod;
        this.disponible = true;
    }
    
    public Vivienda(int cod, String direccion, boolean disponible) {
        
        this.cod = cod;
        this.direccion = direccion;
        this.disponible = true;
    }
    

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    

    @Override
    public String toString() {
        return "Vivienda{" + "codigo = " + cod + ", dirección = " + direccion + ", disponible = " + disponible + '}';
    }
}