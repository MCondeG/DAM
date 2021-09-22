package modelo.interfacesDaos;

import java.util.ArrayList;

import modelo.entidades.Parte;

public interface IDaoParte {

    public void addParte(Parte parte);
    public ArrayList<Parte> verPartes();
}