/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modeloDatos;

import java.io.Serializable;

/**
 *
 * @author enrique
 */
public class Socio{
    private String nombre;
    private String pass;
    private String perfil;
    
    /**
     * @return the nombre
     */
    public Socio(){}
    
    public Socio(String nombre,String pass ){
        this.nombre=nombre;
        this.pass=pass;
    }
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the perfil
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

}
