/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miventana;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author enrique
 */
class Ventana extends JFrame implements ActionListener{
      
  
    
   public Ventana(Manejador manejador){
       
        super("Ventana");
        setSize(200,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        JButton boton1 = new JButton("Boton 1");
        cp.add(boton1);
        JButton boton2 = new JButton("Boton 2");
        cp.add(boton2);
        JButton boton3 = new JButton("Boton 3");
        cp.add(boton3);
        JButton boton4 = new JButton("Boton 4");
        cp.add(boton4);
        JButton boton5 = new JButton("Boton 5");
        cp.add(boton5);
        
        
        //El Manejador de eventos es una clase externa que se ha inyectado
        // desde fuera
        boton1.addActionListener(manejador);
        
        
         //El Manejador de eventos es la propia ventana
        boton2.addActionListener(this);
        
        // el manejador es una clase interna 
        boton3.addActionListener(new ManejadorInterno());
        
        
        // el manejador es una clase interna anónima dentro del botón
        boton4.addActionListener(
        
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                                
                       boton4.setText("hola");
                    }
                    
                    
                });
        
           // el manejador es una clase interna anónima dentro del botón
        boton4.addActionListener(
                (ActionEvent arg0) -> {boton4.setText("hola");
        });
        
        
        // Ahora la clase interna anónima se maneja como una función lambda
        // Esto se puede hacer porque el interfaz solo tiene un solo método
        // y sigue el siguiente esquema
        /*
            (parámetros de entrada a la función) -> {código de salida}
        
        
        */
        boton5.addActionListener(
                
                
                
                (e)-> {boton5.setText("hola boton 5");}
        
        
           
        
        
        );
                    
                
        
        
        
       
        
       
       
   } 
 
 class ManejadorInterno implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            
        }
       
    
  }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        boton.setText("¡Gracias!");

    }
    
    
    
}
