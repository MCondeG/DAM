/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import com.mycompany.ventanaxml.Ventana;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author enrique
 */
public class VentanaHandlerXML extends DefaultHandler{
    
    JFrame ventana;
    Container cp;
    
    HashMap<String,Object> componentes=new HashMap<>();
    
      
    public HashMap<String, Object> getComponentes() {
        return componentes;
    }
  

          
    @Override
    public void startDocument() throws SAXException {
       
          
    }
    
    @Override
    public void startElement(String uri, String nombreLocal, String nombreCualif, Attributes atrbts) throws SAXException {
       
       String etiqueta=nombreCualif;
        
        switch(etiqueta){
            
            case "JFrame":{
               
                        
                ventana=new JFrame();
                ventana.setTitle(atrbts.getValue("titulo"));
                ventana.setSize( Integer.parseInt(atrbts.getValue("alto")),Integer.parseInt(atrbts.getValue("ancho")));
                if(atrbts.getValue("setDefaultCloseOperation").equals("on")){
                    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
                componentes.put(atrbts.getValue("id"), ventana);
                
            }
            break;
            case "FlowLayout":{
                
                cp=ventana.getContentPane();
                cp.setLayout(new FlowLayout());
                
            }
            break;
            case "JButton":{
                JButton boton=new JButton();
                boton.setText(atrbts.getValue("nombre"));
//                if(atrbts.getValue("onClick")!=null){
//                    
//                   boton.addActionListener(
//                       evento -> {
//                       try {
//                            Class.forName("com.mycompany.ventanaxml.Ventana").getMethod(atrbts.getValue("onClick")).invoke(evento);
//                            } catch (Exception e) {}
//                       
//                        });
//                   
//                }
                cp.add(boton);
                componentes.put(atrbts.getValue("id"), boton);
            }
            break;
        }
        
       
       
        
     }
    
    @Override
    public void characters(char[] chars, int inicio, int lon) throws SAXException {
         }
    
    @Override
    public void endElement(String uri, String nombreLocal, String nombreCualif) throws SAXException {
       }
    
    @Override
    public void endDocument() throws SAXException {
        
       
         }
   

   

   

    

   
    
}
