package com.rutaxml.xml;

import com.rutaxml.modelo.Lugar;
import com.rutaxml.modelo.Lugares;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler; 


// Crear un manejador SAX para procesar el documento
public class SAXHandler extends DefaultHandler {
    
    private StringBuilder cadena;
    
    private Lugar lugar;
    private Lugares lugares;
    
    
    public SAXHandler() {
        this.cadena = new StringBuilder();
        this.lugar = null;
        this.lugares = Lugares.getInstance();
    }

    
    //parte que mapea el documento e introduce los datos en objetos
    
    @Override
    public void startDocument() throws SAXException {
        System.out.println("----- START DOCUMENT -----\n");
    }
	
    @Override
    public void endDocument() throws SAXException {
        System.out.println("\n----- END DOCUMENT -----");
    }
	
    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        
        this.cadena.append(chars, start, length);
        
	if (this.cadena.toString().trim().length() > 0) System.out.println("Caracteres: " + this.cadena); 
    }
    
    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
                
        System.out.println("startElement: " + qName);
        
        this.cadena.setLength(0);

        if (qName.equals("lugar")) this.lugar = new Lugar();
        
        
	// Lista atributos y sus valores
	for (int i = 0; i < atts.getLength(); i++) {
	    System.out.println("Atributo: " + atts.getLocalName(i));
	    System.out.println("\tValor: " + atts.getValue(i) + "\n");
            
            if ((atts.getLocalName(i)).equals("caracteristicas")) this.lugar.setCaracteristicas(atts.getValue(i));
	}
    }
	
    @Override
    public void endElement(String nameSpaceURI, String localName, String qName) throws SAXException {
	
        System.out.println("endElement: " + qName);
        
        switch(qName) {
            case "lugar":
                this.lugares.añadir(this.lugar);
                break;
            case "nombre":
                this.lugar.setNombre(this.cadena.toString());
                break;
        }
    }
    
    
    
    /*
    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        System.out.println(length + " caracteres en blanco ignorables"); 
    }
	
    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
	System.out.println("Comienza prefijo de namespace: " + prefix);
    }
	
    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
	System.out.println("Termina prefijo de namespace: " + prefix);
    } 
	
    @Override
    public void processingInstruction(String instruction, String data) throws SAXException {
	System.out.println("Instruccion: " + instruction + ", datos: " + data); 
    }
	
    @Override
    public void skippedEntity(String name) throws SAXException {
        System.out.println("Entidad saltada: " + name);
    }
    */
}	