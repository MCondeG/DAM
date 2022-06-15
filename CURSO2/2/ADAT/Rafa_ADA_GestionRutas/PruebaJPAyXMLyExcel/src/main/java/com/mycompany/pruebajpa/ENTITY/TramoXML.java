/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebajpa.ENTITY;

/**
 *
 * @author rafa
 */
public class TramoXML {
    
    private Integer idtramo;
    private String nodoInicial; 
    private Float distancia;
    private String nodoFinal;
    private String velocidad;
    private String tiempoTeorico;
    private String tiempoReal;
    private String rumbo;
    private String descripcionT;

    public TramoXML(String nodoInicial, String nodoFinal, Float distancia) {
        this.nodoInicial = nodoInicial;
        this.nodoFinal = nodoFinal;
        this.distancia = distancia;
    }

    
    
    
    public TramoXML() {
    }

    public TramoXML(Integer idtramo, Float distancia,String nodoInicial, String nodoFinal, String velocidad, String tiempoTeorico, String tiempoReal, String rumbo, String descripcionT) {
        this.idtramo = idtramo;
        this.distancia = distancia;
        this.nodoInicial = nodoInicial;
        this.nodoFinal = nodoFinal;
        this.velocidad = velocidad;
        this.tiempoTeorico = tiempoTeorico;
        this.tiempoReal = tiempoReal;
        this.rumbo = rumbo;
        this.descripcionT= descripcionT;
    }

    public String getDescripcionT() {
        return descripcionT;
    }

    public void setDescripcionT(String descripcionT) {
        this.descripcionT = descripcionT;
    }
    

    public Integer getIdtramo() {
        return idtramo;
    }

    public void setIdtramo(Integer idtramo) {
        this.idtramo = idtramo;
    }

    public String getNodoInicial() {
        return nodoInicial;
    }

    public void setNodoInicial(String nodoInicial) {
        this.nodoInicial = nodoInicial;
    }

    public String getNodoFinal() {
        return nodoFinal;
    }

    public void setNodoFinal(String nodoFinal) {
        this.nodoFinal = nodoFinal;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public String getTiempoTeorico() {
        return tiempoTeorico;
    }

    public void setTiempoTeorico(String tiempoTeorico) {
        this.tiempoTeorico = tiempoTeorico;
    }

    public String getTiempoReal() {
        return tiempoReal;
    }

    public void setTiempoReal(String tiempoReal) {
        this.tiempoReal = tiempoReal;
    }

    public String getRumbo() {
        return rumbo;
    }

    public void setRumbo(String rumbo) {
        this.rumbo = rumbo;
    }

    public Float getDistancia() {
        return distancia;
    }

    public void setDistancia(Float distancia) {
        this.distancia = distancia;
    }
    
    
    
    

}
