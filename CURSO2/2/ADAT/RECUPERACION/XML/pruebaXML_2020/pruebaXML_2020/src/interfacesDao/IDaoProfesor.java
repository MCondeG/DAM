/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesDao;

import java.util.ArrayList;
import modelo.Profesor;

/**
 *
 * @author enrique
 */
public interface IDaoProfesor {
    
    public void guardarProfesor(Profesor p);
    public ArrayList<Profesor> verProfesores();
    
    
}
