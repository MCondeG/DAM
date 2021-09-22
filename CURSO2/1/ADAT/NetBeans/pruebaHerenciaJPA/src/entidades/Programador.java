/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author enrique
 */
@Entity
@Table(name = "programador")
@PrimaryKeyJoinColumn(referencedColumnName="idPersona")
public class Programador  extends Persona implements Serializable {
    
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
