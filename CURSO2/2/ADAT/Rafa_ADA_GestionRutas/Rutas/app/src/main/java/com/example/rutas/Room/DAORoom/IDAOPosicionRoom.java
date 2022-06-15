package com.example.rutas.Room.DAORoom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.rutas.Room.EntidadesRoom.PosicionRoom;

import java.util.List;

@Dao
public interface IDAOPosicionRoom {

    @Insert
    public void crearPosicion(PosicionRoom pos);

    @Delete
    public void borrarPosicion(PosicionRoom pos);

    @Update
    public void modificarPosicion(PosicionRoom pos);

    @Query("SELECT * FROM posicion WHERE idposicion LIKE :id")
    public PosicionRoom verPosicion(int id);

    @Query("SELECT * FROM posicion WHERE descripcion LIKE :descripcion")
    public PosicionRoom verPosicion(String descripcion);

    @Query("SELECT * FROM posicion")
    public List<PosicionRoom> verPosiciones();
}
