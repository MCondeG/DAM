/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.entidades.Parte;
import modelo.interfacesDaos.*;

/**
 *
 * @author usuario
 */
public class DaoParte extends Dao implements IDaoParte {
    
    private ArrayList<Parte> partes;
    
    
    public DaoParte() throws SQLException {
        
        this.entidad = "Parte";
        this.rs = mapearRegistros(this.entidad, super.getConexion(), this.rs);
        
        this.partes = new ArrayList<>();
                    
        while(this.rs.next()) {
            this.partes.add(new Parte(this.rs.getInt("idParte")));
        }
        //this.rs.beforeFirst();
    }

    
    public ArrayList<Parte> getPartes() {
        return partes;
    }

    public void setPartes(ArrayList<Parte> partes) {
        this.partes = partes;
    }
    
    
    @Override
    public void crearParte() {
        
        String sql = "insert into Parte (Profesor_idProfesor, Alumno_idAlumno, Incidencia_idIncidencia) values (2, 2, 2);";

        boolean exito = super.getConexion().ejecutarUpdate(sql);

        if (exito) System.out.println("Parte insertado con éxito");
        else System.out.println("Error");    
    }

    @Override
    public void modificarParte(int idParte) {

        String sql = "update from Parte set Profesor_idProfesor = 1 Alumno_idAlumno = 1 Incidencia_idIncidencia = 1 where Parte.idParte = " + idParte + ";";

        boolean exito = super.getConexion().ejecutarUpdate(sql);

        if (exito) System.out.println("Parte modificado con éxito");
        else System.out.println("Error");    
    }

    @Override
    public void borrarParte(int idParte) {
        
        String sql = "delete from Parte where Parte.idParte = " + idParte + ";";

        boolean exito = super.getConexion().ejecutarUpdate(sql);

        if (exito) System.out.println("Parte borrado con éxito");
        else System.out.println("Error");   
    }

    @Override
    public ArrayList<Parte> obtenerPartes() {
        
        try {
            ArrayList<Parte> partes = new ArrayList<>();
            
            String sql = "select * from Parte;";
            
            ResultSet rsPartes = super.getConexion().ejecutarSQL(sql);
            
            while(rsPartes.next()) {
                partes.add(new Parte(rsPartes.getInt("idParte")));
            }
            
            return partes;
        } catch (SQLException ex) {
            Logger.getLogger(DaoAlumno.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}