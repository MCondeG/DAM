package com.example.formulario1;

import java.io.Serializable;

public class Formulario implements Serializable {

    private String nombre;
    private String pass;
    private boolean cb;
    private String rb;


    public Formulario() {}

    public Formulario(String nombre, String pass, boolean cb, String rb) {

        this.nombre = nombre;
        this.pass = pass;
        this.cb = cb;
        this.rb = rb;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isCb() {
        return cb;
    }

    public void setCb(boolean cb) {
        this.cb = cb;
    }

    public String getRb() {
        return rb;
    }

    public void setRb(String rb) {
        this.rb = rb;
    }
}