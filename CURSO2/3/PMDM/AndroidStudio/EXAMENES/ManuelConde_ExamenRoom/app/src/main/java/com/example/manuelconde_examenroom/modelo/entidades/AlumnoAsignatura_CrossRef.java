package com.example.manuelconde_examenroom.modelo.entidades;

import androidx.room.Entity;

import com.example.manuelconde_examenroom.modelo.utils.Constantes;


@Entity(tableName = Constantes.NOMBRE_RELACION_ALUMNO_ASIGNATURA, primaryKeys = {"id_alumno", "id_asignatura"})
public class AlumnoAsignatura_CrossRef {

    public int id_alumno;
    public int id_asignatura;


    public AlumnoAsignatura_CrossRef() {

    }

    public AlumnoAsignatura_CrossRef(int id_alumno, int id_asignatura) {
        this.id_alumno = id_alumno;
        this.id_asignatura = id_asignatura;
    }


    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }


    @Override
    public String toString() {
        return "AlumnoAsignatura_CrossRef{" +
                "id_alumno=" + id_alumno +
                ", id_asignatura=" + id_asignatura +
                '}';
    }
}