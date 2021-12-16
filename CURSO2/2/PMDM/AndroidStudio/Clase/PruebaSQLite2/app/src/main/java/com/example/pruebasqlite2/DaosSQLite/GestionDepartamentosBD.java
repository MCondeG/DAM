package com.example.pruebasqlite2.DaosSQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pruebasqlite2.InterfacesDAO.IDaoDepartamento;

public class GestionDepartamentosBD extends SQLiteOpenHelper  {
    String sqlCreate1="CREATE TABLE Departamentos (idDep INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,observaciones TEXT)";
    String sqlCreate2="CREATE TABLE Profesores (idPro INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,observaciones TEXT, FOREIGN KEY (departamento) REFERENCES Departamentos (idDep))";
    //Al guardar en profesores hay que ejecutar SQL="PRAGMA foreign_keys=ON"

   public GestionDepartamentosBD(Context context){

       super(context,"BDDepartamentos2",null,1);


   }
    //Solo llama a este método si la base de datos no existe
    @Override
    public void onCreate(SQLiteDatabase db)

    {
        db.execSQL(sqlCreate1);
        db.execSQL(sqlCreate2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void borrarTablas(){
        String sql1="DROP TABLE Departamentos";
        String sql2="DROP TABLE Profesores";
        SQLiteDatabase conexion=getWritableDatabase();
        conexion.execSQL(sql1);
        conexion.execSQL(sql2);
        conexion.close();
   }



}
