/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 *
 * @author enrique
 */
public class ParserXML {
    private String nombreFichero;
    private VentanaHandlerXML handler;
      
    
    public ParserXML(String nombreFichero){
        
        this.nombreFichero=nombreFichero;
        handler =new VentanaHandlerXML();
       
    }
    
   
    
    public HashMap<String,Object> procesarFichero(){
      
        try {
            this.leerXML(nombreFichero);
            return handler.getComponentes();
        } catch (Exception ex) {
           return null;
        }
           
    }
  
     private void leerXML(String nombreFichero)throws Exception{
        
        //localizo el fichero XML
        File file = new File(nombreFichero);
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
