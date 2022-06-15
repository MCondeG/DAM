/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.pruebajpa.MAIN;

import XML.RutasHandler;
import com.mycompany.pruebajpa.DAOS.DAOPosicionXML;
import com.mycompany.pruebajpa.DAOS.DAORutaXML;
import com.mycompany.pruebajpa.DAOS.DAOTramoXML;
import com.mycompany.pruebajpa.ENTITY.PosicionXML;
import com.mycompany.pruebajpa.ENTITY.RutaXML;
import com.mycompany.pruebajpa.ENTITY.TramoXML;
import java.io.File;
import java.lang.String;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;



/**
 *
 * @author rafa
 */
public class PruebaXML {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
     

    DAOPosicionXML dp= new DAOPosicionXML("src/main/java/XML/rutas.xml");  
    DAORutaXML dr= new DAORutaXML("src/main/java/XML/rutas.xml");   
    DAOTramoXML dt= new DAOTramoXML("src/main/java/XML/rutas.xml");   

    ArrayList<PosicionXML> posiciones=dp.verPosiciones();
    ArrayList<RutaXML> rutas=dr.verRutas();
    ArrayList<TramoXML> tramos=dt.verTramos();
   
  
    System.out.println("");
    System.out.println("POSICIONES");
    System.out.println("");
    
    for(PosicionXML p:posiciones){
     System.out.println("Nombre :  "+p.getNombrePosicion() +" Longitud: "+p.getLongitud()+"   Latitud:   "+p.getLatitud()+"      Descripcion: "+p.getDescripcionP());
        }
      
    System.out.println("");
    System.out.println("TRAMOS");
    System.out.println("");
    
    for(TramoXML t:tramos){  
     System.out.println(" Inicio: "+t.getNodoInicial()+"   Final:   "+t.getNodoFinal()+"      Distancia: "+t.getDistancia());
        }   
    
    System.out.println("");
    System.out.println("RUTAS");
    System.out.println("");
                   
    for(RutaXML r:rutas){  
     System.out.println(" Nombre: "+r.getNombreRuta());
        }

         
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    SAXParser saxParser = saxParserFactory.newSAXParser();           
       
    File file = new File("src/main/java/XML/rutas.xml");    
    RutasHandler handler = new RutasHandler();
    saxParser.parse(file, handler);
    
    
    PruebaXML.guardarRutas(saxParser, file, rutas, tramos,handler); 
    PruebaXML.guardarTramo(saxParser, file,tramos,handler);
    PruebaXML.guardarPosicion(saxParser,file,posiciones,handler);
         
    }//MAIN
    
    
 public static void  guardarRutas(SAXParser saxParser, File file,ArrayList<RutaXML> rutas,ArrayList<TramoXML> tramos, RutasHandler handler ){
        
    DAORutaXML dao = new DAORutaXML(handler);
        
            for (int i = 0; i < rutas.size(); i++) {
            RutaXML ruta = new RutaXML();
            ArrayList <TramoXML> nuevotramo = new ArrayList <TramoXML> ();
            
            ruta.setNombreRuta(rutas.get(i).getNombreRuta());     
            
            nuevotramo.add(new TramoXML(tramos.get(i).getNodoInicial(), tramos.get(i).getNodoFinal(), tramos.get(i).getDistancia()));
            
            ruta.setTramo(nuevotramo);
            
            dao.guardarRuta(ruta);
            
                
            
        }
     
     
    }//GUARDAR RUTAS
 
 
 public static void guardarTramo(SAXParser saxParser, File file,ArrayList<TramoXML> tramos,RutasHandler handler){
     
        DAOTramoXML dao = new DAOTramoXML(handler);
                
        for (int i = 0; i < tramos.size(); i++) {
            
          TramoXML tramo = new TramoXML();
            
          tramo.setNodoInicial(tramos.get(i).getNodoInicial());
          tramo.setNodoFinal(tramos.get(i).getNodoFinal());
            
          dao.guardarTramo(tramo);
            
        
        }
 }//GUARDAR TRAMO
 
 
 
 public static void guardarPosicion(SAXParser saxParser,File file,ArrayList<PosicionXML>posiciones,RutasHandler handler){
        DAOPosicionXML dao = new DAOPosicionXML(handler);
                
        for (int i = 0; i < posiciones.size(); i++) {
            
         PosicionXML posicion = new PosicionXML();
            
         posicion.setNombrePosicion(posiciones.get(i).getNombrePosicion());
         posicion.setLatitud(posiciones.get(i).getLatitud());
         posicion.setLongitud(posiciones.get(i).getLongitud());
         posicion.setDescripcionP(posiciones.get(i).getDescripcionP());
           
         dao.guardarPosicion(posicion);
            
        
        }
 }
    
}
