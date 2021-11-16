package Main;

import Factory.AbstractFactory;
import Factory.IFactoryManager;
import Inteface.IDAOStudent;
import Inteface.IDAOTeacher;

public class Main {
    public static void main(String[] args) {
        AbstractFactory af = new AbstractFactory();
        IFactoryManager fm = af.factoryJDBC;
        
        IDAOTeacher dt = fm.getDAOTeacher("JDBC");
        
        //dt.ReadTeachers();
        
        
    }
}
