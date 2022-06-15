/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebajpa.DAOS;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author rafa
 */
public class DAOXML {
    private DefaultHandler handler;
    
    public DAOXML(DefaultHandler handler){
        this.handler = handler;
    }
    
    public void readXML(String nombreFichero) throws Exception{
        File file = new File(nombreFichero);
	InputStream entrada = new FileInputStream(file);
        
        SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();  
        
        XMLReader lectorXML = saxParser.getXMLReader();
        
        lectorXML.setContentHandler(handler);
        lectorXML.parse(new InputSource(entrada));
    }

    public DefaultHandler getHandler() {
        return handler;
    }

    public void setHandler(DefaultHandler handler) {
        this.handler = handler;
    }
}