package Vista;

import daoJdbc.DaoProfesorJdbc;
import daoJpa.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("semanaCultural_persistencia");            
        DaoProfesorJpa d= new DaoProfesorJpa(emf);
        DaoProfesorJdbc dw = new DaoProfesorJdbc();
        
        for (int i=0; i<d.verProfesores().size(); i++)
            System.out.println(d.verProfesores().get(i).getNombre());
        
    }
    
}
