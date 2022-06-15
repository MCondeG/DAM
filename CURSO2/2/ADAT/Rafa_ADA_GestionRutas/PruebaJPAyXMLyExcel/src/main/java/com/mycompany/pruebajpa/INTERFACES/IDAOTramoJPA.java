/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.pruebajpa.INTERFACES;

import com.mycompany.pruebajpa.ENTITY.Tramo;
import java.util.List;

/**
 *
 * @author rafa
 */
public interface IDAOTramoJPA {
    public void createTramo(Tramo tramo);
    public List < Tramo > readTramos();
    public void updateTramo(Tramo tramo);
    public void deleteTramo(Tramo tramo);
    
}
