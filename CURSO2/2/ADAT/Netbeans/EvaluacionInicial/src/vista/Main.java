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

import control.Controlador;
import java.util.Scanner;
import modelo.ListaViviendas;
import modelo.ListaUsuarios;

public class Main {
    
    public static void main (String [ ] args) {
        
        int n, cod;
        boolean disp;
        String nombre;
        Scanner sc = new Scanner(System.in);
        
        ListaViviendas viviendas = Controlador.inicio();
        ListaUsuarios usuarios = new ListaUsuarios();
        
        do {
            
            System.out.println("ALQUILER DE VIVIENDAS");
            System.out.println("Introduzca operación:\n");
            System.out.println("1 - Listar viviendas");
            System.out.println("2 - Alquilar vivienda");
            System.out.println("3 - Cancelar vivienda");
            System.out.println("0 - SALIR");
            
            do {
                n = sc.nextInt();
            }while(n < 0 || n > 3);
            
            switch(n) {
                case 0:
                    break;
                case 1:
                    Controlador.listar(viviendas);
                    break;
                case 2:
                    System.out.println("\nIntroduce el código de la vivienda");
                    cod = sc.nextInt();
                    disp = Controlador.comprobar(viviendas, cod);
                    
                    if(disp) {
                        
                        System.out.println("Introduzca su nombre para añadirlo al sistema");
                        
                        nombre = sc.next();
                        usuarios.añadirUsuario(nombre);
                        
                        
                        
                        
                    }
                    
                    break;
                case 3:
                    break;
            }
        
        } while(n != 0); 
    }
}