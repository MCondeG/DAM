/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.daos;

import java.sql.ResultSet;
import modelo.ConexionBD;

/**
 *
 * @author usuario
 */
public class Dao{
    
    private ConexionBD conexion;
    protected String entidad;
    protected ResultSet rs;
    
    
    public Dao() {
        
        this.entidad = "";
        this.conexion = new ConexionBD("mysql", "instituto", "root", "root");
    }

    
    public ConexionBD getConexion() {
        return conexion;
    }

    public void setConexion(ConexionBD conexion) {
        this.conexion = conexion;
    }
    
    
    protected static ResultSet mapearRegistros(String entidad, ConexionBD conexion, ResultSet rs) {
        
        String sql = "select * from " + entidad + ";";
        
        rs = conexion.ejecutarSQL(sql);
        
        return rs;
    }
}