/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejemplogeneraljpa.modelo.daos;

import com.ejemplogeneraljpa.modelo.entidades.Asignatura;
import java.util.List;

/**
 *
 * @author manuelconde
 */
public interface IDaoAsignatura {
    
    public Asignatura verAsignatura(int idAsignatura);
    public List<Asignatura> verAsignaturas();
    public void crearAsignatura(Asignatura asignatura);
    public void actualizarAsignatura(int idAsignatura, Asignatura asignatura);
    public void borrarAsignatura(int idAsignatura);
}