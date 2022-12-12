package com.example.examenada2.models;

import java.util.Objects;

public class Alumnos {
    private String nombre;
    private String Apellidos;
    private String DNI;
    private float notaMedia;

    public Alumnos(){
        //empty constructor
    }

    public Alumnos(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Alumnos{" +
                "nombre='" + nombre + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", DNI='" + DNI + '\'' +
                ", notaMedia=" + notaMedia +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumnos alumnos = (Alumnos) o;
        return DNI.equals(alumnos.DNI);
    }

    @Override
    public int hashCode() {
        return Objects.hash(DNI);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public float getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(float notaMedia) {
        this.notaMedia = notaMedia;
    }
}
