/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

/**
 *
 * @author usuario
 */
public class Parte {
    
    private int idParte;
    

    public Parte() {
        
    }
    
    public Parte(int idParte) {
        this.idParte = idParte;
    }

    
    public int getIdParte() {
        return idParte;
    }

    public void setIdParte(int idParte) {
        this.idParte = idParte;
    }
}