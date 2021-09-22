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
import modelo.entidades.Profesor;
import modelo.interfacesDaos.*;

/**
 *
 * @author usuario
 */
public class DaoProfesor extends Dao implements IDaoProfesor {
    
    private ArrayList<Profesor> profesores;
    
    
    public DaoProfesor() throws SQLException {
        
        this.entidad = "Profesor";
        this.rs = mapearRegistros(this.entidad, super.getConexion(), this.rs);
        
        this.profesores = new ArrayList<>();
                    
        while(this.rs.next()) {
            this.profesores.add(new Profesor(this.rs.getInt("idProfesor"), this.rs.getString("nombre"), this.rs.getString("password"), this.rs.getString("observaciones")));
        }
        //this.rs.beforeFirst();
    }

    
    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }

    
    @Override
    public ArrayList<Parte> obtenerPartesProfesor(int idProfesor) {

        try {
            ArrayList<Parte> partes = new ArrayList<>();
            
            String sql = "select * from Parte, Profesor where Parte.Profesor_idProfesor = " + idProfesor +";";
            
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