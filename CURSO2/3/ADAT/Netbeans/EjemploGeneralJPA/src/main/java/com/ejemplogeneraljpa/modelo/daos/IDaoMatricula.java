/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejemplogeneraljpa.modelo.daos;

import com.ejemplogeneraljpa.modelo.entidades.Matricula;
import java.util.List;

/**
 *
 * @author manuelconde
 */
public interface IDaoMatricula {
    
    public Matricula verMatricula(int idMatricula);
    public List<Matricula> verMatricula();
    public void crearMatricula(Matricula matricula);
    public void actualizarMatricula(int idMatricula, Matricula matricula);
    public void borrarMatricula(int idMatricula);
}