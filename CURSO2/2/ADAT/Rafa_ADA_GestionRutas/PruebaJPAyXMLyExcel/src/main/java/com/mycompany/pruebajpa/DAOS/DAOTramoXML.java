/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebajpa.DAOS;

import XML.RutasHandler;
import com.mycompany.pruebajpa.ENTITY.TramoXML;
import com.mycompany.pruebajpa.INTERFACES.IDAOTramoXML;
import java.util.ArrayList;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author rafa
 */
public class DAOTramoXML extends DAOXML implements IDAOTramoXML{

    private String nombreFichero;
    private  RutasHandler handler;

    public DAOTramoXML(DefaultHandler handler) {
        super(handler);
    }
    
    
    
   public DAOTramoXML(String nombreFichero){
        super(new RutasHandler());
        handler=(RutasHandler)this.getHandler();
        this.nombreFichero=nombreFichero;
    }

    @Override
    public void guardarTramo(TramoXML t) {
    }

    @Override
    public ArrayList<TramoXML> verTramos() {
             try {
            this.readXML(nombreFichero);
            return handler.getTramos();
        } catch (Exception ex) {
           return null;
        }  
    }
    
    
    
}