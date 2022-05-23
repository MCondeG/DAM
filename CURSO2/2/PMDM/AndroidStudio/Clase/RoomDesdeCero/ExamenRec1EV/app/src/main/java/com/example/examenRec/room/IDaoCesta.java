package com.example.examenRec.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface IDaoCesta {

    @Query("SELECT * FROM cesta")
    public List<Cesta> getcesta();
    @Insert
    public void insertarCesta(Cesta cesta);
    @Delete
    public void borrarCesta(Cesta cesta);

    @Query("DELETE FROM cesta")
    public void borrarTabla();

}
