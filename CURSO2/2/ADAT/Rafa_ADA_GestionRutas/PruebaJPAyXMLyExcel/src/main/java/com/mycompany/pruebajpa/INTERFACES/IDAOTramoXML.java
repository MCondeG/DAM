/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.pruebajpa.INTERFACES;

import com.mycompany.pruebajpa.ENTITY.TramoXML;
import java.util.ArrayList;

/**
 *
 * @author rafa
 */
public interface IDAOTramoXML {
    public void guardarTramo(TramoXML t);
    public ArrayList<TramoXML> verTramos();
}
