/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XML;

import com.mycompany.pruebajpa.ENTITY.PosicionXML;
import com.mycompany.pruebajpa.ENTITY.RutaXML;
import com.mycompany.pruebajpa.ENTITY.TramoXML;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author rafa
 */
public class RutasHandler extends DefaultHandler{
    
     private StringBuilder cadena;
     
    private PosicionXML posicion;
     private RutaXML ruta;
     private TramoXML tramo;
     
     private ArrayList<PosicionXML> posiciones;
     private ArrayList<RutaXML> rutas;
     private ArrayList<TramoXML> tramos;


              
    @Override
    public void startDocument() throws SAXException {
        cadena=new StringBuilder();
       posiciones=new ArrayList<PosicionXML>();
        rutas= new ArrayList<RutaXML>();
       tramos = new ArrayList<TramoXML>();
        System.out.println("startDocument");
          
    }
    
    @Override
    public void startElement(String uri, String nombreLocal, String nombreCualif, Attributes atrbts) throws SAXException {
      cadena.setLength(0);
        switch(nombreCualif){
            
            case "posicion":
                posicion = new PosicionXML();
                posicion.setNombrePosicion(atrbts.getValue("nombre"));
                posicion.setLongitud(Float.parseFloat(atrbts.getValue("long")));
                posicion.setLatitud(Float.parseFloat(atrbts.getValue("lat")));
               
                break;
                
            case "tramo":
                tramo =new TramoXML();
               tramo.setNodoInicial(atrbts.getValue("inicio"));
               tramo.setNodoFinal(atrbts.getValue("fin"));
               tramo.setDistancia(Float.parseFloat(atrbts.getValue("distancia")));
                  break;
                  
                  
            case "ruta":
                ruta = new RutaXML();
               ruta.setNombreRuta(atrbts.getValue("nombre"));
                break;
                
        }
        
        
     }
    
    @Override
    public void characters(char[] chars, int inicio, int lon) throws SAXException {
        
         cadena.append(chars, inicio, lon);
        
     //   System.out.println("dato final: "+cadena); MOSTRAR DOCUMENTO
            
    }
    
    @Override
    public void endElement(String uri, String nombreLocal, String nombreCualif) throws SAXException {
     
    switch(nombreCualif){
        
        case "posicion":
            
            posicion.setDescripcionP(cadena.toString());
            
            posiciones.add(posicion);
            break;
            
        case "tramo":
            
            
            tramos.add(tramo);
            break;
            
        case "ruta":
            
            rutas.add(ruta);
            break;
            
        case "latitud":
           
            break;
            
        case "longitud":
            
            break;
            
        case "nodoinicial":
            tramo.setNodoInicial(cadena.toString());
            break;
            
        case "nodofinal":
            tramo.setNodoFinal(cadena.toString());
            break;
            
        
    }
    
    
  
          
  
    }
    
    @Override
    public void endDocument() throws SAXException {
        System.out.println("endDocument");
       
    }

        public ArrayList<PosicionXML> getPosiciones() {
        return posiciones;
    }


    public ArrayList<TramoXML> getTramos() {
        return tramos;
    }
     
        public ArrayList<RutaXML> getRutas() {
        return rutas;
    } 
    
    
}
