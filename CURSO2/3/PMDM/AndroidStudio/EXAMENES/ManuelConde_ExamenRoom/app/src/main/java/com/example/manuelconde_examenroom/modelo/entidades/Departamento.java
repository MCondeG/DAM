package com.example.manuelconde_examenroom.modelo.entidades;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.manuelconde_examenroom.modelo.utils.Constantes;


@Entity(tableName = Constantes.NOMBRE_TABLA_DEPARTAMENTO)
public class Departamento {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_departamento")
    private int id_departamento;
    @ColumnInfo(name = "nombre")
    private String nombre;


    public Departamento() {

    }

    public Departamento(String nombre) {
        this.nombre = nombre;
    }


    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "Departamento{" +
                "id_departamento=" + id_departamento +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}