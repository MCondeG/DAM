package com.example.rutas.SQL.DAOSQLite;

import com.example.rutas.SQL.EntidadesSQL.RutaSQLite;
import com.example.rutas.SQL.EntidadesSQL.TramoSQLite;

import java.util.ArrayList;

public interface IDaoRutaSQLite {

    public void crearRutaSQlite(RutaSQLite ruta);
    public void eliminarRutaSQlite (int id);
    public RutaSQLite verRutaSQlite(int id);
    public ArrayList<RutaSQLite> verRutasSQlite();
    public void actualizarTramoSQlite (RutaSQLite ruta);
}
