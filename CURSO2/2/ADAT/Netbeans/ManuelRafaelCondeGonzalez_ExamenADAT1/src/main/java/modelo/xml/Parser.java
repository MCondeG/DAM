/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import modelo.entidades.Ingrediente;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 *
 * @author manuelconde
 */
public class Parser {
    
    private String archivoXML;
    private Handler handler;

    
    public Parser(String archivoXML) {
        this.archivoXML=archivoXML;
        this.handler = new Handler();
    }
    
    
    public Parser() {    
    }

    public ArrayList<Ingrediente> procesarFichero() throws Exception {
            leerXml(archivoXML);
            return handler.getReceta();
    }
    
    
    private void leerXml(String archivoXML) throws Exception {
        File file = new File(archivoXML);
        InputStream entrada = new FileInputStream(file);
        SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();
        XMLReader lector = saxParser.getXMLReader();
        lector.setContentHandler(handler);
        lector.parse(new InputSource(entrada));
    }
}