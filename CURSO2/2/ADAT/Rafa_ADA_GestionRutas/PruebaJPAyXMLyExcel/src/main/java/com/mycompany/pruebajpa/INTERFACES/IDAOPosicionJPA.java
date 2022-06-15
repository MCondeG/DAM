/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.pruebajpa.INTERFACES;

import com.mycompany.pruebajpa.ENTITY.Posicion;
import java.util.List;

/**
 *
 * @author rafa
 */
public interface IDAOPosicionJPA {
    
    public void createPosicion(Posicion posicion);
    public List < Posicion > readPosiciones();
    public void updatePosicion(Posicion posicion);

}
