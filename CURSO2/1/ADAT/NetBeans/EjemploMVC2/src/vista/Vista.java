/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.*;

/**
 *
 * @author MRCon
 */
public class Vista {
    
    private String usuario;
    private String contraseña;
    
    private static Scanner sc = new Scanner(System.in);
    
    
    public Vista() {
        
    }

    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    public void pedirDatos() {
        
        System.out.println();
        
        System.out.println("Introduce Usuario");
        this.usuario = sc.next();
        
        System.out.println();
        
        System.out.println("Introduce Contraseña");
        this.contraseña = sc.next();
        
        System.out.println("\n");
    }
    
    public void mostrarVerificacion() {
        
        System.out.println("Usuario verificado. Bienvenido\n\n");
    }
    
    public void mostrarError() {
        
        System.out.println("Usuario erroneo\n\n");
    }
    
    public int mostrarMenu(int n) {
        
        System.out.println("Elija opción:");
        System.out.println("1. Añadir usuario");
        System.out.println("2. Listar usuarios");
        System.out.println("Por defecto. Salir");
        
        n = sc.nextInt();
        
        return n;
    }
    
    public void listar(modelo.Persona p){   
        System.out.println(p);
    }
    
    public void salto() {
        System.out.println();
    }
}
