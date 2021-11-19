/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades;

/**
 *
 * @author manuelconde
 */
public class Ingrediente {
    
    private int id_ingrediente;
    private Alimento alimento;
    private float cantidad;
    
    
    public Ingrediente() {
        
    }
    
    public Ingrediente(int id_ingrediente, Alimento alimento, float cantidad) {
        
        this.id_ingrediente = id_ingrediente;
        this.alimento = alimento;
        this.cantidad = cantidad;
    }

    
    public int getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(int id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
}