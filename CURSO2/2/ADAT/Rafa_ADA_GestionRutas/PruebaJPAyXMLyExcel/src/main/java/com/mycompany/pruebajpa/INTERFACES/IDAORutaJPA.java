/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.pruebajpa.INTERFACES;

import com.mycompany.pruebajpa.ENTITY.Ruta;
import java.util.List;

/**
 *
 * @author rafa
 */
public interface IDAORutaJPA {
    public void createRuta(Ruta ruta);
    public List < Ruta > readRutas();
    public void updateRuta(Ruta ruta);
}
