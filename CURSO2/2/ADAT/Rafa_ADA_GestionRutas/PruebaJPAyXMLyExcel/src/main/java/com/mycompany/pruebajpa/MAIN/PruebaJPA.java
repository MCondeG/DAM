/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.pruebajpa.MAIN;


import com.mycompany.pruebajpa.DAOS.DAOPosicionJPA;
import com.mycompany.pruebajpa.DAOS.DAORutaJPA;
import com.mycompany.pruebajpa.DAOS.DAOTramoJPA;
import com.mycompany.pruebajpa.ENTITY.Posicion;
import com.mycompany.pruebajpa.ENTITY.Ruta;
import com.mycompany.pruebajpa.ENTITY.Tramo;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.parsers.ParserConfigurationException;


/**
 *
 * @author rafa
 */
public class PruebaJPA {

    public static void main(String[] args) throws ParserConfigurationException, IOException{
        
 EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA_persistencia");  
 
 DAOPosicionJPA daoPosicion = new DAOPosicionJPA(emf); 
 DAOTramoJPA daoTramo = new DAOTramoJPA(emf); 
 DAORutaJPA daoRuta = new DAORutaJPA(emf);
 
 System.out.println("\nConexión realizada con éxito!");
 
 
 //EJERCICIOS
 PruebaJPA.createPosicion(daoPosicion);
 PruebaJPA.updatePosicion(emf);
 PruebaJPA.readPosicion(daoPosicion);

 PruebaJPA.createTramo(daoTramo);
 PruebaJPA.updateTramo(emf);
 PruebaJPA.readTramo(daoTramo);
 
 PruebaJPA.createRuta(daoRuta);
 PruebaJPA.readRuta(daoRuta);
 PruebaJPA.updateRuta(emf);

PruebaJPA.deleteRuta(daoRuta);


 
    
    }
    
  public static void   createPosicion(DAOPosicionJPA daoPosicion){
      Posicion posicion = new Posicion();
      
      float longitud = 0f, latitud=0f;
      String descripcion = "";
      
              for (int i = 0; i < daoPosicion.readPosiciones().size(); i++) {
            posicion.setIdposicion(daoPosicion.readPosiciones().get(i).getIdposicion());
        }
              
              for (int i = 0; i < daoPosicion.readPosiciones().size(); i ++){
            longitud += daoPosicion.readPosiciones().get(i).getLongitud();
            latitud += daoPosicion.readPosiciones().get(i).getLatitud();
            descripcion += daoPosicion.readPosiciones().get(i).getDescripcion();
            
            posicion.setTramoList(null);
            posicion.setLatitud(latitud);
            posicion.setLongitud(longitud);
            posicion.setDescripcion(descripcion);
            System.out.println("\nPosicion añadida");
        }
      
    }
  
      public static void readPosicion(DAOPosicionJPA daoPosicion) {
        System.out.println("\nID\tLONG\tLATI\tDESCR");
        
        for (int j = 0; j <  daoPosicion.readPosiciones().size(); j++) {
            System.out.println(daoPosicion.readPosiciones().get(j).getIdposicion()+ "\t" + 
                daoPosicion.readPosiciones().get(j).getLongitud()+ "\t" + 
                daoPosicion.readPosiciones().get(j).getLatitud()+ "\t" + 
                daoPosicion.readPosiciones().get(j).getDescripcion());
        }
    }
      
       public static void updatePosicion(EntityManagerFactory emf) { 
            DAOPosicionJPA daoPosicion= new DAOPosicionJPA(emf);
        
        Posicion posicion = new Posicion();
        posicion.setLongitud(40f);
        posicion.setLatitud(221f);
        posicion.setDescripcion("Sevilla");
        
        Posicion posicion2 = new Posicion();
        posicion2.setLongitud(80f);
        posicion2.setLatitud(21f);
        posicion2.setDescripcion("Huelva");
        
        Posicion posicion3 = new Posicion();
        posicion3.setLongitud(50f);
        posicion3.setLatitud(201f);
        posicion3.setDescripcion("Cadiz");
        
        Posicion posicion4 = new Posicion();
        posicion4.setLongitud(73f);
        posicion4.setLatitud(174f);
        posicion4.setDescripcion("Cordoba");
        
        Posicion posicion5 = new Posicion();
        posicion5.setLongitud(15f);
        posicion5.setLatitud(107f);
        posicion5.setDescripcion("Malaga");  
        
        Posicion posicion6 = new Posicion();
        posicion6.setLongitud(185f);
        posicion6.setLatitud(18f);
        posicion6.setDescripcion("Granada"); 
        
        Posicion posicion7 = new Posicion();
        posicion7.setLongitud(171f);
        posicion7.setLatitud(200f);
        posicion7.setDescripcion("Jaen"); 
        
        Posicion posicion8 = new Posicion();
        posicion8.setLongitud(55f);
        posicion8.setLatitud(208f);
        posicion8.setDescripcion("Almeria"); 
        
        
        daoPosicion.createPosicion(posicion);
        daoPosicion.createPosicion(posicion2);
        daoPosicion.createPosicion(posicion3);
        daoPosicion.createPosicion(posicion4);
        daoPosicion.createPosicion(posicion5);
        daoPosicion.createPosicion(posicion6);
        daoPosicion.createPosicion(posicion7);
        daoPosicion.createPosicion(posicion8);
        

        System.out.println("Posicion actualizada");
           
       }
       
      public static void   createTramo(DAOTramoJPA daoTramo){
      Tramo tramo = new Tramo();
      
      float nodoinicial = 0f, nodofinal=0f;
      
      
              for (int i = 0; i < daoTramo.readTramos().size(); i++) {
            tramo.setIdtramo(daoTramo.readTramos().get(i).getIdtramo());
        }
              
              for (int i = 0; i < daoTramo.readTramos().size(); i ++){
            nodoinicial += daoTramo.readTramos().get(i).getNodoInicial();
            nodofinal += daoTramo.readTramos().get(i).getNodoFinal();
            
            tramo.setNodoInicial(nodoinicial);
            tramo.setNodoFinal(nodofinal);
            System.out.println("\nTramo añadido");
        }
      
    }
         
         public static void readTramo(DAOTramoJPA daoTramo) {
        System.out.println("\nID\tNOD_INI\tNOD_FIN");
        
        for (int j = 0; j <  daoTramo.readTramos().size(); j++) {
            System.out.println(daoTramo.readTramos().get(j).getIdtramo()+ "\t" + 
                daoTramo.readTramos().get(j).getNodoInicial()+ "\t" + 
                daoTramo.readTramos().get(j).getNodoFinal());
        }
    }
         
    
        public static void updateTramo(EntityManagerFactory emf) { 
        DAOTramoJPA daoTramo= new DAOTramoJPA(emf);
        
        Tramo tramo = new Tramo();
        tramo.setNodoInicial(40-221f);
        tramo.setNodoFinal(80-21f);
       
        Tramo tramo2 = new Tramo();
        tramo2.setNodoInicial(40-221f);
        tramo2.setNodoFinal(50-201f);
       
        Tramo tramo3 = new Tramo();
        tramo3.setNodoInicial(50-201f);
        tramo3.setNodoFinal(80-21f);
       
        Tramo tramo4 = new Tramo();
        tramo4.setNodoInicial(40-221f);
        tramo4.setNodoFinal(73-174f);
       
        Tramo tramo5 = new Tramo();
        tramo5.setNodoInicial(40-221f);
        tramo5.setNodoFinal(15-107f);
       
        Tramo tramo6 = new Tramo();
        tramo6.setNodoInicial(15-107f);
        tramo6.setNodoFinal(55-208f);
       
        Tramo tramo7 = new Tramo();
        tramo7.setNodoInicial(185-18f);
        tramo7.setNodoFinal(55-208f);
       
        daoTramo.createTramo(tramo);
        daoTramo.createTramo(tramo2);
        daoTramo.createTramo(tramo3);
        daoTramo.createTramo(tramo4);
        daoTramo.createTramo(tramo5);
        daoTramo.createTramo(tramo6);
        daoTramo.createTramo(tramo7);
        
        System.out.println("Tramo actualizado");
           
       }     
        
       public static void   createRuta(DAORutaJPA daoRuta){
      Ruta ruta = new Ruta();
      
      float distanciaT = 0f;
      String descripcion = "";
      
              for (int i = 0; i < daoRuta.readRutas().size(); i++) {
            ruta.setIdruta(daoRuta.readRutas().get(i).getIdruta());
        }
              
            for (int i = 0; i < daoRuta.readRutas().size(); i ++){
            distanciaT += daoRuta.readRutas().get(i).getDistanciaTeorica();
            descripcion += daoRuta.readRutas().get(i).getDescripcion();
            
            ruta.setDistanciaTeorica(distanciaT);
            ruta.setDescripcion(descripcion);
            System.out.println("\nRuta añadida");
        }
      
    }
          
        public static void readRuta(DAORutaJPA daoRuta) {
        System.out.println("\nID\tDIST\tDESCR");
        
        for (int j = 0; j <  daoRuta.readRutas().size(); j++) {
            System.out.println(daoRuta.readRutas().get(j).getIdruta()+ "\t" + 
                daoRuta.readRutas().get(j).getDistanciaTeorica()+ "\t" + 
                daoRuta.readRutas().get(j).getDescripcion());
        }
    }
                
                
       public static void updateRuta(EntityManagerFactory emf) { 
        DAORutaJPA daoRuta= new DAORutaJPA(emf);
        
        Ruta ruta = new Ruta();
        ruta.setDistanciaTeorica(200f);
        ruta.setDescripcion("Occidental");
        
   
        Ruta ruta2 = new Ruta();
        ruta2.setDistanciaTeorica(144f);
        ruta2.setDescripcion("De la Costa");
   
        daoRuta.createRuta(ruta);
        daoRuta.createRuta(ruta2);

        System.out.println("Ruta actualizada");
           
       }  
       
       
      public static void deleteRuta(DAORutaJPA daoRuta){
      
        }
      
    }  
       
       

