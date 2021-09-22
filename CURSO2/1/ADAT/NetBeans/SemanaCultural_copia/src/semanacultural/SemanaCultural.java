/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semanacultural;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author enrique
 */
public class SemanaCultural {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        // TODO code application logic here
        
           try{
          EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SemanaCultural_copiaPU");
    
    
    //Registrar un Libro
   Talleres taller = new Talleres();
   taller.setIdTaller(2);
   taller.setNombre("ajedrez");
  
   TalleresJpaController daoTaller=new TalleresJpaController(entityManagerFactory);
   AlumnosJpaController daoAlumnos=new AlumnosJpaController(entityManagerFactory);
//    
//    daoTaller.create(taller);
//    taller.setNombre("costura");
//    
//    daoTaller.edit(taller);
//    daoTaller.destroy(1);
   //Buscamos un taller por su nombre
    Talleres taller2=daoTaller.findTalleresName("ajedrez");
    
    //los editamos cambiando el nombtre
    taller2.setNombre("costura");
    daoTaller.edit(taller2);
    //creamos un alumno
    Alumnos al=new Alumnos();
    al.setIdalumno(1);
    al.setNombre("Enrique");
    daoAlumnos.create(al);
    //Le asignamos ese taller al alumno
    al.getTalleresSet().add(taller2);
    daoAlumnos.edit(al);
    
    
    System.out.println("hola");
}
    catch(Exception e){
            System.out.println("fallo");
           }
  
  
  

}
    }
    

