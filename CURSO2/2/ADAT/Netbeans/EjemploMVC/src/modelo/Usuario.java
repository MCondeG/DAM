/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author manuelconde
 */
public class Usuario {
 
    private String user;
    private String password;
    
    
    public Usuario(String user, String password) {
        
        this.user = user;
        this.password = password;
    }

    public Usuario() {
    }

    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}