package com.example.preparacionexamen_sqliteroom.modelo.room.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.preparacionexamen_sqliteroom.modelo.room.entidades.Tutor;
import com.example.preparacionexamen_sqliteroom.modelo.room.relaciones.Tutor_Alumnos;

import java.util.List;


@Dao
public interface IDaoTutor {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void crearTutor(Tutor tutor);
    @Delete
    public void borrarTutor(Tutor tutor);
    @Update
    public void modificarTutor(Tutor tutor);
    @Query("SELECT * FROM tutor WHERE id_tutor LIKE :id_tutor")
    public Tutor verTutor(int id_tutor);
    @Query("SELECT * FROM tutor WHERE nombre LIKE :nombre")
    public Tutor verTutor(String nombre);
    @Query("SELECT * FROM tutor")
    public List<Tutor> verTutores();

    @Transaction
    @Query("SELECT * FROM tutor WHERE id_tutor LIKE :id_tutor")
    public List<Tutor_Alumnos> verAlumnosTutorizados(int id_tutor);
}