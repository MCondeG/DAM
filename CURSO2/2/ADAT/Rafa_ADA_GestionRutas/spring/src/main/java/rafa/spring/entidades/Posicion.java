/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rafa.spring.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafa
 */
@Entity
@Table(name = "posicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Posicion.findAll", query = "SELECT p FROM Posicion p"),
    @NamedQuery(name = "Posicion.findByIdposicion", query = "SELECT p FROM Posicion p WHERE p.idposicion = :idposicion"),
    @NamedQuery(name = "Posicion.findByLongitud", query = "SELECT p FROM Posicion p WHERE p.longitud = :longitud"),
    @NamedQuery(name = "Posicion.findByLatitud", query = "SELECT p FROM Posicion p WHERE p.latitud = :latitud"),
    @NamedQuery(name = "Posicion.findByDescripcion", query = "SELECT p FROM Posicion p WHERE p.descripcion = :descripcion")})
public class Posicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idposicion")
    private Integer idposicion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "longitud")
    private Float longitud;
    @Column(name = "latitud")
    private Float latitud;
    @Column(name = "descripcion")
    private String descripcion;

    public Posicion() {
    }

    public Posicion(Integer idposicion) {
        this.idposicion = idposicion;
    }

    public Integer getIdposicion() {
        return idposicion;
    }

    public void setIdposicion(Integer idposicion) {
        this.idposicion = idposicion;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idposicion != null ? idposicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Posicion)) {
            return false;
        }
        Posicion other = (Posicion) object;
        if ((this.idposicion == null && other.idposicion != null) || (this.idposicion != null && !this.idposicion.equals(other.idposicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rafa.spring.entidades.Posicion[ idposicion=" + idposicion + " ]";
    }
    
}
