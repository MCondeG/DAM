/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author usuario
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


/**
 *
 * @author enrique
 */
public class ConexionBD {

    private String drivermysql="com.mysql.jdbc.Driver";
    private String url=null;
    private Connection conexion=null;
    private PreparedStatement sentencia=null;
    private ResultSet registros;
    private ResultSetMetaData metadatos;
    private int numeroColumnas;
    private String[] columnas;
    private String usuario;
    private String pass;


    public ConexionBD(String tipo,String nombreBD,String usuario,String pass){
        url="jdbc:mysql://localhost:3306/"+nombreBD;
        this.usuario=usuario;
        this.pass=pass;
        if(tipo.equals("mysql")){
            try{
                Class.forName(drivermysql);
                conexion=DriverManager.getConnection(url, usuario, pass);
                System.out.println("exito");

            }catch(Exception e){
                System.out.println("error");

            }


        }
    }
    
    
    public void abrirConexion(){
         try{
                Class.forName(drivermysql);
                conexion=DriverManager.getConnection(url, usuario, pass);
                System.out.println("exito");

            }catch(Exception e){
                System.out.println("error");

            }
        
    }
    public boolean ejecutarUpdate(String sql){
        
        try {
            sentencia = conexion.prepareStatement(sql);
            sentencia.executeUpdate();
        
            return true;

        } catch (SQLException ex) {
            return false;
        }
        
    }
    public ResultSet ejecutarSQL(String sql){
        try {
            sentencia = conexion.prepareStatement(sql);
            this.registros=sentencia.executeQuery();
            metadatos=registros.getMetaData();
            numeroColumnas=metadatos.getColumnCount();
            this.nombreColumnas();
            return registros;

        } catch (SQLException ex) {
            return null;
        }
    }
    public void cerrarConexion(){
        try {
             registros.close();
             sentencia.close();
             conexion.close();
        } catch (SQLException ex) {

        }

    }
    public int getNumeroColumnas(){
        try {
            return metadatos.getColumnCount();
        } catch (SQLException ex) {
           return 0;
        }
    }
    private  void nombreColumnas(){
       columnas = new String[numeroColumnas];
       for(int i=0;i<columnas.length;i++){
            try {
               columnas[i] = metadatos.getColumnName(i);
            } catch (SQLException ex) {   }
       }

    }
    public void mostrarColumnas(){
          for(int i=0;i<columnas.length;i++)

               System.out.println( columnas[i]);


    }
    public void mostrarRegistrosln(){

        try {
            while (registros.next()) {
                for(int i=1;i<=numeroColumnas;i++)
                        System.out.print( registros.getString(i)+"  ");
                System.out.println();
            }
            registros.beforeFirst();
        } catch (SQLException ex) {}

    }
     public void mostrarRegistros(){

        try {
            while (registros.next()) {
                for(int i=1;i<=numeroColumnas;i++)
                        System.out.print( registros.getString(i)+"  ");
              
            }
            registros.beforeFirst();

        } catch (SQLException ex) {}

    }
      public int numRegistros(){
         int num=0;
         try {
            while (registros.next()) {
               num++;

            }
            registros.beforeFirst();

        } catch (SQLException ex) {}

         return num;
     }
      public String [][] getRegistros(){
           int num=this.numRegistros();
           String [][] tabla=new String [num][this.numeroColumnas];
           try {
           for (int i=0;i<num;i++) {
                for(int j=1;j<=numeroColumnas;j++)
                       tabla[i][j]=registros.getString(j);

            }
            registros.beforeFirst();
        } catch (SQLException ex) {}

          return tabla;
      }
      public void imprimirTabla(){

          String[][] tabla=this.getRegistros();
           for (int i=0;i<tabla.length;i++) {
                for(int j=0;j<numeroColumnas;j++){
                      System.out.print( tabla[i][j]+"  ");
                }
                System.out.println();
            }



      }


}
