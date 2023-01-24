package com.example.manuelconde_examenroom.modelo.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.manuelconde_examenroom.modelo.entidades.Alumno;
import com.example.manuelconde_examenroom.modelo.relaciones.Alumno_Asignaturas;

import java.util.List;


@Dao
public interface IDaoAlumno {

    //  CRUD
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void crearAlumno(Alumno alumno);
    @Delete
    public void borrarAlumno(Alumno alumno);
    @Update
    public void modificarAlumno(Alumno alumno);
    @Query("SELECT * FROM alumno WHERE id_alumno LIKE :id_alumno")
    public Alumno verAlumno(int id_alumno);
    @Query("SELECT * FROM alumno WHERE nombre LIKE :nombre")
    public Alumno verAlumno(String nombre);
    @Query("SELECT * FROM alumno")
    public List<Alumno> verAlumnos();

    @Query("INSERT INTO alumno_asignatura VALUES (:id_alumno, :id_asignatura)")
    public void matricularAsignatura(int id_alumno, int id_asignatura);

    //  PREGUNTA 3
    @Query("SELECT * FROM alumno WHERE id_grupo LIKE :id_grupo")
    public List<Alumno> verAlumnosGrupo(int id_grupo);
}