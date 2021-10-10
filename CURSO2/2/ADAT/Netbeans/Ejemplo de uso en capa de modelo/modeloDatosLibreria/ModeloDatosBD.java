/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modeloDatos;

import conexionbd.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author enrique
 */
public class ModeloDatosBD {

   
    
    private ConexionBD conexion;

    public ModeloDatosBD(){
       conexion=new ConexionBD("mysql","biblioteca","root","enrique");
    }
    
    public ArrayList<Libro> buscarLibros(){
        
        ArrayList<Libro> libros=new ArrayList<Libro>();
        ResultSet resultado=conexion.ejecutarSQL("select * from libros");
        
        int filas=conexion.numRegistros();
        int col=conexion.getNumeroColumnas();
           try {
           while(resultado.next()) {
                Libro libro=new Libro();
                libro.setIdLibro(resultado.getInt(1));
                libro.setTitulo(resultado.getString(2));
                libro.setAutor(resultado.getString(3));
                libro.setComentario(resultado.getString(4));
                libros.add(libro);

            }
           
        } catch (SQLException ex) {}
        return libros;
    }
    public Socio buscarSocio(String nombre, String pass){
        Socio socio=null;
        String sql="select * from socios where nombre='"+nombre+"' and "+"pass= '"+pass+"'";      
        
        try{
            conexion.abrirConexion();
            ResultSet resultado=conexion.ejecutarSQL(sql);
              
            if (conexion.numRegistros()!=0){
                resultado.next();
                socio=new Socio(nombre, pass);
                socio.setNombre(resultado.getString("nombre"));
                socio.setPerfil(resultado.getString("perfil"));
                
            }
            
        }catch (Exception e){
            System.out.println("error");
            
        }
        
        return socio;
    }
    public Libro buscarLibro(Integer id) {
        
        String sql="select * from libros where idLibro='"+id+"'";      
        Libro libro=null;
        try{
            conexion.abrirConexion();
            ResultSet resultado=conexion.ejecutarSQL(sql);
              
            if (conexion.numRegistros()!=0){
                resultado.next();
                libro=new Libro();
                libro.setIdLibro(resultado.getInt(1));
                libro.setTitulo(resultado.getString(2));
                libro.setAutor(resultado.getString(3));
                libro.setComentario(resultado.getString(4));
                
            }
            
        }catch (Exception e){
            System.out.println("error");
            
        }
        
        return libro;
      
    }
    public boolean insertarSocio (Socio socio){
        
        
        return true;
    }
    public boolean insertarLibro (Libro libro){
           
        boolean resultado=false;
        String sql="insert into libros (titulo, autor, comentario) values ('"+libro.getTitulo()+"','"+libro.getAutor()+"'";      
        sql+=",'"+libro.getComentario()+"')";
        try{
            conexion.abrirConexion();
            resultado=conexion.ejecutarUpdate(sql);
                      
        }catch (Exception e){
            System.out.println("error");
            return false;
        }
        
       
        
        
        return resultado;
    }
    public boolean borrarLibro(Integer id){
      boolean resultado=false;
        String sql="delete from libros where idLibro= "+id;      
       
        try{
            conexion.abrirConexion();
            resultado=conexion.ejecutarUpdate(sql);
                      
        }catch (Exception e){
            System.out.println("error");
            return false;
        }
        
       
        
        
        return resultado;
    }
    public boolean actualizarLibro(Libro libro){
        
        boolean resultado=false;
        String sql="update biblioteca.libros set titulo='"+libro.getTitulo()+"', autor= '"+libro.getAutor()+"'";      
        sql+=", comentario= '"+libro.getComentario()+"' where idLibro="+libro.getIdLibro();
        try{
            conexion.abrirConexion();
            resultado=conexion.ejecutarUpdate(sql);
                      
        }catch (Exception e){
            System.out.println("error");
            return false;
        }
        
       
        
        
        return resultado;
    }

    public int contarLibros() {
        int n=0;
        String sql="select count(*) from libros";      
       
        try{
            conexion.abrirConexion();
            ResultSet resultado=conexion.ejecutarSQL(sql);
            resultado.next();
            n=resultado.getInt(1);
            System.out.println();
            
            
        }catch (Exception e){
            System.out.println("error");
            
        }
        
        
        return n;
        
       
    }
}
