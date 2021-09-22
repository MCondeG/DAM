/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author manuelconde
 */
public abstract class Output {
    
    public static void validacion(boolean p) {
        
        if(p) System.out.println("Usuario validado!!");
        else System.err.println("Usuario erroneo. Introduzca de nuevo");
    }
}