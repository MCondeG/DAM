package Daos;

import java.util.ArrayList;

import entidades.Parte;
import interfacesDaos.interfaceDaoParte;

public class DaoParte extends Dao implements interfaceDaoParte {


    @Override
    public void addParte(Parte parte) {
        partes.add(parte);
    }

    @Override
    public ArrayList<Parte> verPartes() {
        return partes;
    }
}
