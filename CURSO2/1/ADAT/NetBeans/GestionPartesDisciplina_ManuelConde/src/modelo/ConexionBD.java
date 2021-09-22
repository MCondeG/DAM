/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Ahbyss
 */
public class ConexionBD {

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet registros;
    private ResultSetMetaData metadatos;
    private int numeroColumnas;
    private String[] columnas;
    private final String drivermysql;
    private final String url;
    private final String tipo;
    private final String nombreBD;
    private final String usuario;
    private final String pass;

    
    public ConexionBD(String tipo, String nombreBD, String usuario, String pass) {
        
        this.usuario = usuario;
        this.pass = pass;
        this.tipo = tipo;
        this.nombreBD = nombreBD;
        this.drivermysql = "com.mysql.cj.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:3306/" + this.nombreBD;
        this.sentencia = null;
        
        this.conexion = ConexionBD.abrirConexion(this.tipo, this.usuario, this.pass, this.drivermysql, this.url, null);
    }

    
    public static Connection abrirConexion(String tipo, String usuario, String pass, String drivermysql, String url, Connection conexion) {
        
        if (tipo.equals("mysql")) {
            try {
                Class.forName(drivermysql);
                conexion = DriverManager.getConnection(url, usuario, pass);
                System.out.println("exito");
                return conexion;
            } catch (Exception e) {
                System.out.println("error");
                return null;
            }
        }
        else return null;
    }

    public boolean ejecutarUpdate(String sql) {

        try {
            this.sentencia = this.conexion.prepareStatement(sql);
            this.sentencia.executeUpdate();

            return true;
        } catch (SQLException ex) {
            return false;
        }

    }

    public ResultSet ejecutarSQL(String sql) {
        
        try {
            this.sentencia = this.conexion.prepareStatement(sql);
            this.registros = this.sentencia.executeQuery();
            this.metadatos = this.registros.getMetaData();
            this.numeroColumnas = this.metadatos.getColumnCount();
            this.nombreColumnas();
            return this.registros;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void cerrarConexion() throws SQLException {
        
        if (this.registros != null) this.registros.close();
        if (this.sentencia != null) this.sentencia.close();
        if (this.conexion != null) this.conexion.close();
    }

    public int getNumeroColumnas() {
        
        try {
            return this.metadatos.getColumnCount();
        } catch (SQLException ex) {
            return 0;
        }
    }

    private void nombreColumnas() {
        
        this.columnas = new String[this.numeroColumnas];
        
        for (int i = 0; i < this.columnas.length; i++) {
            try {
                this.columnas[i] = this.metadatos.getColumnName(i);
            } catch (SQLException ex) {
            }
        }
    }

    public void mostrarColumnas() {
        for (int i = 0; i < this.columnas.length; i++) {
            System.out.println(this.columnas[i]);
        }

    }

    public void mostrarRegistrosln() {

        try {
            while (this.registros.next()) {
                for (int i = 1; i <= this.numeroColumnas; i++) {
                    System.out.print(this.registros.getString(i) + "  ");
                }
                System.out.println();
            }
            this.registros.beforeFirst();
        } catch (SQLException ex) {
        }
    }

    public void mostrarRegistros() {

        try {
            while (this.registros.next()) {
                for (int i = 1; i <= this.numeroColumnas; i++) {
                    System.out.print(this.registros.getString(i) + "  ");
                }
            }
            this.registros.beforeFirst();
        } catch (SQLException ex) {
        }
    }

    public int numRegistros() {
        int num = 0;
        try {
            while (this.registros.next()) {
                num++;

            }
            this.registros.beforeFirst();
        } catch (SQLException ex) {
        }

        return num;
    }

    public String[][] getRegistros() {
        int num = this.numRegistros();
        String[][] tabla = new String[num][this.numeroColumnas];
        try {
            for (int i = 0; i < num; i++) {
                for (int j = 1; j <= this.numeroColumnas; j++) {
                    tabla[i][j] = this.registros.getString(j);
                }
            }
            this.registros.beforeFirst();
        } catch (SQLException ex) {
        }

        return tabla;
    }

    public void imprimirTabla() {

        String[][] tabla = this.getRegistros();
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < this.numeroColumnas; j++) {
                System.out.print(tabla[i][j] + "  ");
            }
            System.out.println();
        }
    }
}