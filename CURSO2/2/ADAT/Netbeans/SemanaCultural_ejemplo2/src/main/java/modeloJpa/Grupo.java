package modeloJpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grupo")
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g"),
    @NamedQuery(name = "Grupo.findByIdGrupo", query = "SELECT g FROM Grupo g WHERE g.idGrupo = :idGrupo"),
    @NamedQuery(name = "Grupo.findByObservaciones", query = "SELECT g FROM Grupo g WHERE g.observaciones = :observaciones")})
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_grupo")
    private String idGrupo;
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_profesor", referencedColumnName = "id_profesor")
    @ManyToOne(optional = false)
    private Profesor idProfesor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrupo")
    private List<Alumno> alumnoList;

    public Grupo() {
    }

    public Grupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(List<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pruebajpa.Grupo[ idGrupo=" + idGrupo + " ]";
    }
    
}
