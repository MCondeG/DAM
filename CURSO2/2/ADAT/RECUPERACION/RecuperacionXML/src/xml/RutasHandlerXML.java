/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import modelo.Posicion;
import modelo.Ruta;
import modelo.Tramo;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author enrique
 */
public class RutasHandlerXML extends DefaultHandler{
    
    private StringBuilder cadena;
    
    
    private Posicion posicion;
    private ArrayList<Posicion> posiciones;
    private Tramo tramo;
    private ArrayList<Tramo> tramos;
    private Ruta ruta;
    private ArrayList<Ruta> rutas;
   
  
  //Parte que recoge los objetos creados para ser enviados fuera de la clase

    public ArrayList<Posicion> getPosiciones() {
        return posiciones;
    }

    public ArrayList<Tramo> getTramos() {
        return tramos;
    }

    public ArrayList<Ruta> getRutas() {
        return rutas;
    }
    
    
    //parte que mapea el documento e introduce los datos en objetos
    
          
    @Override
    public void startDocument() throws SAXException {
        
        this.cadena = new StringBuilder();
        
        this.posicion = new Posicion();
        this.posiciones = new ArrayList<Posicion>();
        this.tramo = new Tramo();
        this.tramos = new ArrayList<Tramo>();
        this.ruta = new Ruta();
        this.rutas = new ArrayList<Ruta>();
        
        System.out.println("startDocument");
    }
    
    @Override
    public void startElement(String uri, String nombreLocal, String nombreCualif, Attributes atrbts) throws SAXException {
        cadena.setLength(0);
        
        switch (nombreCualif) {
            case "posicion":
                this.posicion.setNombre(atrbts.getValue("nombre"));
                this.posicion.setLongitud(atrbts.getValue("long"));
                this.posicion.setLatitud(atrbts.getValue("lat"));
                break;
            case "tramo":
                
                break;
            case "ruta":
                
                break;
        }
        /*if (nombreCualif.equals("profesor")){
            profesor=new Profesor();
            profesor.setCp(atrbts.getValue("cp"));
            profesor.setDni(atrbts.getValue("dni"));
        }*/
       
         System.out.println("startElement: "+nombreLocal+ " "+nombreCualif);
     }
    
    @Override
    public void characters(char[] chars, int inicio, int lon) throws SAXException {
        
         cadena.append(chars, inicio, lon);
        
         System.out.println("dato final: "+cadena);
            
    }
    
    @Override
    public void endElement(String uri, String nombreLocal, String nombreCualif) throws SAXException {
        
        
        /*if(nombreCualif.equals("nombre")){
            profesor.setNombre(cadena.toString());
        } else if (nombreCualif.equals("horasLectivas")){
            profesor.setHorasLectivas(Integer.parseInt(cadena.toString()));
        } else if (nombreCualif.equals("mayor55")){
            profesor.setMayor55(Boolean.parseBoolean(cadena.toString()));
        }else if (nombreCualif.equals("profesor")){
            profesores.add(profesor);
        }
        System.out.println("endtElement: "+nombreLocal+ " "+nombreCualif);*/
    }
    
    @Override
    public void endDocument() throws SAXException {
        System.out.println("endDocument");
       
    }  
}