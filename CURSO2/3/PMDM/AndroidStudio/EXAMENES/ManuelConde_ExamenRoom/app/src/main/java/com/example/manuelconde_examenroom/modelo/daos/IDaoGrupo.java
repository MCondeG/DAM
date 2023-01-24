package com.example.manuelconde_examenroom.modelo.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.manuelconde_examenroom.modelo.entidades.Grupo;
import com.example.manuelconde_examenroom.modelo.relaciones.Grupo_Alumnos;

import java.util.List;


@Dao
public interface IDaoGrupo {

    //  CRUD
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void crearGrupo(Grupo grupo);
    @Delete
    public void borrarGrupo(Grupo grupo);
    @Update
    public void modificarGrupo(Grupo grupo);
    @Query("SELECT * FROM grupo WHERE id_grupo LIKE :id_grupo")
    public Grupo verGrupo(int id_grupo);
    @Query("SELECT * FROM grupo WHERE nombre LIKE :nombre")
    public Grupo verGrupo(String nombre);
    @Query("SELECT * FROM grupo")
    public List<Grupo> verGrupos();

    @Transaction
    @Query("SELECT * FROM grupo WHERE id_grupo LIKE :id_grupo")
    public List<Grupo_Alumnos> verAlumnosTutorizados(int id_grupo);
}