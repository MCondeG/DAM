/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.daos;

import modelo.interfaces.IDAOAlimento;
import utilidades.ConexionBD;

/**
 *
 * @author manuelconde
 */
public class DAOAlimento implements IDAOAlimento {
    
    private ConexionBD conexion;
    
    
    public DAOAlimento() {
    }
    
    public DAOAlimento(ConexionBD conexion) {
        
        this.conexion = conexion;
    }

    @Override
    public boolean createAlimento() {
        
        conexion.abrirConexion();
        conexion.ejecutarSQL("insert into mydb.alimento values("queso","20","24","2.5")");
    }
}