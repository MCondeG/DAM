/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.manuelconde_examenada1.modelo.daos.interfaces;

import com.manuelconde_examenada1.modelo.entidades.Receta;

/**
 *
 * @author manuelconde
 */
public interface IDaoReceta {
    
    public void crearReceta(Receta receta);
    public void actualizarReceta(String nombre);
}