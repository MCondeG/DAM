
import modelo.daos.DAOAlimento;
import modelo.entidades.Alimento;
import utilidades.ConexionBD;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author manuelconde
 */
public class Main {
    
    public static void main(String[] args) {
        
        ConexionBD conexion = new ConexionBD("mysql", "mydb", "root", "root");
        
        DAOAlimento a = new DAOAlimento();
        
        a.createAlimento();
    }
}