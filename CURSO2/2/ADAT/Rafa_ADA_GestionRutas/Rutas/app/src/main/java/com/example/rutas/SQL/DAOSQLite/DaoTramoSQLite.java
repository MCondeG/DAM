package com.example.rutas.SQL.DAOSQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rutas.SQL.EntidadesSQL.PosicionSQLite;
import com.example.rutas.SQL.EntidadesSQL.TramoSQLite;
import com.example.rutas.SQL.GestionPosicion;

import java.util.ArrayList;

public class DaoTramoSQLite extends Dao implements IDaoTramoSQLite{

    private GestionPosicion gdep;
    private SQLiteDatabase conexion;

    public DaoTramoSQLite(){
        this.gdep=(GestionPosicion)Dao.gestorBd;

    }



    @Override
    public void crearTramoSQlite(TramoSQLite tramo) {
        conexion =gdep.getWritableDatabase();
        //Una forma de insertar parametrizada

        ContentValues registro =new ContentValues();
        registro.put("descripcion",tramo.getDescripcion());
        registro.put("nodo_inicial",tramo.getNodo_inicial());
        registro.put("nodo_final",tramo.getNodo_final());
        registro.put("idposicionF",tramo.getIdposicionF());

        conexion.insert("tramo",null,registro);

        conexion.close();
    }

    @Override
    public void eliminarTramoSQlite(int id) {

    }

    @Override
    public TramoSQLite verTramoSQlite(int id) {
        TramoSQLite tramo=new TramoSQLite();


        String consulta="SELECT * FROM tramo WHERE idtramo="+id;
        conexion =gdep.getWritableDatabase();
        Cursor c= conexion.rawQuery(consulta,null);
        if (c.moveToFirst()){

            tramo.setIdtramo(c.getInt(0));
            tramo.setDescripcion(c.getString(1));
            tramo.setNodo_inicial(c.getFloat(2));
            tramo.setNodo_final(c.getFloat(3));
        }


        conexion.close();
        return tramo;
    }

    @Override
    public ArrayList<TramoSQLite> verTramosSQlite() {

        ArrayList<TramoSQLite> tramos = new ArrayList<>();
        conexion =gdep.getWritableDatabase();
        String consulta = "SELECT * FROM tramo";
        Cursor c = conexion.rawQuery(consulta, null);
        if (c.moveToFirst()) {

            do {
                TramoSQLite tramo = new TramoSQLite();
                tramo.setIdtramo(c.getInt(0));
                tramo.setDescripcion(c.getString(1));
                tramo.setNodo_inicial(c.getFloat(2));
                tramo.setNodo_final(c.getFloat(3));
                tramos.add(tramo);
            } while (c.moveToNext());

        }
        conexion.close();
        return tramos;
    }

    @Override
    public void actualizarTramoSQlite(TramoSQLite tramo) {

    }
}
