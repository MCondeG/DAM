/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author enrique
 */
public class Profesor {
    
    private String nombre;
    private int horasLectivas;
    private boolean mayor55;
    private String cp;
    
    
    public Profesor(){}

    public Profesor(String nombre, int horasLectivas, boolean mayor55) {
        this.nombre = nombre;
        this.horasLectivas = horasLectivas;
        this.mayor55 = mayor55;
    }
    
    

    public String getCp() {
        return cp;
    }

    public String getDni() {
        return dni;
    }
    private String dni;

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasLectivas() {
        return horasLectivas;
    }

    public void setHorasLectivas(int horasLectivas) {
        this.horasLectivas = horasLectivas;
    }

    public boolean isMayor55() {
        return mayor55;
    }

    public void setMayor55(boolean mayor55) {
        this.mayor55 = mayor55;
    }  
}