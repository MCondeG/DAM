/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Scanner;
import modelo.Usuario;

/**
 *
 * @author manuelconde
 */
public class Input {
    
    private Scanner sc;
    private String user;
    private String pass;
    
    public Input() {
        this.sc = new Scanner(System.in);
        this.user = "";
        this.pass = "";
    }
    
    
    public Usuario bienvenida() {
        
        System.out.println("Introduce tus datos de usuario:");
        System.out.print("Nombre: ");
        this.user = this.sc.next();
        System.out.print("Contraseña: ");
        this.pass = this.sc.next();
        
        return (new Usuario(user, pass));
    }
}
