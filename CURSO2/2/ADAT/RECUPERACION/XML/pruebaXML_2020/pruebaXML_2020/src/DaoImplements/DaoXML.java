/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplements;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import utilidades.ProfesorHandlerXML;

/**
 *
 * @author enrique
 */
public class DaoXML {
    
    private DefaultHandler handler;
    
    public DaoXML(DefaultHandler handler){
        this.handler=handler;
    }
    
    public void leerXML(String nombreFichero)throws Exception{
        
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

    /**
     * @return the handler
     */
    public DefaultHandler getHandler() {
        
        return handler;
    }

    /**
     * @param handler the handler to set
     */
    public void setHandler(DefaultHandler handler) {
        this.handler = handler;
    }
    
    
    
}
