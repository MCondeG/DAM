/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades;

/**
 *
 * @author manuelconde
 */
public class Alimento {
    
    private int id_alimento;
    private String nombre;
    private float grprot;
    private float grgrasa;
    private float grhidratos;
    
    
    public Alimento() {
        
    }
    
    public Alimento(int id_alimento, String nombre, float grprot, float grgrasa, float grhidratos) {
        
        this.id_alimento = id_alimento;
        this.nombre = nombre;
        this.grprot = grprot;
        this.grgrasa = grgrasa;
        this.grhidratos = grhidratos;
    }
    

    public int getId_alimento() {
        return id_alimento;
    }

    public void setId_alimento(int id_alimento) {
        this.id_alimento = id_alimento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getGrprot() {
        return grprot;
    }

    public void setGrprot(float grprot) {
        this.grprot = grprot;
    }

    public float getGrgrasa() {
        return grgrasa;
    }

    public void setGrgrasa(float grgrasa) {
        this.grgrasa = grgrasa;
    }

    public float getGrhidratos() {
        return grhidratos;
    }

    public void setGrhidratos(float grhidratos) {
        this.grhidratos = grhidratos;
    }   
}