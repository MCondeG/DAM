/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.xml;

import java.util.ArrayList;
import modelo.entidades.Ingrediente;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author manuelconde
 */
public class Handler extends DefaultHandler {
     
    private Ingrediente ingrediente;
    private ArrayList<Ingrediente> receta;
    private StringBuilder cadena;
    
    
    public Handler() {
        
        this.ingrediente = new Ingrediente();
        this.receta = new ArrayList<>();
        this.cadena = new StringBuilder();
    }
    
    
    @Override
    public void startDocument() {
        System.out.println("Start Document");
    }
  
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atrbts) {    
        cadena.setLength(0);
        if (qName.equalsIgnoreCase("ingrediente")) {
            this.ingrediente.getAlimento().setNombre(atrbts.getValue("nombre"));
        }        
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        
    }
    
    @Override
    public void characters(char[] chars, int inicio, int lon) {
        cadena.append(chars, inicio, lon);
    }
    

    public ArrayList<Ingrediente> getReceta() {
        return receta;
    }

    public void setReceta(ArrayList<Ingrediente> receta) {
        this.receta = receta;
    }
}