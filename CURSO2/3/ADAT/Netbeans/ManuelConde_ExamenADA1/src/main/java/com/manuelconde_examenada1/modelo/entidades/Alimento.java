/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manuelconde_examenada1.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author manuelconde
 */
@Entity
@Table(name = "alimento")
@NamedQueries({
    @NamedQuery(name = "Alimento.findAll", query = "SELECT a FROM Alimento a"),
    @NamedQuery(name = "Alimento.findByIdAlimento", query = "SELECT a FROM Alimento a WHERE a.idAlimento = :idAlimento"),
    @NamedQuery(name = "Alimento.findByNombre", query = "SELECT a FROM Alimento a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Alimento.findByGrprot", query = "SELECT a FROM Alimento a WHERE a.grprot = :grprot"),
    @NamedQuery(name = "Alimento.findByGrgrasa", query = "SELECT a FROM Alimento a WHERE a.grgrasa = :grgrasa"),
    @NamedQuery(name = "Alimento.findByGrhidratos", query = "SELECT a FROM Alimento a WHERE a.grhidratos = :grhidratos")})
public class Alimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_alimento")
    private Integer idAlimento;
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "grprot")
    private Double grprot;
    @Column(name = "grgrasa")
    private Double grgrasa;
    @Column(name = "grhidratos")
    private Double grhidratos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlimento")
    private List<Ingrediente> ingredienteList;

    public Alimento() {
    }

    public Alimento(Integer idAlimento) {
        this.idAlimento = idAlimento;
    }

    public Integer getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(Integer idAlimento) {
        this.idAlimento = idAlimento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getGrprot() {
        return grprot;
    }

    public void setGrprot(Double grprot) {
        this.grprot = grprot;
    }

    public Double getGrgrasa() {
        return grgrasa;
    }

    public void setGrgrasa(Double grgrasa) {
        this.grgrasa = grgrasa;
    }

    public Double getGrhidratos() {
        return grhidratos;
    }

    public void setGrhidratos(Double grhidratos) {
        this.grhidratos = grhidratos;
    }

    public List<Ingrediente> getIngredienteList() {
        return ingredienteList;
    }

    public void setIngredienteList(List<Ingrediente> ingredienteList) {
        this.ingredienteList = ingredienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlimento != null ? idAlimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimento)) {
            return false;
        }
        Alimento other = (Alimento) object;
        if ((this.idAlimento == null && other.idAlimento != null) || (this.idAlimento != null && !this.idAlimento.equals(other.idAlimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.manuelconde_examenada1.modelo.entidades.Alimento[ idAlimento=" + idAlimento + " ]";
    }
    
}
