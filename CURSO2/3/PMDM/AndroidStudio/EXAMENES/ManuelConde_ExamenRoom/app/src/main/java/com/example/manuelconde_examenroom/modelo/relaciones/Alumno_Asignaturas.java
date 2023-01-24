package com.example.manuelconde_examenroom.modelo.relaciones;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.manuelconde_examenroom.modelo.entidades.Alumno;
import com.example.manuelconde_examenroom.modelo.entidades.AlumnoAsignatura_CrossRef;
import com.example.manuelconde_examenroom.modelo.entidades.Asignatura;

import java.util.List;


public class Alumno_Asignaturas {

    @Embedded
    public Alumno alumno;
    @Relation(
            parentColumn = "id_alumno",
            entityColumn = "id_asignatura",
            associateBy = @Junction(AlumnoAsignatura_CrossRef.class)
    )
    public List<Asignatura> asignaturas;
}