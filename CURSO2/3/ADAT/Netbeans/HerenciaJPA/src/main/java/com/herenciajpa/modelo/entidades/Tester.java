/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herenciajpa.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author manuelconde
 */

@Entity
@Table(name = "Tester")
@PrimaryKeyJoinColumn(referencedColumnName="idPersona")
public class Tester extends Persona implements Serializable {
    
    @Column(name = "herramientas")
    private String herramientas;
    

    public Tester() {
    }
    
    public Tester (int id, String nombre, String herr){
        
        super(id,nombre);
        this.herramientas=herr;
    }

    
    public String getHerramientas() {
        return herramientas;
    }

    public void setHerramientas(String herramientas) {
        this.herramientas = herramientas;
    }
}