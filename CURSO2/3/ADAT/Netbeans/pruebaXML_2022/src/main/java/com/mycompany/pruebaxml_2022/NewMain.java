/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebaxml_2022;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import modelo.Profesor;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author usuario
 */
public class NewMain {

    private static DefaultHandler handler;
        
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        String ruta="C:\\Users\\usuario\\Desktop\\profesores.xml";
        ProfesorHandlerXML handler=new ProfesorHandlerXML();
        
        leerXML(handler,ruta);
        ArrayList<Profesor> profesores=handler.getProfesores();
        
        for(Profesor p:profesores){
          System.out.println("profesor: "+p.getNombre()+"   cp:   "+p.getCp()+" "+p.getHorasLectivas()+" "+p.isMayor55());
        }
    }

    private static void leerXML(DefaultHandler handler, String nombre)throws Exception {
         //localizo el fichero XML
        File file = new File(nombre);
	InputStream entrada = new FileInputStream(file);
        
        //Instancio una factoria y la factoria me proporciona un objeto de la
        //clase SaxParser
        SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();  
        
        //Del objeto saxParser obtengo un lector de archivos XML
        XMLReader lector = saxParser.getXMLReader();
        
        //le pasamos al lector el manejador específico para ese archivo XML
        lector.setContentHandler(handler);
        lector.parse(new InputSource(entrada));
   }
    
}
