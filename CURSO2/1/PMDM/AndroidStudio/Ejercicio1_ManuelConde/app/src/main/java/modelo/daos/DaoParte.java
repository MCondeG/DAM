package modelo.daos;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.entidades.Parte;
import modelo.interfacesDaos.IDaoParte;

public class DaoParte extends Dao implements IDaoParte, Serializable {


    public DaoParte() {

    }


    @Override
    public void addParte(Parte parte) {
        this.listaPartes.add(parte);
    }

    @Override
    public ArrayList<Parte> verPartes() {
        return listaPartes;
    }
}