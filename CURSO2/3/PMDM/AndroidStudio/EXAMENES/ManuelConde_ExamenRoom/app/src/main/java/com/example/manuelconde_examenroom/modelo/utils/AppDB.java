package com.example.manuelconde_examenroom.modelo.utils;

import static java.sql.Types.NULL;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.manuelconde_examenroom.modelo.daos.IDaoAlumno;
import com.example.manuelconde_examenroom.modelo.daos.IDaoAsignatura;
import com.example.manuelconde_examenroom.modelo.daos.IDaoGrupo;
import com.example.manuelconde_examenroom.modelo.daos.IDaoProfesor;
import com.example.manuelconde_examenroom.modelo.entidades.Alumno;
import com.example.manuelconde_examenroom.modelo.entidades.AlumnoAsignatura_CrossRef;
import com.example.manuelconde_examenroom.modelo.entidades.Asignatura;
import com.example.manuelconde_examenroom.modelo.entidades.Grupo;
import com.example.manuelconde_examenroom.modelo.entidades.Profesor;


@Database(entities = {Alumno.class, Grupo.class, Asignatura.class, Profesor.class, AlumnoAsignatura_CrossRef.class}, version = 1)
public abstract class AppDB extends RoomDatabase {

    private static AppDB INSTANCE;
    public abstract IDaoAlumno daoAlumno();
    public abstract IDaoGrupo daoGrupo();
    public abstract IDaoAsignatura daoAsignatura();
    public abstract IDaoProfesor daoProfesor();


    public static AppDB getAppDB(Context context) {

        if(AppDB.INSTANCE == null) AppDB.INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDB.class, Constantes.NOMBRE_BD).allowMainThreadQueries().build();

        return AppDB.INSTANCE;
    }

    public void destroyInstance(){
        AppDB.INSTANCE = null;
    }


    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE departamento (id_departamento INTEGER PRIMARY KEY NOT NULL, nombre VARCHAR)");
        }
    };

    /*static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE profesor ADD CONSTRAINT (id_departamento) FOREIGN KEY (id_departamento) REFERENCES departamento(id_departamento)");
        }
    };*/
}