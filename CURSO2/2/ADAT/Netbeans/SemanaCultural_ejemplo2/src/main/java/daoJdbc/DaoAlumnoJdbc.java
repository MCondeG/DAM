
package daoJdbc;

import modelo.Alumno;
import conexionJdbc.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoAlumnoJdbc implements DaoAlumno{ 
    
    ConexionBD con = new ConexionBD("mysql", "semanaCultural", "root", "admin");
    Alumno a;
    
    @Override
    public List<Alumno> readAlumno() {
        ArrayList<Alumno> lista = new ArrayList<>();
        ResultSet res=con.ejecutarSQL("select * from semanaCultural.alumno;");
        
        try {
            while (con.getResultSet().next()) {
                Alumno al = new Alumno();                 
                al.setId_alumno(res.getInt(1));
                al.setNombreUsuario(res.getString(2));
                al.setPassword(res.getString(3));
                al.setNombre(res.getString(4));
                al.setId_grupo(res.getInt(5));
                lista.add(al);
            }   
        } catch (SQLException ex) {}
        return lista;
    }
    
   @Override
    public void createAlumno(int id, String usuario, String password, String nombre, int id_grupo) {
        con.ejecutarInsert("insert into semanaCultural.alumno values ("+id+", '"+usuario+"','"+password+"','"+nombre+"',"+id_grupo+");");
    }
    
    @Override
    public void deleteAlumno(int id) {
        con.abrirConexion();
        con.ejecutarDelete("delete from semanaCultural.alumno where id_alumno="+id+";");
    }
    
    @Override
    public void updateAlumno(int id, String password) {
        con.abrirConexion();      
        con.ejecutarUpdate("update semanaCultural.alumno set password='"+password+"' where id_alumno="+id+";");
    }  

    @Override
    public Alumno readForIdAlumno(int id) {
        con.abrirConexion();
        ResultSet res=con.ejecutarSQL("select * from semanaCultural.alumno where id_alumno="+id+";");        
        try {
            a = new Alumno();
            while (con.getResultSet().next()) {                
                a.setId_alumno(res.getInt(1));
                a.setNombreUsuario(res.getString(2));
                a.setPassword(res.getString(3));
                a.setNombre(res.getString(4));
                a.setId_grupo(res.getInt(5));
            }   
        } catch (SQLException ex) {}
        return a;
    }
}