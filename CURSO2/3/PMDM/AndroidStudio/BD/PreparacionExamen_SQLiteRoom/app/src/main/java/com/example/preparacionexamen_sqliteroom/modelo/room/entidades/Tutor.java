package com.example.preparacionexamen_sqliteroom.modelo.room.entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.preparacionexamen_sqliteroom.modelo.room.utils.Constantes;


@Entity(tableName = Constantes.NOMBRE_TABLA_TUTOR)
public class Tutor {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_tutor")
    private int id_tutor;
    @ColumnInfo(name = "nombre")
    private String nombre;


    public Tutor() {

    }

    public Tutor(String nombre) {
        this.nombre = nombre;
    }


    public int getId_tutor() {
        return id_tutor;
    }

    public void setId_tutor(int id_tutor) {
        this.id_tutor = id_tutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}