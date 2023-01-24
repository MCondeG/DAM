package com.example.preparacionexamen_sqliteroom.modelo.room.relaciones;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.preparacionexamen_sqliteroom.modelo.room.entidades.Alumno;
import com.example.preparacionexamen_sqliteroom.modelo.room.entidades.Tutor;

import java.util.List;


public class Tutor_Alumnos {

    @Embedded
    public Tutor tutor;

    @Relation(
            parentColumn = "id_tutor",
            entityColumn = "id_tutor"
    )
    public List<Alumno> alumnos;
}