
package com.miguelcr.mecaround.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseDatamasterData {

    @SerializedName("marcas")
    @Expose
    private List<Marca> marcas = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResponseDatamasterData() {
    }

    /**
     * 
     * @param marcas
     */
    public ResponseDatamasterData(List<Marca> marcas) {
        super();
        this.marcas = marcas;
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    public ResponseDatamasterData withMarcas(List<Marca> marcas) {
        this.marcas = marcas;
        return this;
    }

}
