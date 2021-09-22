package modelo.entidades;

import java.util.ArrayList;

public class Parte {

    private int idParte;

    private ArrayList<Incidencia> listaIncidencias;


    public Parte() {
        this.listaIncidencias = new ArrayList<>();
    }

    public Parte(int idParte, ArrayList<Incidencia> listaIncidencias) {
        this.idParte = idParte;
        this.listaIncidencias = listaIncidencias;
    }


    public int getIdParte() {
        return idParte;
    }

    public void setIdParte(int idParte) {
        this.idParte = idParte;
    }

    public ArrayList<Incidencia> getListaIncidencias() {
        return listaIncidencias;
    }

    public void setListaIncidencias(ArrayList<Incidencia> listaIncidencias) {
        this.listaIncidencias = listaIncidencias;
    }
}