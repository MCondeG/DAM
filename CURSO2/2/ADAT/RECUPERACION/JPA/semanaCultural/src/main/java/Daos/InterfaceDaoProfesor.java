/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Daos;

import entidades.Profesor;
import entidades.Taller;
import java.util.List;

/**
 *
 * @author enrique
 */
public interface InterfaceDaoProfesor {
    
    public List<Profesor> verProfesores();
    public void crearProfesor(Profesor profesor);
    public void actualizarProfesor(Profesor profesor);
    public void borrarProfesor(Profesor profesor);
    public Profesor getProfesor(int idProfesor);
    public Profesor getProfesor(String nombre);
    public List<Taller> getTalleres(Profesor profesor);
    
    
}
