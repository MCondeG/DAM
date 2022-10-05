/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.miventana;

import javax.swing.JFrame;

/**
 *
 * @author enrique
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Manejador manejador=new Manejador();
        Ventana ventana = new Ventana(manejador);
        ventana.setVisible(true);
    }
    
}
