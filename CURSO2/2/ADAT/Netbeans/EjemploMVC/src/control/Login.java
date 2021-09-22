/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.*;

/**
 *
 * @author manuelconde
 */
public abstract class Login {
        
    
    public Login() {
        
    }
    
    
    public static boolean comprobar(Usuario u, ListaUsuarios usuarios) {
        
        boolean coincide = false;
        
        for (int i = 0; i < usuarios.getUsuarios().size(); i++) {
            
            Usuario user = new Usuario(usuarios.getUsuarios().get(i).getUser(), usuarios.getUsuarios().get(i).getPassword());
            
            if ((u.getUser().compareTo(user.getUser()) == 0) && (u.getPassword().compareTo(user.getPassword()) == 0)) {
                coincide = true;
            }
        }
        
        return coincide;
    }
}