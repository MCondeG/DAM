package com.example.preparacionexamen_sqliteroom.modelo.room.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.preparacionexamen_sqliteroom.modelo.room.entidades.Alumno;
import com.example.preparacionexamen_sqliteroom.modelo.room.relaciones.Alumno_Asignaturas;

import java.util.List;


@Dao
public interface IDaoAlumno {

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

    @Transaction
    @Query("SELECT * FROM alumno WHERE id_alumno LIKE :id_alumno")
    public List<Alumno_Asignaturas> verAsignaturasCursadas(int id_alumno);
}