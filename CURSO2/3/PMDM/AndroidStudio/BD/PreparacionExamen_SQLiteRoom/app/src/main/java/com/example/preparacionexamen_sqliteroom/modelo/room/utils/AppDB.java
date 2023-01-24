package com.example.preparacionexamen_sqliteroom.modelo.room.utils;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.preparacionexamen_sqliteroom.modelo.room.daos.IDaoAlumno;
import com.example.preparacionexamen_sqliteroom.modelo.room.daos.IDaoAsignatura;
import com.example.preparacionexamen_sqliteroom.modelo.room.daos.IDaoTutor;
import com.example.preparacionexamen_sqliteroom.modelo.room.entidades.Alumno;
import com.example.preparacionexamen_sqliteroom.modelo.room.entidades.AlumnoAsignatura_CrossRef;
import com.example.preparacionexamen_sqliteroom.modelo.room.entidades.Asignatura;
import com.example.preparacionexamen_sqliteroom.modelo.room.entidades.Tutor;


@Database(entities = {Alumno.class, Tutor.class, Asignatura.class, AlumnoAsignatura_CrossRef.class}, version = 1)
public abstract class AppDB extends RoomDatabase {

    private static AppDB INSTANCE;
    public abstract IDaoAlumno daoAlumno();
    public abstract IDaoTutor daoTutor();
    public abstract IDaoAsignatura daoAsignatura();


    public static AppDB getAppDB(Context context) {

        if(AppDB.INSTANCE == null) AppDB.INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDB.class, Constantes.NOMBRE_DB).allowMainThreadQueries().build();

        return AppDB.INSTANCE;
    }

    public void destroyInstance(){
        AppDB.INSTANCE = null;
    }
}