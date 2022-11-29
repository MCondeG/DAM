package com.manuelconde_examenada1.modelo.xml;

import com.manuelconde_examenada1.modelo.entidades.Alimento;
import com.manuelconde_examenada1.modelo.entidades.Ingrediente;
import com.manuelconde_examenada1.modelo.entidades.Receta;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler; 


// Manejador SAX para procesar el documento
public class SAXHandler extends DefaultHandler {
    
    private StringBuilder cadena;
    
    private Receta receta;
    private Alimento alimento;
    private Ingrediente ingrediente;
    
    private ArrayList<Receta> recetas;
    private ArrayList<Alimento> alimentos;
    private ArrayList<Ingrediente> ingredientes;

    
    
    public SAXHandler() {
        this.cadena = new StringBuilder();
        
        this.receta = null;
        this.alimento = null;
        this.ingrediente = null;
        
        this.recetas = new ArrayList<>();
        this.alimentos = new ArrayList<>();
        this.ingredientes = new ArrayList<>();
    }

    
    public ArrayList<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(ArrayList<Receta> recetas) {
        this.recetas = recetas;
    }

    public ArrayList<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(ArrayList<Alimento> alimentos) {
        this.alimentos = alimentos;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
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
        
        switch(qName) {
            case "receta":
                this.receta = new Receta();
                break;
            case "ingrediente":
                this.ingrediente = new Ingrediente();
                this.alimento = new Alimento();
                break;
        }
        
        
        this.cadena.setLength(0);

        
	// Lista atributos y sus valores
	for (int i = 0; i < atts.getLength(); i++) {
	    System.out.println("Atributo: " + atts.getLocalName(i));
	    System.out.println("\tValor: " + atts.getValue(i));
            
            if ((atts.getLocalName(i)).equals("nombre")) {
                if (qName.equals("receta")) this.receta.setNombre(atts.getValue(i));
                if (qName.equals("ingrediente")) this.alimento.setNombre(atts.getValue(i));
            }
            else {
                switch(qName) {
                    case "proteinas":
                        this.alimento.setGrprot(Double.valueOf(atts.getValue(i)));
                        break;
                    case "grasas":
                        this.alimento.setGrgrasa(Double.valueOf(atts.getValue(i)));
                        break;
                    case "hidratos":
                        this.alimento.setGrhidratos(Double.valueOf(atts.getValue(i)));
                        break;    
                }
            }
	}
    }
	
    @Override
    public void endElement(String nameSpaceURI, String localName, String qName) throws SAXException {
	
        System.out.println("endElement: " + qName);
        
        switch(qName) {
            case "cantidad":
                this.ingrediente.setCantidad(Double.valueOf(this.cadena.toString()));
                break;
            case "receta":
                this.receta.setIngredienteList(this.ingredientes);
                this.receta.setIdReceta(1);
                this.recetas.add(this.receta);
                break;
            case "ingrediente":
                this.ingredientes.add(this.ingrediente);
                break;
            case "alimento":
                this.ingrediente.setIdAlimento(this.alimento);
                this.alimentos.add(this.alimento);
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
