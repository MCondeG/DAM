package com.example.pruebatoolbar_1.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pruebatoolbar_1.db.daos.DaoProfesor;
import com.example.pruebatoolbar_1.db.entidades.Profesor;

@Database(
        entities={Profesor.class},
        version =1
)

public abstract class ConexionBD extends RoomDatabase {

    public abstract DaoProfesor DaoProfesor();


    private static volatile ConexionBD INSTANCE;

    public static  ConexionBD getConexion(final Context context){
        if (INSTANCE==null){
            synchronized(ConexionBD.class){
                if(INSTANCE==null){
                    INSTANCE= Room.databaseBuilder(
                            context.getApplicationContext(),
                            ConexionBD.class,
                            "gpdisbd").build();
                }
            }
        }
        return INSTANCE;
    }

}
