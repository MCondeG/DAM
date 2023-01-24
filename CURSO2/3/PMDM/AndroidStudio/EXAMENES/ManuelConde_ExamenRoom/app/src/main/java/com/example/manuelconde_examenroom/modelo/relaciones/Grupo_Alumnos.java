package com.example.manuelconde_examenroom.modelo.relaciones;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.manuelconde_examenroom.modelo.entidades.Alumno;
import com.example.manuelconde_examenroom.modelo.entidades.Grupo;

import java.util.List;


public class Grupo_Alumnos {

    @Embedded
    public Grupo grupo;

    @Relation(
            parentColumn = "id_grupo",
            entityColumn = "id_grupo"
    )
    public List<Alumno> alumnos;
}