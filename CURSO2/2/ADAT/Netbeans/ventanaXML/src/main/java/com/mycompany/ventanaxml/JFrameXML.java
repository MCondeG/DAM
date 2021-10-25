/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventanaxml;

import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import utilidades.ParserXML;

/**
 *
 * @author enrique
 */
public class JFrameXML extends JFrame{
    
    JFrame ventana;
    
    HashMap<String,Object> componentes=new HashMap<>();
    
    
    public JFrameXML(){
        
        super();
        
        
    }

    void setContentView(String archivoxml) throws Exception {
        
        
        ParserXML parser=new ParserXML(archivoxml);
        componentes=new ParserXML(archivoxml).procesarFichero();
        JFrame ventana=(JFrame)this.getViewFindByID("ventana");
        ventana.setVisible(true);
        
      


    }
   
    
    public Object getViewFindByID (String id){
     
        return componentes.get(id);
    }
    
}
