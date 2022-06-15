package com.example.rutas.Room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.rutas.Room.DAORoom.IDAOPosicionRoom;
import com.example.rutas.Room.DAORoom.IDAORutaRoom;
import com.example.rutas.Room.DAORoom.IDAOTramoRoom;
import com.example.rutas.Room.EntidadesRoom.PosicionRoom;
import com.example.rutas.Room.EntidadesRoom.RutaRoom;
import com.example.rutas.Room.EntidadesRoom.TramoRoom;

@Database(entities={PosicionRoom.class, TramoRoom.class, RutaRoom.class},version=2)
public abstract class AppDB extends RoomDatabase {

    public static AppDB INSTANCE;

    public abstract IDAOPosicionRoom daoPosicion();
    public abstract IDAOTramoRoom daoTramo();
    public abstract IDAORutaRoom daoRuta();


    public static AppDB getAppDB(Context context){
        if(INSTANCE==null){

            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),AppDB.class,
                    Constante.NOMBRE_DB)
                    .allowMainThreadQueries()
                   .addMigrations(MIGRATION_1_2)
                    .build();

        }
        return INSTANCE;
    }



    public void destroyInstance(){
        INSTANCE=null;
    }

    static final Migration MIGRATION_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

       //  database.execSQL("DROP TABLE posicion");
         database.execSQL("CREATE TABLE posicion(longitud REAL, latitud REAL,descripcion TEXT,idposicion INTEGER PRIMARY KEY NOT NULL)");
       //  database.execSQL("DROP TABLE tramo");
         database.execSQL("CREATE TABLE tramo(nodo_final REAL, descripcion TEXT,nodo_inicial REAL,idposicionF INTEGER NOT NULL," +
                    "idtramo INTEGER PRIMARY KEY NOT NULL, FOREIGN KEY (idposicionF) REFERENCES posicion (idposicion) ON DELETE CASCADE)");

         database.execSQL("CREATE TABLE ruta(idruta INTEGER PRIMARY KEY NOT NULL,velocidad_real REAL,idtramoF INTEGER NOT NULL,descripcion TEXT,distancia_real REAL,FOREIGN KEY (idtramoF) REFERENCES tramo (idtramo) ON DELETE CASCADE)");

        }
    };
}