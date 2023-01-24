package com.example.manuelconde_examenroom.modelo.relaciones;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.manuelconde_examenroom.modelo.entidades.Departamento;
import com.example.manuelconde_examenroom.modelo.entidades.Profesor;

import java.util.List;


public class Departamento_Profesores {

    @Embedded
    public Departamento departamento;

    @Relation(
            parentColumn = "id_departamento",
            entityColumn = "id_departamento"
    )
    public List<Profesor> profesores;
}