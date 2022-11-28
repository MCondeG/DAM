/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejemplogeneraljpa.modelo.daos;

import com.ejemplogeneraljpa.modelo.entidades.Profesor;
import java.util.List;

/**
 *
 * @author manuelconde
 */
public interface IDaoProfesor {
    
    public Profesor verProfesor(int idProfesor);
    public List<Profesor> verProfesores();
    public void crearProfesor(Profesor profesor);
    public void actualizarProfesor(int idProfesor, Profesor profesor);
    public void borrarProfesor(int idProfesor);
}