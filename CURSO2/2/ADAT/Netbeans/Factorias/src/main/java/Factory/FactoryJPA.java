package Factory;

import Inteface.IDAOStudent;
import Inteface.IDAOTeacher;

public class FactoryJPA implements IFactoryManager {
    @Override
    public IDAOStudent getDAOStudent(String dao) {
        if (dao == "JPA") {
            System.out.println("JPA");
        } else {
            System.out.println("JDBC");
        }
        
        return null;
    }

    @Override
    public IDAOTeacher getDAOTeacher(String dao) {
        if (dao == "JPA") {
            System.out.println("JPA");
        } else {
            System.out.println("JDBC");
        }
        
        return null;
    }
}
