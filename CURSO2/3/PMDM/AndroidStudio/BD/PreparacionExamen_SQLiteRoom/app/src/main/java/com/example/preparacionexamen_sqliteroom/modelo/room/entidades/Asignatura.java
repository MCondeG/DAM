package com.example.preparacionexamen_sqliteroom.modelo.room.entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.preparacionexamen_sqliteroom.modelo.room.utils.Constantes;


@Entity(tableName = Constantes.NOMBRE_TABLA_ASIGNATURA)
public class Asignatura {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_asignatura")
    private int id_asignatura;
    @ColumnInfo(name = "nombre")
    private String nombre;
    @ColumnInfo(name = "curso")
    private String curso;


    public Asignatura() {

    }

    public Asignatura(String nombre, String curso) {
        this.nombre = nombre;
        this.curso = curso;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}