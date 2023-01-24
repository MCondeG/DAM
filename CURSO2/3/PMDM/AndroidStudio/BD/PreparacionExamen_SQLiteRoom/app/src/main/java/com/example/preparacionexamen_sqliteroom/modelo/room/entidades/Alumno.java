package com.example.preparacionexamen_sqliteroom.modelo.room.entidades;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.preparacionexamen_sqliteroom.modelo.room.utils.Constantes;


@Entity(tableName = Constantes.NOMBRE_TABLA_ALUMNO,
    foreignKeys = @ForeignKey(
            entity = Tutor.class,
            parentColumns = "id_tutor",
            childColumns = "id_tutor",
            onUpdate = CASCADE,
            onDelete = CASCADE))
public class Alumno {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_alumno")
    private int id_alumno;
    @ColumnInfo(name = "nombre")
    private String nombre;
    @ColumnInfo(name = "id_tutor")
    private int id_tutor;


    public Alumno() {

    }

    public Alumno(String nombre) {
        this.nombre = nombre;
    }


    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_tutor() {
        return id_tutor;
    }

    public void setId_tutor(int id_tutor) {
        this.id_tutor = id_tutor;
    }
}