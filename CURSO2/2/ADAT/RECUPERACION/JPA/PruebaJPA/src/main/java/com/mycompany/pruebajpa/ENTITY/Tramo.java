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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author rafa
 */
@Entity
@Table(name = "tramo")
@NamedQueries({
    @NamedQuery(name = "Tramo.findAll", query = "SELECT t FROM Tramo t"),
    @NamedQuery(name = "Tramo.findByIdtramo", query = "SELECT t FROM Tramo t WHERE t.idtramo = :idtramo"),
    @NamedQuery(name = "Tramo.findByNodoInicial", query = "SELECT t FROM Tramo t WHERE t.nodoInicial = :nodoInicial"),
    @NamedQuery(name = "Tramo.findByNodoFinal", query = "SELECT t FROM Tramo t WHERE t.nodoFinal = :nodoFinal"),
    @NamedQuery(name = "Tramo.findByVelocidad", query = "SELECT t FROM Tramo t WHERE t.velocidad = :velocidad"),
    @NamedQuery(name = "Tramo.findByTiempoTeorico", query = "SELECT t FROM Tramo t WHERE t.tiempoTeorico = :tiempoTeorico"),
    @NamedQuery(name = "Tramo.findByTiempoReal", query = "SELECT t FROM Tramo t WHERE t.tiempoReal = :tiempoReal"),
    @NamedQuery(name = "Tramo.findByRumbo", query = "SELECT t FROM Tramo t WHERE t.rumbo = :rumbo")})
public class Tramo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtramo")
    private Integer idtramo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nodo_inicial")
    private Float nodoInicial;
    @Column(name = "nodo_final")
    private Float nodoFinal;
    @Column(name = "velocidad")
    private Float velocidad;
    @Column(name = "tiempo_teorico")
    private Float tiempoTeorico;
    @Column(name = "tiempo_real")
    private Float tiempoReal;
    @Column(name = "rumbo")
    private Float rumbo;
    @JoinColumns({
        @JoinColumn(name = "distancia_real", referencedColumnName = "latitud"),
        @JoinColumn(name = "distancia_real", referencedColumnName = "latitud"),
        @JoinColumn(name = "distancia_real", referencedColumnName = "latitud")})
    @ManyToOne
    private Posicion posicion;
    @JoinColumns({
        @JoinColumn(name = "distancia_teorica", referencedColumnName = "longitud"),
        @JoinColumn(name = "distancia_teorica", referencedColumnName = "longitud"),
        @JoinColumn(name = "distancia_teorica", referencedColumnName = "longitud")})
    @ManyToOne
    private Posicion posicion1;

    public Tramo() {
    }

    public Tramo(Integer idtramo) {
        this.idtramo = idtramo;
    }

    public Integer getIdtramo() {
        return idtramo;
    }

    public void setIdtramo(Integer idtramo) {
        this.idtramo = idtramo;
    }

    public Float getNodoInicial() {
        return nodoInicial;
    }

    public void setNodoInicial(Float nodoInicial) {
        this.nodoInicial = nodoInicial;
    }

    public Float getNodoFinal() {
        return nodoFinal;
    }

    public void setNodoFinal(Float nodoFinal) {
        this.nodoFinal = nodoFinal;
    }

    public Float getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Float velocidad) {
        this.velocidad = velocidad;
    }

    public Float getTiempoTeorico() {
        return tiempoTeorico;
    }

    public void setTiempoTeorico(Float tiempoTeorico) {
        this.tiempoTeorico = tiempoTeorico;
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

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Posicion getPosicion1() {
        return posicion1;
    }

    public void setPosicion1(Posicion posicion1) {
        this.posicion1 = posicion1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtramo != null ? idtramo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tramo)) {
            return false;
        }
        Tramo other = (Tramo) object;
        if ((this.idtramo == null && other.idtramo != null) || (this.idtramo != null && !this.idtramo.equals(other.idtramo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pruebajpa.ENTITY.Tramo[ idtramo=" + idtramo + " ]";
    }
    
}
