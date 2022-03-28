/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebajpa.ENTITY;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author rafa
 */
@Entity
@Table(name = "ruta")
@NamedQueries({
    @NamedQuery(name = "Ruta.findAll", query = "SELECT r FROM Ruta r"),
    @NamedQuery(name = "Ruta.findByIdruta", query = "SELECT r FROM Ruta r WHERE r.idruta = :idruta"),
    @NamedQuery(name = "Ruta.findByDescripcion", query = "SELECT r FROM Ruta r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Ruta.findByDistanciaTeorica", query = "SELECT r FROM Ruta r WHERE r.distanciaTeorica = :distanciaTeorica"),
    @NamedQuery(name = "Ruta.findByVelocidadTeorica", query = "SELECT r FROM Ruta r WHERE r.velocidadTeorica = :velocidadTeorica"),
    @NamedQuery(name = "Ruta.findByTiempoTeorico", query = "SELECT r FROM Ruta r WHERE r.tiempoTeorico = :tiempoTeorico"),
    @NamedQuery(name = "Ruta.findByDistanciaReal", query = "SELECT r FROM Ruta r WHERE r.distanciaReal = :distanciaReal"),
    @NamedQuery(name = "Ruta.findByVelocidadReal", query = "SELECT r FROM Ruta r WHERE r.velocidadReal = :velocidadReal"),
    @NamedQuery(name = "Ruta.findByTiempoReal", query = "SELECT r FROM Ruta r WHERE r.tiempoReal = :tiempoReal"),
    @NamedQuery(name = "Ruta.findByRumbo", query = "SELECT r FROM Ruta r WHERE r.rumbo = :rumbo")})
public class Ruta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idruta")
    private Integer idruta;
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "distancia_teorica")
    private Float distanciaTeorica;
    @Column(name = "velocidad_teorica")
    private Float velocidadTeorica;
    @Column(name = "tiempo_teorico")
    private Float tiempoTeorico;
    @Column(name = "distancia_real")
    private Float distanciaReal;
    @Column(name = "velocidad_real")
    private Float velocidadReal;
    @Column(name = "tiempo_real")
    private Float tiempoReal;
    @Column(name = "rumbo")
    private Float rumbo;
    @JoinColumn(name = "idruta", referencedColumnName = "idtramo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Tramo tramo;

    public Ruta() {
    }

    public Ruta(Integer idruta) {
        this.idruta = idruta;
    }

    public Integer getIdruta() {
        return idruta;
    }

    public void setIdruta(Integer idruta) {
        this.idruta = idruta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getDistanciaTeorica() {
        return distanciaTeorica;
    }

    public void setDistanciaTeorica(Float distanciaTeorica) {
        this.distanciaTeorica = distanciaTeorica;
    }

    public Float getVelocidadTeorica() {
        return velocidadTeorica;
    }

    public void setVelocidadTeorica(Float velocidadTeorica) {
        this.velocidadTeorica = velocidadTeorica;
    }

    public Float getTiempoTeorico() {
        return tiempoTeorico;
    }

    public void setTiempoTeorico(Float tiempoTeorico) {
        this.tiempoTeorico = tiempoTeorico;
    }

    public Float getDistanciaReal() {
        return distanciaReal;
    }

    public void setDistanciaReal(Float distanciaReal) {
        this.distanciaReal = distanciaReal;
    }

    public Float getVelocidadReal() {
        return velocidadReal;
    }

    public void setVelocidadReal(Float velocidadReal) {
        this.velocidadReal = velocidadReal;
    }

    public Float getTiempoReal() {
        return tiempoReal;
    }

    public void setTiempoReal(Float tiempoReal) {
        this.tiempoReal = tiempoReal;
    }

    public Float getRumbo() {
        return rumbo;
    }

    public void setRumbo(Float rumbo) {
        this.rumbo = rumbo;
    }

    public Tramo getTramo() {
        return tramo;
    }

    public void setTramo(Tramo tramo) {
        this.tramo = tramo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idruta != null ? idruta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ruta)) {
            return false;
        }
        Ruta other = (Ruta) object;
        if ((this.idruta == null && other.idruta != null) || (this.idruta != null && !this.idruta.equals(other.idruta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pruebajpa.ENTITY.Ruta[ idruta=" + idruta + " ]";
    }
    
}
