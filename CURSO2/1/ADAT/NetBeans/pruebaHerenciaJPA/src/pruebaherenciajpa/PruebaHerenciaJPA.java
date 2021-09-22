/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaherenciajpa;

import controllers.TesterJpaController;
import entidades.Programador;
import entidades.Tester;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author enrique
 */
public class PruebaHerenciaJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      try{
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("pruebaHerenciaJPAPU");
 
   Tester tester=new Tester(5, "María","Junit");
   EntityManager em = emf.createEntityManager();
    EntityTransaction transaccion = em.getTransaction();
    transaccion.begin();
       em.persist(tester);
    transaccion.commit();
          
          TesterJpaController daoTester=new TesterJpaController(emf);
          
          daoTester.create(tester);
    
    
    
    System.out.println("hola");
    
    
}
    catch(Exception e){
            System.out.println("fallo");
    }
  
  
    
    }
    
}
