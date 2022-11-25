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
@Table(name = "Programador")
@PrimaryKeyJoinColumn(referencedColumnName="idPersona")
public class Programador extends Persona implements Serializable {
    
    @Column(name = "lenguaje")
    private String lenguaje;
    
    
    public Programador() {

    }

    public Programador(Integer idPersona, String nombre, String leng) {
       super( idPersona,nombre);
 
        this.lenguaje=leng;
    }

    
    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }
}