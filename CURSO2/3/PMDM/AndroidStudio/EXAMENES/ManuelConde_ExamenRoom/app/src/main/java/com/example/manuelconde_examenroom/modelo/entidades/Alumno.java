package com.example.manuelconde_examenroom.modelo.entidades;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.manuelconde_examenroom.modelo.utils.Constantes;


@Entity(tableName = Constantes.NOMBRE_TABLA_ALUMNO,
        foreignKeys = @ForeignKey(
                entity = Grupo.class,
                parentColumns = "id_grupo",
                childColumns = "id_grupo",
                onUpdate = CASCADE,
                onDelete = CASCADE))
public class Alumno {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_alumno")
    private int id_alumno;
    @ColumnInfo(name = "nombre")
    private String nombre;
    @ColumnInfo(name = "apellido")
    private String apellido;
    @ColumnInfo(name = "id_grupo")
    private int id_grupo;


    public Alumno() {

    }

    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }


    @Override
    public String toString() {
        return "Alumno{" +
                "id_alumno=" + id_alumno +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", id_grupo=" + id_grupo +
                '}';
    }
}