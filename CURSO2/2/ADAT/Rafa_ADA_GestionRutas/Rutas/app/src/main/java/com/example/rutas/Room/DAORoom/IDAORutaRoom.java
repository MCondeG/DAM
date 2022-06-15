package com.example.rutas.Room.DAORoom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.rutas.Room.EntidadesRoom.RutaRoom;

import java.util.List;

@Dao
public interface IDAORutaRoom {

    @Insert
    public void crearRuta(RutaRoom ruta);

    @Delete
    public void borrarRuta(RutaRoom ruta);

    @Update
    public void modificarRuta(RutaRoom ruta);

    @Query("SELECT * FROM ruta WHERE idruta LIKE :id")
    public RutaRoom verRuta(int id);

    @Query("SELECT * FROM ruta WHERE descripcion LIKE :descripcion")
    public RutaRoom verRuta(String descripcion);

    @Query("SELECT * FROM ruta")
    public List<RutaRoom> verRutas();
}
