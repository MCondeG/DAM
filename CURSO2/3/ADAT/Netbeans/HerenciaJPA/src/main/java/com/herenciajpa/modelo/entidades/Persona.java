/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herenciajpa.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author manuelconde
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Persona")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT a FROM Persona a")
})
public class Persona implements Serializable {
    
    private static final long serialVersionUID = 1L;

    //@Basic(optional = false)
    @Id
    @Column(name = "idPersona")
    private Integer idPersona;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "estudios")
    private String estudios;

    
    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    public Persona(Integer idPersona, String nombre) {
        this.idPersona = idPersona;
        this.nombre=nombre;
    }
    
    
    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Persona[ idPersona=" + idPersona + " ]";
    }
}