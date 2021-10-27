/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ventanaxml;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author enrique
 */
public class Ventana extends JFrameXML {
    
    
    public Ventana() throws Exception{
        
        
        setContentView("vista.xml");
        
        JButton boton1=(JButton)this.getViewFindByID("boton1");
        JButton boton2=(JButton)this.getViewFindByID("boton2");
        
         boton1.addActionListener(
                       evento -> {
                    
                            pulsar(evento);
                       
                        });
       
         boton2.addActionListener(
                       evento -> {
                    
                            System.out.println("se pulso botón 2");
                       
                        });

        System.out.println("termino");
    }

  
    public static void main(String[] args) throws Exception  {
        
        new Ventana();
        
    }
    
    public void pulsar(ActionEvent ev){
        
        System.out.println("se pulso botón 1");
    
    }
    
}
