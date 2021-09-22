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
public interface IDaoParte {
    
    public void crearParte();
    public void modificarParte(int idParte);
    public void borrarParte(int idParte);
    public ArrayList<Parte> obtenerPartes();
}