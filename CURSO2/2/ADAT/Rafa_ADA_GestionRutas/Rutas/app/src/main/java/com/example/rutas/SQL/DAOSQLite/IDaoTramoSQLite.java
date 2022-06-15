package com.example.rutas.SQL.DAOSQLite;

import com.example.rutas.SQL.EntidadesSQL.PosicionSQLite;
import com.example.rutas.SQL.EntidadesSQL.TramoSQLite;

import java.util.ArrayList;

public interface IDaoTramoSQLite {

    public void crearTramoSQlite(TramoSQLite tramo);
    public void eliminarTramoSQlite (int id);
    public TramoSQLite verTramoSQlite(int id);
    public ArrayList<TramoSQLite> verTramosSQlite();
    public void actualizarTramoSQlite (TramoSQLite tramo);
}
