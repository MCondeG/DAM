/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Daos.DaoProfesor;
import entidades.Profesor;
import entidades.Taller;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author enrique
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("semanaCultural_persistencia");
      
        
              
        DaoProfesor daoProfesor= new DaoProfesor(emf);
        System.out.println("conexión realizada");
        
        List<Profesor> profesores =daoProfesor.verProfesores();
        
        //Buscar profesores
        for (Profesor profesor:profesores){
            System.out.println(profesor.getNombreUsuario());
        }
        //Buscar un profesor
          Profesor profe=daoProfesor.getProfesor(1);
          List<Taller> talleres=daoProfesor.getTalleres(profe);
            System.out.println(profe.getNombreUsuario());
            
        //Crear Profesor
        profe=new Profesor();
        profe.setNombreUsuario("mjose");
        profe.setPassword("asdf");
        //daoProfesor.create(profe);
        
        //Modificar Profesor
      //  profe=daoProfesor.findProfesor(1);
        profe.setNombre("enrique");
        try {
         //   daoProfesor.edit(profe);
        } catch (Exception ex) {
          
        } 
        
         //Crear Profesor otro profesor más
        profe=new Profesor();
        profe.setNombreUsuario("Adolfo");
        profe.setPassword("asdf");
//        daoProfesor.create(profe);
//        profesores =daoProfesor.findProfesorEntities();
        
        //Ver profesores
//        profesores =daoProfesor.findProfesorEntities();
        for (Profesor profesor:profesores){
            System.out.println(profesor.getNombreUsuario());
        }
        
        //Borrar profesor
          try {
//            daoProfesor.destroy(4);
        } catch (Exception ex) {
          
        } 
          
           //Ver profesores
//           profesores =daoProfesor.findProfesorEntities();
        for (Profesor profesor:profesores){
            System.out.println(profesor.getNombreUsuario());
        }
        
        
      

    }
    
}
