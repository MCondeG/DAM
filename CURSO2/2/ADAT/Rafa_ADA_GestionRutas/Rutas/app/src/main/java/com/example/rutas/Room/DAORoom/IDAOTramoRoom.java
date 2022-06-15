package com.example.rutas.Room.DAORoom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.rutas.Room.EntidadesRoom.TramoRoom;

import java.util.List;

@Dao
public interface IDAOTramoRoom {

    @Insert
    public void crearTramo(TramoRoom tramo);

    @Delete
    public void borrarTramo(TramoRoom tramo);

    @Update
    public void modificarTramo(TramoRoom tramo);

    @Query("SELECT * FROM tramo WHERE idtramo LIKE :id")
    public TramoRoom verTramo(int id);

    @Query("SELECT * FROM tramo WHERE descripcion LIKE :descripcion")
    public TramoRoom verTramo(String descripcion);

    @Query("SELECT * FROM tramo")
    public List<TramoRoom> verTramos();
}
