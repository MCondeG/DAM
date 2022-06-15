package com.example.rutas.SQL.DAOSQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rutas.SQL.EntidadesSQL.RutaSQLite;
import com.example.rutas.SQL.EntidadesSQL.TramoSQLite;
import com.example.rutas.SQL.GestionPosicion;

import java.util.ArrayList;

public class DaoRutaSQLite extends Dao implements IDaoRutaSQLite{
    private GestionPosicion gdep;
    private SQLiteDatabase conexion;

    public DaoRutaSQLite(){
        this.gdep=(GestionPosicion)Dao.gestorBd;

    }

    @Override
    public void crearRutaSQlite(RutaSQLite ruta) {
        conexion =gdep.getWritableDatabase();
        //Una forma de insertar parametrizada

        ContentValues registro =new ContentValues();
        registro.put("descripcion",ruta.getDescripcion());
        registro.put("distancia_real",ruta.getDistancia_real());
        registro.put("velocidad_real",ruta.getVelocidad_real());
        registro.put("idtramoF",ruta.getIdtramoF());

        conexion.insert("ruta",null,registro);

        conexion.close();
    }

    @Override
    public void eliminarRutaSQlite(int id) {

    }

    @Override
    public RutaSQLite verRutaSQlite(int id) {
        RutaSQLite ruta=new RutaSQLite();


        String consulta="SELECT * FROM ruta WHERE idruta="+id;
        conexion =gdep.getWritableDatabase();
        Cursor c= conexion.rawQuery(consulta,null);
        if (c.moveToFirst()){

            ruta.setIdruta(c.getInt(0));
            ruta.setDescripcion(c.getString(1));
            ruta.setDistancia_real(c.getFloat(2));
            ruta.setVelocidad_real(c.getFloat(3));
        }


        conexion.close();
        return ruta;
    }

    @Override
    public ArrayList<RutaSQLite> verRutasSQlite() {

        ArrayList<RutaSQLite> rutas = new ArrayList<>();
        conexion =gdep.getWritableDatabase();
        String consulta = "SELECT * FROM ruta";
        Cursor c = conexion.rawQuery(consulta, null);
        if (c.moveToFirst()) {

            do {
                RutaSQLite ruta = new RutaSQLite();
                ruta.setIdruta(c.getInt(0));
                ruta.setDescripcion(c.getString(1));
                ruta.setDistancia_real(c.getFloat(2));
                ruta.setVelocidad_real(c.getFloat(3));
                rutas.add(ruta);
            } while (c.moveToNext());

        }
        conexion.close();
        return rutas;
    }

    @Override
    public void actualizarTramoSQlite(RutaSQLite ruta) {

    }
}
