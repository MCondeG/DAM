package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBConnection {
    //Atributos:
    private Connection dbConnection = null;
    private PreparedStatement sqlStatement = null;
    private ResultSetMetaData metaData;
    private ResultSet dbRecords;
    
    private String dbURL;
    private String dbType;
    private String dbName;
    private String username;
    private String password;
    
    private String[] columns;
    
    private int numberOfColumns;
    
    //Constructores:
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
    
    //Métodos:
    public void openDBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Registra el driver de conexión para conectar la BD.
            dbConnection = DriverManager.getConnection(this.dbURL, this.username, this.password); //Establecemos la conexión enviando por parametros los datos de acceso.
            System.out.println("\nBD connection succeeds!");
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
            this.sqlStatement = this.dbConnection.prepareStatement(sqlQuery); //Prepare Statement es una sentencia SQL precompilada.
            this.dbRecords = this.sqlStatement.executeQuery(); //Ejecuto la sentencia SQL y la almaceno en una variable de registros.
            this.metaData = this.dbRecords.getMetaData(); //Recupera los metadatos de la transformación de Java en tiempo de ejecución.
            
            numberOfColumns = metaData.getColumnCount(); //Recupera el número de columnas  y lo almacena en una variable global.
            
            System.out.println("\nRegistros:\n");
            
            while (this.dbRecords.next()) {
                for (int i = 1; i <= this.numberOfColumns; i++) {
                    System.out.print(this.dbRecords.getString(i) + "\t");
                }
                
                System.out.println();
            }
            
            //this.dbRecords.beforeFirst();            
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
            
            this.dbRecords.beforeFirst(); //Mueve el puntero del objeto a la posición predeterminada.
        } catch (SQLException ex) {
            System.out.println("Error when counting the number of records in the DB.");
            System.out.println("ERROR: " + ex);
        }

        return number;
    }
    
    public int getNumberOfColumns(){
        try {
            return this.metaData.getColumnCount(); //Devuelve el número de columnas que contiene un ResultSet.
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
