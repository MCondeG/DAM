/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebajpa.DAOS;

import XML.RutasHandler;
import com.mycompany.pruebajpa.ENTITY.RutaXML;
import com.mycompany.pruebajpa.INTERFACES.IDAORutaXML;
import java.util.ArrayList;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author rafa
 */
public class DAORutaXML extends DAOXML implements IDAORutaXML{

    private String nombreFichero;
    private  RutasHandler handler;

    public DAORutaXML(DefaultHandler handler) {
        super(handler);
    }
    
    
    
   public DAORutaXML(String nombreFichero){
        super(new RutasHandler());
        handler=(RutasHandler)this.getHandler();
        this.nombreFichero=nombreFichero; 
    }

   
    
    @Override
    public void guardarRuta(RutaXML r) {
    }

    @Override
    public ArrayList<RutaXML> verRutas() {
        try {
            this.readXML(nombreFichero);
            return handler.getRutas();
        } catch (Exception ex) {
           return null;
        }   
    }    
    
}
