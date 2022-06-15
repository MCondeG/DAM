package com.example.rutas.SQL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class GestionPosicion extends SQLiteOpenHelper {

    String sqlCreate1="CREATE TABLE posicion (idposicion INTEGER PRIMARY KEY AUTOINCREMENT,descripcion TEXT,longitud REAL,latitud FLOAT)";
    String sqlCreate2="CREATE TABLE tramo (idtramo INTEGER PRIMARY KEY AUTOINCREMENT,idposicionF INTEGER NOT NULL,descripcion TEXT,nodo_inicial REAL,nodo_final FLOAT,FOREIGN KEY (idposicionF) REFERENCES posicion (idposicion) ON DELETE CASCADE)";
    String sqlCreate3="CREATE TABLE ruta (idruta INTEGER PRIMARY KEY AUTOINCREMENT,idtramoF INTEGER NOT NULL,descripcion TEXT,velocidad_real REAL,distancia_real FLOAT,FOREIGN KEY (idtramoF) REFERENCES tramo (idtramo) ON DELETE CASCADE)";

    public GestionPosicion(Context context){

        super(context,"Rutas",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)

    {
        db.execSQL(sqlCreate1);
        db.execSQL(sqlCreate2);
        db.execSQL(sqlCreate3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.setVersion(oldVersion);
    }

    public void borrarTablas(){
        String sql1="DROP TABLE posicion";
        String sql2="DROP TABLE tramo";
        String sql3="DROP TABLE ruta";
        SQLiteDatabase conexion=getWritableDatabase();
        conexion.execSQL(sql1);
        conexion.execSQL(sql2);
        conexion.execSQL(sql3);
        conexion.close();
    }

}
