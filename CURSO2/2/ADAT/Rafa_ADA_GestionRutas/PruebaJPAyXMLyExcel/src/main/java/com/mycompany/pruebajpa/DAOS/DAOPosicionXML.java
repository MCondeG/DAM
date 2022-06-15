/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebajpa.DAOS;

import XML.RutasHandler;
import com.mycompany.pruebajpa.ENTITY.PosicionXML;
import com.mycompany.pruebajpa.INTERFACES.IDAOPosicionXML;
import java.util.ArrayList;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author rafa
 */
public class DAOPosicionXML extends DAOXML implements IDAOPosicionXML{
    
    private String nombreFichero;
    private  RutasHandler handler;

    public DAOPosicionXML(DefaultHandler handler) {
        super(handler);
    }
    
    
    
   public DAOPosicionXML(String nombreFichero){
        super(new RutasHandler());
        handler=(RutasHandler)this.getHandler();
        this.nombreFichero=nombreFichero;
    }

    @Override
    public void guardarPosicion(PosicionXML p) {
    }

    @Override
    public ArrayList<PosicionXML> verPosiciones() {
        try {
            this.readXML(nombreFichero);
            return handler.getPosiciones();
        } catch (Exception ex) {
           return null;
        }    }
    
}
