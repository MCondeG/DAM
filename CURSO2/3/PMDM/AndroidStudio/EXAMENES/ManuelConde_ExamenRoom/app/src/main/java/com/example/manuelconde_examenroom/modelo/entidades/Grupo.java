package com.example.manuelconde_examenroom.modelo.entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.manuelconde_examenroom.modelo.utils.Constantes;


@Entity(tableName = Constantes.NOMBRE_TABLA_GRUPO)
public class Grupo {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_grupo")
    private int id_grupo;
    @ColumnInfo(name = "nombre")
    private String nombre;
    @ColumnInfo(name = "aula")
    private String aula;


    public Grupo() {

    }

    public Grupo(String nombre, String aula) {
        this.nombre = nombre;
        this.aula = aula;
    }


    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }


    @Override
    public String toString() {
        return "Grupo{" +
                "id_grupo=" + id_grupo +
                ", nombre='" + nombre + '\'' +
                ", aula='" + aula + '\'' +
                '}';
    }
}