package com.example.manuelconde_examenroom.modelo.entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.manuelconde_examenroom.modelo.utils.Constantes;


@Entity(tableName = Constantes.NOMBRE_TABLA_ASIGNATURA)
public class Asignatura {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_asignatura")
    private int id_asignatura;
    @ColumnInfo(name = "nombre")
    private String nombre;


    public Asignatura() {

    }

    public Asignatura(String nombre) {
        this.nombre = nombre;
    }


    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "Asignatura{" +
                "id_asignatura=" + id_asignatura +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}