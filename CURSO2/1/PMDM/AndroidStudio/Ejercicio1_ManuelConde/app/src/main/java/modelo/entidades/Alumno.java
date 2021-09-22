package modelo.entidades;

import java.io.Serializable;

public class Alumno implements Serializable{

    private String nombre;


    public Alumno() {

    }

    public Alumno(String nombre) {
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}