/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author enrique
 */
@Entity
@Table(name = "tester")
@PrimaryKeyJoinColumn(referencedColumnName="idPersona")

public class Tester extends Persona  implements Serializable {
   
    @Column(name = "herramientas")
    private String herramientas;
    

    public Tester() {
    }
    
    public Tester (int id, String nombre, String herr){
        
        super(id,nombre);
        this.herramientas=herr;
    }

    
    public String getHerramientas() {
        return herramientas;
    }

    public void setHerramientas(String herramientas) {
        this.herramientas = herramientas;
    }

  
    
}
