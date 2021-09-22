/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import vista.*;
import modelo.*;

/**
 *
 * @author manuelconde
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean valido;
        
        ListaUsuarios usuarios = new ListaUsuarios();
        Input inp = new Input();
        Usuario usuario = new Usuario();
        
        
        do {
            
            usuario = inp.bienvenida();
            valido = Login.comprobar(usuario, usuarios);
            Output.validacion(valido);
            
            System.out.println();
            
        } while (!(valido));
    }
}