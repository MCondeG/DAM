package com.example.examenRec.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Producto.class,Usuario.class,Cesta.class}, version =2)
public abstract class BaseDatos extends RoomDatabase {

    public static BaseDatos INSTANCE;

    public abstract IDaoProducto daoProducto();
    public abstract IDaoUsuario daoUsuario();
    public abstract IDaoCesta daoCesta();

    public static BaseDatos getBaseDatos(Context context) {
        if (INSTANCE == null) {

            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),BaseDatos.class,
                    "DietaBD2").allowMainThreadQueries().build();
            //Con migracion hay que incrementar la version y añadirle que migracion
            /*INSTANCE = Room.databaseBuilder(context.getApplicationContext(),BaseDatos.class,
                    "DietaBD").addMigrations(MIGRATION1_2).allowMainThreadQueries().build();*/
        }
        return INSTANCE;
    }

    public void destroyInstance() {
        INSTANCE = null;
    }

    /*
    static final Migration MIGRATION1_2 = new Migration(1, 2) {

        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

            database.execSQL("ALTER TABLE Receta ADD COLUMN racion INTEGER");
            database.execSQL("ALTER TABLE Receta ADD COLUMN prueba INTEGER");
            /*database.execSQL("CREATE TABLE dieta (id_dieta INTEGER PRIMARY KEY "+
                    "NOT NULL,  nombre TEXT NOT NULL, observaciones TEXT NOT NULL)");

            //database.execSQL("CREATE TABLE menu_receta(dietaId INTEGER, recetaId INTEGER, foreign key(dietaId) references dieta(id_dieta), foreign key(recetaId) references receta(id_receta))");

        }
    };
    */


}
