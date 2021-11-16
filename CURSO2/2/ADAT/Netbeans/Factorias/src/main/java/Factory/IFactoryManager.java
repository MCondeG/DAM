package Factory;

import  Factory.FactoryJDBC;
import  Factory.FactoryJPA;
import Inteface.IDAOStudent;
import Inteface.IDAOTeacher;

public interface IFactoryManager {
    public IDAOStudent getDAOStudent(String dao);
    public IDAOTeacher getDAOTeacher(String dao);
}
