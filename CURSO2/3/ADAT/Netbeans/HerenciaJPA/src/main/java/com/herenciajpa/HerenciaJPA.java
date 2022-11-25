/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.herenciajpa;

import com.herenciajpa.modelo.daos.DaoPersona;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author manuelconde
 */
public class HerenciaJPA {

    public static void main(String[] args) {
        
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("HerenciaJPAPU");
            DaoPersona p = new DaoPersona(emf);
            
            System.out.println(p.verPersonas());
        }
        catch (Exception e){
            System.err.println("ERROR");
            e.printStackTrace();
        }
    }
}
