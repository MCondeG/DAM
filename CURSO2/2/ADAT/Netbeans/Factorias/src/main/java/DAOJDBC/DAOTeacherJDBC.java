package DAOJDBC;

import Class.Teacher;
import BD.DBConnection;
import Inteface.IDAOTeacher;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class DAOTeacherJDBC implements IDAOTeacher {
    //Atributos:
    private DBConnection dbConnection;
    
    //Constructores:
    public DAOTeacherJDBC() {
       this.dbConnection = new DBConnection("mysql","semanaCultural","root","root");
    }
    
    //Métodos:
    @Override
    public void CreateTeacher(Teacher teacher) {
        String sqlQuery = "insert into profesor (id_profesor, nombreUsuario, nombre, password) values ('" + 
                teacher.getTeacherID() + "','" + teacher.getUsername()+ "','" + teacher.getName() + 
                "', '" + teacher.getPassword() + "')"; 
        boolean result = false;
       
        try {
            result = dbConnection.runUpdate(sqlQuery);
            
            if (result) {
                System.out.println("Successfully inserted teacher!");
            } else {
                System.out.println("The specified teacher could not be inserted.");
            }
        } catch (Exception e) {
            System.out.println("Error, the specified teacher could not be inserted.");
            System.out.println("ERROR: " + e);
        }
    }

    @Override
    public void UpdateTeacher(Teacher teacher) {
        String sqlQuery = "update semanaCultural.profesor set nombreUsuario = '" + teacher.getUsername() + "'," +
                "nombre = '" + teacher.getName() + "', password = '" + teacher.getPassword() + "' where id_profesor = " +
                teacher.getTeacherID();
        boolean result = false;
       
        try {
            result = dbConnection.runUpdate(sqlQuery);
            
            if (result) {
                System.out.println("Teacher updated successfully!");
            } else {
                System.out.println("The specified teacher could not be updated.");
            }
        } catch (Exception e) {
            System.out.println("Error, the specified teacher could not be updated.");
            System.out.println("ERROR: " + e);
        }
    }

    @Override
    public void DeleteTeacher(int teacherID) {
        String sqlQuery = "delete from profesor where id_profesor = " + teacherID;    
        boolean result = false;
       
        try {
            result = dbConnection.runUpdate(sqlQuery);
            
            if (result) {
                System.out.println("Teacher successfully eliminated!");
            } else {
                System.out.println("Failed to delete the specified teacher.");
            }
        } catch (Exception e) {
            System.out.println("Error, failed to remove the specified teacher.");
            System.out.println("ERROR: " + e);
        }
    }

    @Override
    public Teacher ReadTeacherByID(int teacherID) {
        String sqQuery="select * from profesor where id_profesor = '" + teacherID + "'";      
        Teacher teacher = null;
                
        try {
            ResultSet resultSet = dbConnection.runSQLQuery(sqQuery);
              
            if (dbConnection.numberOfRecordsDB() != 0) {
                resultSet.next();
                
                teacher = new Teacher();
                
                teacher.setTeacherID(resultSet.getInt(1));
                teacher.setUsername(resultSet.getString(2));
                teacher.setName(resultSet.getString(3));
                teacher.setPassword(resultSet.getString(4));                
            }
        } catch (Exception e){
            System.out.println("Error, failed to find the specified teacher.");
            System.out.println("ERROR: " + e);
        }
        
        return teacher;
    }

    @Override
    public ArrayList< Teacher > ReadTeachers() {
        ArrayList < Teacher > teachers = new ArrayList < Teacher > ();
        ResultSet resultSet = this.dbConnection.runSQLQuery("select * from profesor");
        
        int rows = this.dbConnection.numberOfRecordsDB();
        int columns = this.dbConnection.getNumberOfColumns();
        
        try {
           while (resultSet.next()) {
                Teacher teacher = new Teacher();
                
                teacher.setTeacherID(resultSet.getInt(1));
                teacher.setUsername(resultSet.getString(2));
                teacher.setName(resultSet.getString(3));
                teacher.setPassword(resultSet.getString(4));
                
                teachers.add(teacher);
            }
        } catch (SQLException ex) {
            System.out.println("Error, when searching and returning the 'ArrayList' of all teachers.");
            System.out.println("ERROR: " + ex);
        }
        
        return teachers;
    }
}
