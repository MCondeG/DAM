package com.example.manuelconde_examenroom.modelo.relaciones;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.manuelconde_examenroom.modelo.entidades.Alumno;
import com.example.manuelconde_examenroom.modelo.entidades.AlumnoAsignatura_CrossRef;
import com.example.manuelconde_examenroom.modelo.entidades.Asignatura;

import java.util.List;


public class Asignatura_Alumnos {

    @Embedded
    public Asignatura asignatura;
    @Relation(
            parentColumn = "id_asignatura",
            entityColumn = "id_alumno",
            associateBy = @Junction(AlumnoAsignatura_CrossRef.class)
    )
    public List<Alumno> alumnos;
}