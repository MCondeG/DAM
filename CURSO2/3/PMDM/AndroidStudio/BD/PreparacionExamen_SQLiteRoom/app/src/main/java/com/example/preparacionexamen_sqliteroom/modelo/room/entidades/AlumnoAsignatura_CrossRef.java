package com.example.preparacionexamen_sqliteroom.modelo.room.entidades;

import androidx.room.Entity;


@Entity(primaryKeys = {"id_alumno", "id_asignatura"})
public class AlumnoAsignatura_CrossRef {

    public int id_alumno;
    public int id_asignatura;
}