package com.example.manuelconde_examenroom.modelo.entidades;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.manuelconde_examenroom.modelo.utils.Constantes;


@Entity(tableName = Constantes.NOMBRE_TABLA_PROFESOR)
public class Profesor {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_profesor")
    private int id_profesor;
    @ColumnInfo(name = "nombre")
    private String nombre;
    @ColumnInfo(name = "apellido")
    private String apellido;
    @Nullable
    @ColumnInfo(name = "id_departamento")
    private int id_departamento;

    public Profesor() {

    }

    public Profesor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }


    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }


    @Override
    public String toString() {
        return "Profesor{" +
                "id_profesor=" + id_profesor +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", id_departamento=" + id_departamento +
                '}';
    }
}