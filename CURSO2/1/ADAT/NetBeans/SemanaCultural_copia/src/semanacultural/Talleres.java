/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semanacultural;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author enrique
 */
@Entity
@Table(name = "talleres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Talleres.findAll", query = "SELECT t FROM Talleres t"),
    @NamedQuery(name = "Talleres.findByIdTaller", query = "SELECT t FROM Talleres t WHERE t.idTaller = :idTaller"),
    @NamedQuery(name = "Talleres.findByNombre", query = "SELECT t FROM Talleres t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Talleres.findByResponsable", query = "SELECT t FROM Talleres t WHERE t.responsable = :responsable"),
    @NamedQuery(name = "Talleres.findByDiaHora", query = "SELECT t FROM Talleres t WHERE t.diaHora = :diaHora"),
    @NamedQuery(name = "Talleres.findByLugar", query = "SELECT t FROM Talleres t WHERE t.lugar = :lugar"),
    @NamedQuery(name = "Talleres.findByDuracion", query = "SELECT t FROM Talleres t WHERE t.duracion = :duracion"),
    @NamedQuery(name = "Talleres.findByObservaciones", query = "SELECT t FROM Talleres t WHERE t.observaciones = :observaciones")})

public class Talleres implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTaller")
    private Integer idTaller;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "responsable")
    private String responsable;
    @Column(name = "dia_hora")
    private String diaHora;
    @Column(name = "lugar")
    private String lugar;
    @Column(name = "duracion")
    private String duracion;
    @Column(name = "observaciones")
    private String observaciones;
    @ManyToMany(mappedBy = "talleresSet")
    private Set<Alumnos> alumnosSet;

    public Talleres() {
    }

    public Talleres(Integer idTaller) {
        this.idTaller = idTaller;
    }

    public Integer getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(Integer idTaller) {
        this.idTaller = idTaller;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getDiaHora() {
        return diaHora;
    }

    public void setDiaHora(String diaHora) {
        this.diaHora = diaHora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public Set<Alumnos> getAlumnosSet() {
        return alumnosSet;
    }

    public void setAlumnosSet(Set<Alumnos> alumnosSet) {
        this.alumnosSet = alumnosSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTaller != null ? idTaller.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Talleres)) {
            return false;
        }
        Talleres other = (Talleres) object;
        if ((this.idTaller == null && other.idTaller != null) || (this.idTaller != null && !this.idTaller.equals(other.idTaller))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "semanacultural.Talleres[ idTaller=" + idTaller + " ]";
    }
    
}
