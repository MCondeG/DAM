package com.example.manuelconde_examenroom.modelo.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.manuelconde_examenroom.modelo.entidades.Profesor;

import java.util.List;


@Dao
public interface IDaoProfesor {

    //  CRUD
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void crearProfesor(Profesor profesor);
    @Delete
    public void borrarProfesor(Profesor profesor);
    @Update
    public void modificarProfesor(Profesor profesor);
    @Query("SELECT * FROM profesor WHERE id_profesor LIKE :id_profesor")
    public Profesor verProfesor(int id_profesor);
    @Query("SELECT * FROM profesor WHERE nombre LIKE :nombre")
    public Profesor verProfesor(String nombre);
    @Query("SELECT * FROM profesor")
    public List<Profesor> verProfesores();
}