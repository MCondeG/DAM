/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Ahbyss
 */
public class Persona {
 
    private String nombre;
    private String contraseña;
    private static int cont = 0;
    
    
    public Persona() {
        this.nombre = "usuario"+(Integer.toString(cont));
        this.contraseña = "pass"+(Integer.toString(cont));
        cont++;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}