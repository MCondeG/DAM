/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebalambda;

/**
 *
 * @author enrique
 */
public class PruebaCalculadora {
    
    Calculadora opSuma, opResta;
    
    public PruebaCalculadora(){
        
         opSuma=new Calculadora();
         
         opResta=new Calculadora();
         
         int valor=opSuma.operacion(5, 6);
         
         int valor2=opResta.operacion(5,6);
         
         
        
    }
    
    
    
}
    
    

