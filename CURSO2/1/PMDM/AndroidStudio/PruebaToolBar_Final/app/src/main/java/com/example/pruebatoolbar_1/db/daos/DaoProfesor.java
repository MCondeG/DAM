package com.example.pruebatoolbar_1.db.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pruebatoolbar_1.db.entidades.Profesor;

import java.util.List;

@Dao
public interface DaoProfesor {

    @Insert
    public void insertarProfesor(Profesor profesor);


    @Query("SELECT * FROM profesor")
    public List<Profesor> verProfesores();

    @Query("SELECT * FROM Profesor WHERE idProfesor= :idProfesor")
    public Profesor verProfesor(int idProfesor);

}
