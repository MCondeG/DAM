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
import modelo.entidades.Grupo;
import modelo.entidades.Parte;
import modelo.interfacesDaos.*;

/**
 *
 * @author usuario
 */
public class DaoGrupo extends Dao implements IDaoGrupo {
    
    private ArrayList<Grupo> grupos;
    
    
    public DaoGrupo() throws SQLException {
        
        this.entidad = "Grupo";
        this.rs = mapearRegistros(this.entidad, super.getConexion(), this.rs);
        
        this.grupos = new ArrayList<>();
                    
        while(this.rs.next()) {
            this.grupos.add(new Grupo(this.rs.getInt("idGrupo"), this.rs.getString("nombre")));
        }
        //this.rs.beforeFirst();
    }

    
    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    
    @Override
    public int contarPartesGrupo(int idGrupo) {

        try {
            int numPartes = 0;
            ArrayList<Parte> partes = new ArrayList<>();
            
            String sql = "select * from Alumno, Parte where Parte.Alumno_idAlumno = Alumno.idAlumno and Alumno.Grupo_idGrupo = " + idGrupo + ";";
            
            ResultSet rsPartes = super.getConexion().ejecutarSQL(sql);
            
            while(rsPartes.next()) {
                partes.add(new Parte(rsPartes.getInt("idParte")));
                numPartes++;
            }
            
            return numPartes;
        } catch (SQLException ex) {
            Logger.getLogger(DaoGrupo.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }   
}