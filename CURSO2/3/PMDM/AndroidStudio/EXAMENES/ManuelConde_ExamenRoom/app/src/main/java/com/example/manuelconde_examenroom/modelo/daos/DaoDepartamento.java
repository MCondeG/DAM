package com.example.manuelconde_examenroom.modelo.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.manuelconde_examenroom.modelo.entidades.Asignatura;
import com.example.manuelconde_examenroom.modelo.entidades.Departamento;

import java.util.List;


@Dao
public interface DaoDepartamento {

    //  CRUD
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void crearDepartamento(Departamento departamento);
    @Delete
    public void borrarDepartamento(Departamento departamento);
    @Update
    public void modificarDepartamento(Departamento departamento);
    @Query("SELECT * FROM departamento WHERE id_departamento LIKE :id_departamento")
    public Departamento verDepartamento(int id_departamento);
    @Query("SELECT * FROM departamento WHERE nombre LIKE :nombre")
    public Departamento verDepartamento(String nombre);
    @Query("SELECT * FROM departamento")
    public List<Departamento> verDepartamentos();
}