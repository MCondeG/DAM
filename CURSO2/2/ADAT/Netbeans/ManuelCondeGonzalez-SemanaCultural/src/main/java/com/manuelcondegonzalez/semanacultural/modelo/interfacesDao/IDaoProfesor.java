/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.manuelcondegonzalez.semanacultural.modelo.interfacesDao;

import com.manuelcondegonzalez.semanacultural.modelo.entidades.Profesor;
import java.util.ArrayList;

/**
 *
 * @author manuelconde
 */
public interface IDaoProfesor {
    
    public boolean createProfesor(Profesor p);
    public boolean updateProfesor(int id, Profesor p);
    public boolean deleteProfesor(int id);
    public ArrayList<Profesor> readProfesor();
    public Profesor readProfesorById(int id);
}