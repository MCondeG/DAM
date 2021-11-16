
package daoJdbc;

import modelo.Profesor;
import conexionJdbc.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoProfesorJdbc implements DaoProfesor{
    
    ConexionBD con = new ConexionBD("mysql", "semanaCultural", "root", "admin");
    Profesor p;
    
    @Override
    public List<Profesor> readProfesor() {
        ArrayList<Profesor> p = new ArrayList<>();
        ResultSet res=con.ejecutarSQL("select * from semanaCultural.profesor;");
        
        try {
            while (con.getResultSet().next()) {
                Profesor prof = new Profesor();                 
                prof.setId_profesor(res.getInt(1));
                prof.setNombreUsuario(res.getString(2));
                prof.setPassword(res.getString(3));
                prof.setNombre(res.getString(4));
                p.add(prof);
            }   
        } catch (SQLException ex) {}
        return p;
    }
    
   @Override
    public void createProfesor(int id, String usuario, String password, String nombre) {
        con.ejecutarInsert("insert into semanaCultural.profesor values ("+id+", '"+usuario+"','"+password+"','"+nombre+"');");
    }
    
    @Override
    public void deleteProfesor(int id) {
        con.abrirConexion();
        con.ejecutarDelete("delete from semanaCultural.profesor where id_profesor="+id+";");
    }
    
    @Override
    public void updateProfesor(int id, String password) {
        con.abrirConexion();      
        con.ejecutarUpdate("update semanaCultural.profesor set password='"+password+"' where id_profesor="+id+";");
    }  

    @Override
    public Profesor readForIdProfesor(int id) {
        con.abrirConexion();
        ResultSet res=con.ejecutarSQL("select * from semanaCultural.profesor where id_profesor="+id+";");        
        try {
            p = new Profesor();
            while (con.getResultSet().next()) {                
                p.setId_profesor(res.getInt(1));
                p.setNombreUsuario(res.getString(2));
                p.setPassword(res.getString(3));
                p.setNombre(res.getString(4));         
            }   
        } catch (SQLException ex) {}
        return p;
    }
}
