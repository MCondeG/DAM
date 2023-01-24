package com.example.preparacionexamen_sqliteroom.modelo.room.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.preparacionexamen_sqliteroom.modelo.room.entidades.Asignatura;
import com.example.preparacionexamen_sqliteroom.modelo.room.relaciones.Asignatura_Alumnos;

import java.util.List;


@Dao
public interface IDaoAsignatura {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void crearAsignatura(Asignatura asignatura);
    @Delete
    public void borrarAsignatura(Asignatura asignatura);
    @Update
    public void modificarAsignatura(Asignatura asignatura);
    @Query("SELECT * FROM asignatura WHERE id_asignatura LIKE :id_asignatura")
    public Asignatura verAsignatura(int id_asignatura);
    @Query("SELECT * FROM asignatura WHERE nombre LIKE :nombre")
    public Asignatura verAsignatura(String nombre);
    @Query("SELECT * FROM asignatura")
    public List<Asignatura> verAsignaturas();

    @Transaction
    @Query("SELECT * FROM asignatura WHERE id_asignatura LIKE :id_asignatura")
    public List<Asignatura_Alumnos> verAlumnosMatriculados(int id_asignatura);
}