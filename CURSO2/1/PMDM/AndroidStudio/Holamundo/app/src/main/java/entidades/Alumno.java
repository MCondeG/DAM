package entidades;

import java.io.Serializable;

public class Alumno implements Serializable{



    private String nombre;

    public Alumno(String nombre) {
        this.setNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
