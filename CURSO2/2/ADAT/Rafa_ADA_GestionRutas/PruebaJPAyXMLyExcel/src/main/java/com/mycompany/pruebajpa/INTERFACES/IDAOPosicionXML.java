/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.pruebajpa.INTERFACES;

import com.mycompany.pruebajpa.ENTITY.PosicionXML;
import java.util.ArrayList;

/**
 *
 * @author rafa
 */
public interface IDAOPosicionXML {
    
    public void guardarPosicion(PosicionXML p);
    public ArrayList<PosicionXML> verPosiciones();
}
