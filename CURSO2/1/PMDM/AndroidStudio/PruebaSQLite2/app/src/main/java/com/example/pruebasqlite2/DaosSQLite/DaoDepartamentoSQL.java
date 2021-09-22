package com.example.pruebasqlite2.DaosSQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.pruebasqlite2.InterfacesDAO.IDaoDepartamento;
import com.example.pruebasqlite2.pojos.Departamento;

import java.util.ArrayList;

public class DaoDepartamentoSQL extends Dao implements IDaoDepartamento {

    private GestionDepartamentosBD gdep;
    private SQLiteDatabase conexion;

    public DaoDepartamentoSQL(){
        this.gdep=(GestionDepartamentosBD)Dao.gestorBd;

    }



    @Override
    public void crearDepartamento(Departamento dep) {

       conexion =gdep.getWritableDatabase();
       //Una forma de insertar parametrizada

       ContentValues registro =new ContentValues();
       registro.put("nombre",dep.getNombre());
       registro.put("observaciones",dep.getObservaciones());
       conexion.insert("Departamentos",null,registro);

       conexion.close();


    }

    @Override
    public void eliminarDepartamento(int id) {



    }

    @Override
    public Departamento verDepartamento(int id) {



        Departamento dep=new Departamento();


        String consulta="SELECT * FROM Departamentos WHERE idDep="+id;
        conexion =gdep.getWritableDatabase();
        Cursor c= conexion.rawQuery(consulta,null);
        if (c.moveToFirst()){

                dep.setIdDep(c.getInt(0));
                dep.setNombre(c.getString(1));
                dep.setObservaciones(c.getString(2));
            }


        conexion.close();
        return dep;
    }

    @Override
    public ArrayList<Departamento> verDepartamentos() {


        ArrayList<Departamento> departamentos = new ArrayList<>();
        conexion =gdep.getWritableDatabase();
        String consulta = "SELECT * FROM Departamentos";
        Cursor c = conexion.rawQuery(consulta, null);
        if (c.moveToFirst()) {

            do {
                Departamento dep = new Departamento();
                dep.setIdDep(c.getInt(0));
                dep.setNombre(c.getString(1));
                dep.setObservaciones(c.getString(2));
                departamentos.add(dep);
            } while (c.moveToNext());

        }
        conexion.close();
        return departamentos;
    }
    @Override
    public void actualizarDepartamento(Departamento dep) {

    }
}
