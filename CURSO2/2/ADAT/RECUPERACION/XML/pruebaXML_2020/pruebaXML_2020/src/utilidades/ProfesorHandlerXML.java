/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import DaoImplements.DaoProfesorXML;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import modelo.Profesor;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author enrique
 */
public class ProfesorHandlerXML extends DefaultHandler{
    
    private StringBuilder cadena;
    
    
    private Profesor profesor;
    private ArrayList<Profesor> profesores;
   
  
  //Parte que recoge los objetos creados para ser enviados fuera de la clase
    
    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }
    
    
    
    
    //parte que mapea el documento e introduce los datos en objetos
    
          
    @Override
    public void startDocument() throws SAXException {
        cadena=new StringBuilder();
        profesores=new ArrayList<Profesor>();
        System.out.println("startDocument");
          
    }
    
    @Override
    public void startElement(String uri, String nombreLocal, String nombreCualif, Attributes atrbts) throws SAXException {
        cadena.setLength(0);
        if (nombreCualif.equals("profesor")){
            profesor=new Profesor();
            profesor.setCp(atrbts.getValue("cp"));
            profesor.setDni(atrbts.getValue("dni"));
        }
       
         System.out.println("startElement: "+nombreLocal+ " "+nombreCualif);
     }
    
    @Override
    public void characters(char[] chars, int inicio, int lon) throws SAXException {
        
         cadena.append(chars, inicio, lon);
        
         System.out.println("dato final: "+cadena);
            
    }
    
    @Override
    public void endElement(String uri, String nombreLocal, String nombreCualif) throws SAXException {
        if(nombreCualif.equals("nombre")){
            profesor.setNombre(cadena.toString());
        } else if (nombreCualif.equals("horasLectivas")){
            profesor.setHorasLectivas(Integer.parseInt(cadena.toString()));
        } else if (nombreCualif.equals("mayor55")){
            profesor.setMayor55(Boolean.parseBoolean(cadena.toString()));
        }else if (nombreCualif.equals("profesor")){
            profesores.add(profesor);
        }
        System.out.println("endtElement: "+nombreLocal+ " "+nombreCualif);
    }
    
    @Override
    public void endDocument() throws SAXException {
        System.out.println("endDocument");
       
    }  
}