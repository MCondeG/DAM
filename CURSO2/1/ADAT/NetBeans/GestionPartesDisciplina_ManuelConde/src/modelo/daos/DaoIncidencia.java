/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.daos;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.entidades.Incidencia;
import modelo.interfacesDaos.*;

/**
 *
 * @author usuario
 */
public class DaoIncidencia extends Dao implements IDaoIncidencia {
    
    private ArrayList<Incidencia> incidencias;
    
    
    public DaoIncidencia() throws SQLException {
        
        this.entidad = "Incidencia";
        this.rs = mapearRegistros(this.entidad, super.getConexion(), this.rs);
        
        this.incidencias = new ArrayList<>();
                    
        while(this.rs.next()) {
            this.incidencias.add(new Incidencia(this.rs.getInt("idIncidencia"), this.rs.getString("tipo")));
        }
        //this.rs.beforeFirst();
    }

    
    public ArrayList<Incidencia> getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(ArrayList<Incidencia> incidencias) {
        this.incidencias = incidencias;
    }
}