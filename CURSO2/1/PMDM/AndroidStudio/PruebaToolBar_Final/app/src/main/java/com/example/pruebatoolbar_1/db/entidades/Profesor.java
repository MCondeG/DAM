package com.example.pruebatoolbar_1.db.entidades;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Profesor {

    @PrimaryKey(autoGenerate = true)
    public int idProfesor;

    public String nombre;

    public Profesor() {
    }

    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
