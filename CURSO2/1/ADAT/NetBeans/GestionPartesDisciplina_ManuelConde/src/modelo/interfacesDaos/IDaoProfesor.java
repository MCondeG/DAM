/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfacesDaos;

import java.util.ArrayList;
import modelo.entidades.Parte;

/**
 *
 * @author usuario
 */
public interface IDaoProfesor {
    
    public ArrayList<Parte> obtenerPartesProfesor(int idProfesor);
}