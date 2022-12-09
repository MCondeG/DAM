/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.manuelconde_examenada1;

import com.manuelconde_examenada1.modelo.daos.DaoAlimento;
import com.manuelconde_examenada1.modelo.daos.DaoIngrediente;
import com.manuelconde_examenada1.modelo.daos.DaoReceta;
import com.manuelconde_examenada1.modelo.entidades.Ingrediente;
import com.manuelconde_examenada1.modelo.entidades.Receta;
import com.manuelconde_examenada1.modelo.xml.ParserXML;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuelconde
 */
public class Main {

    public static void main(String[] args) {
        
        Receta receta = XML();
        
        JPA(receta);
    }
    
    
    public static Receta XML() {
        
        ParserXML parser = new ParserXML();
        Receta receta = null;
        double KcalTotal;
        
        try {
            parser.leerXML("src/main/java/com/manuelconde_examenada1/modelo/xml/recetas.xml");
            
            ArrayList<Ingrediente> ingredientes = parser.getHandler().getIngredientes();
            
            KcalTotal = calcularCalorias(ingredientes);
            
            receta = parser.getHandler().getRecetas().get(0);
            receta.setTotalKcal(KcalTotal);
            
            System.out.println("\n\nTotal Kcal receta = " + KcalTotal);      
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return receta;
    }
    
    public static double calcularCalorias(ArrayList<Ingrediente> ingredientes) {
        
        double prot = 0;
        double grasa = 0;
        double hid = 0;
        
        for (Ingrediente i : ingredientes) {
            
            prot = (i.getIdAlimento().getGrprot() * i.getCantidad()) + prot;
            grasa = (i.getIdAlimento().getGrgrasa() * i.getCantidad()) + grasa;
            hid = (i.getIdAlimento().getGrhidratos() * i.getCantidad()) + hid;
        }
        
        double Kcal = ((prot*4) + (grasa*9) + (hid*4))/100;
        
        return Kcal;
    }
    
    
    public static void JPA(Receta receta) {
        
        DaoAlimento daoA = new DaoAlimento();
        DaoIngrediente daoI = new DaoIngrediente();
        DaoReceta daoR = new DaoReceta();
        
        int cont = 1;
        
        for (Ingrediente i : receta.getIngredienteList()) {
            
            i.getIdAlimento().setIdAlimento(cont);
            i.setIdIngrediente(cont);
            i.setIdReceta(receta);
            
            daoA.crearAlimento(i.getIdAlimento());
            daoI.crearIngrediente(i);
            
            cont++;
        }
        
        daoR.crearReceta(receta);
        daoR.actualizarReceta("tostada");
    }
}