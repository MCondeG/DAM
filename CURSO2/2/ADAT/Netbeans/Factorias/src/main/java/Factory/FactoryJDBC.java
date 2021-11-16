package Factory;

import Class.Student;
import Inteface.IDAOStudent;
import Inteface.IDAOTeacher;
import java.util.ArrayList;

public class FactoryJDBC implements IFactoryManager, IDAOStudent {
    @Override
    public IDAOStudent getDAOStudent(String dao) {
        if (dao == "JDBC") {
            System.out.println("JDBC");
        } else {
            System.out.println("JPA");
        }
        
        return null;
    }

    @Override
    public IDAOTeacher getDAOTeacher(String dao) {        
        if (dao == "JDBC") {
            System.out.println("JDBC");
            ReadStudents();
        } else {
            System.out.println("JPA");
        }
        
        return null;
    }

    @Override
    public void CreateStudent(Student student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student ReadStudentByID(int studentID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Student> ReadStudents() {
        System.out.println("hola");
        return null;
    }

    @Override
    public void UpdateStudent(Student student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteStudent(int studentID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
