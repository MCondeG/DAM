/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebajpa.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author rafa
 */
public class DBConnection {
    private Connection dbConnection = null;
    private PreparedStatement sqlStatement = null;
    private ResultSetMetaData metaData;
    private ResultSet dbRecords;
    
    private String dbURL;
    private String dbType;
    private String dbName;
    private String username;
    private String password;
    
    public DBConnection (String dbType, String dbName, String username, String password) {
        this.dbType = dbType;
        this.dbName = dbName;
        this.username = username;
        this.password = password;
        
        dbURL = "jdbc:mysql://localhost:3306/" + this.dbName;
        
        if (this.dbType.equalsIgnoreCase("mysql")) {
            this.openDBConnection();
        }
    }
    
    public void openDBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            dbConnection = DriverManager.getConnection(this.dbURL, this.username, this.password);
//            System.out.println("\nBD connection succeeds!\n");
        } catch (Exception e) {
            System.out.println("\nError to establish connection with the DB.");
            System.out.println("Error: " + e);
        }
    }
    
    public void closeDBConnection() throws SQLException{
        this.dbConnection.close();
    }
    
    public ResultSet runSQLQuery(String sqlQuery){
        try {
            this.sqlStatement = this.dbConnection.prepareStatement(sqlQuery); 
            this.dbRecords = this.sqlStatement.executeQuery(); 
            
            return dbRecords;
        } catch (SQLException ex) {
            System.out.println("Error executing SQL statement.");
            System.out.println("ERROR: " + ex);
            return null;
        }
    }
        
    public int numberOfRecordsDB(){
        int number = 0;
         
        try {
            while (this.dbRecords.next()) {
               number ++;
            }
        } catch (SQLException ex) {
            System.out.println("Error when counting the number of records in the DB.");
            System.out.println("ERROR: " + ex);
        }

        return number;
    }
    
    public int getNumberOfColumns(){
        try {
            return this.metaData.getColumnCount();
        } catch (SQLException ex) {
            System.out.println("Error when returning the number of columns of the 'ResultSet'");
           return 0;
        }
    }
    
    public boolean runUpdate(String sqlQuery){
        try {
            this.sqlStatement = dbConnection.prepareStatement(sqlQuery);
            this.sqlStatement.executeUpdate();
        
            return true;
        } catch (SQLException ex) {
            System.out.println("Error executing update query.");
            System.out.println("ERROR: " + ex);
            return false;
        }
    }
}
