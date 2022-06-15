package com.example.rutas.SQL.DAOSQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rutas.SQL.EntidadesSQL.PosicionSQLite;
import com.example.rutas.SQL.GestionPosicion;

import java.util.ArrayList;

public class DaoPosicionSQLite extends Dao implements IDaoPosicionSQLite{

    private GestionPosicion gdep;
    private SQLiteDatabase conexion;

    public DaoPosicionSQLite(){
        this.gdep=(GestionPosicion)Dao.gestorBd;

    }

    @Override
    public void crearPosicionSQlite(PosicionSQLite pos) {
        conexion =gdep.getWritableDatabase();
        //Una forma de insertar parametrizada

        ContentValues registro =new ContentValues();
        registro.put("descripcion",pos.getDescripcion());
        registro.put("latitud",pos.getLatitud());
        registro.put("longitud",pos.getLongitud());

        conexion.insert("posicion",null,registro);

        conexion.close();
    }

    @Override
    public void eliminarPosicionSQlite(int id) {

    }

    @Override
    public PosicionSQLite verPosicionSQlite(int id) {

        PosicionSQLite pos=new PosicionSQLite();


        String consulta="SELECT * FROM posicion WHERE idposicion="+id;
        conexion =gdep.getWritableDatabase();
        Cursor c= conexion.rawQuery(consulta,null);
        if (c.moveToFirst()){

            pos.setIdposicion(c.getInt(0));
            pos.setDescripcion(c.getString(1));
            pos.setLongitud(c.getFloat(2));
            pos.setLatitud(c.getFloat(3));
        }


        conexion.close();
        return pos;
    }

    @Override
    public ArrayList<PosicionSQLite> verPosicionesSQlite() {

        ArrayList<PosicionSQLite> posiciones = new ArrayList<>();
        conexion =gdep.getWritableDatabase();
        String consulta = "SELECT * FROM posicion";
        Cursor c = conexion.rawQuery(consulta, null);
        if (c.moveToFirst()) {

            do {
                PosicionSQLite pos = new PosicionSQLite();
                pos.setIdposicion(c.getInt(0));
                pos.setDescripcion(c.getString(1));
                pos.setLongitud(c.getFloat(2));
                pos.setLatitud(c.getFloat(3));
                posiciones.add(pos);
            } while (c.moveToNext());

        }
        conexion.close();
        return posiciones;
    }

    @Override
    public void actualizarPosicionSQlite(PosicionSQLite pos) {

    }
}
