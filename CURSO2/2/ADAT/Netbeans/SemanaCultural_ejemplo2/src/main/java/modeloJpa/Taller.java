/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloJpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author miguel
 */
@Entity
@Table(name = "taller")
@NamedQueries({
    @NamedQuery(name = "Taller.findAll", query = "SELECT t FROM Taller t"),
    @NamedQuery(name = "Taller.findByIdTaller", query = "SELECT t FROM Taller t WHERE t.idTaller = :idTaller"),
    @NamedQuery(name = "Taller.findByNombre", query = "SELECT t FROM Taller t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Taller.findByObservaciones", query = "SELECT t FROM Taller t WHERE t.observaciones = :observaciones")})
public class Taller implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_taller")
    private Integer idTaller;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "profesor_id_profesor", referencedColumnName = "id_profesor")
    @ManyToOne(optional = false)
    private Profesor profesorIdProfesor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTaller")
    private List<Matricula> matriculaList;

    public Taller() {
    }

    public Taller(Integer idTaller) {
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Profesor getProfesorIdProfesor() {
        return profesorIdProfesor;
    }

    public void setProfesorIdProfesor(Profesor profesorIdProfesor) {
        this.profesorIdProfesor = profesorIdProfesor;
    }

    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
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
        if (!(object instanceof Taller)) {
            return false;
        }
        Taller other = (Taller) object;
        if ((this.idTaller == null && other.idTaller != null) || (this.idTaller != null && !this.idTaller.equals(other.idTaller))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pruebajpa.Taller[ idTaller=" + idTaller + " ]";
    }
    
}
