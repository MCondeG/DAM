package com.example.rutas.SQL.DAOSQLite;

import com.example.rutas.SQL.EntidadesSQL.PosicionSQLite;

import java.util.ArrayList;

public interface IDaoPosicionSQLite {

    public void crearPosicionSQlite(PosicionSQLite pos);
    public void eliminarPosicionSQlite (int id);
    public PosicionSQLite verPosicionSQlite(int id);
    public ArrayList<PosicionSQLite> verPosicionesSQlite();
    public void actualizarPosicionSQlite (PosicionSQLite pos);
}
