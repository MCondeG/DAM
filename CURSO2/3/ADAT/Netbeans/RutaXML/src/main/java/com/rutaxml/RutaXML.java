/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.rutaxml;

import com.rutaxml.modelo.Lugares;
import com.rutaxml.xml.ParserXML;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuelconde
 */
public class RutaXML {

    public static void main(String[] args) {
        
        ParserXML parser = new ParserXML();
        
        Lugares lugares = Lugares.getInstance();
        
        
        try {
            parser.leerXML("src/main/java/com/rutaxml/xml/lugares.xml");
        } catch (Exception ex) {
            Logger.getLogger(RutaXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("\n\n");
        
        lugares.mostrar();
    }
}