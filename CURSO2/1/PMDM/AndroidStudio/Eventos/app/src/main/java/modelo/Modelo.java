package modelo;

import java.util.*;

public class Modelo {

    private ArrayList<Usuario> listaUsuarios;


    public Modelo() {
        this.listaUsuarios = new ArrayList<> ();

        inicializaLista(this.listaUsuarios);
    }


    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }


    private static void inicializaLista(ArrayList <Usuario> listaUsuarios) {

        for (int i = 0; i < 10; i++) {
            listaUsuarios.add(new Usuario());
        }
    }

    private static Iterator<Usuario> creaIterador(ArrayList <Usuario> listaUsuarios) {

        Iterator<Usuario> it = listaUsuarios.iterator();

        return it;
    }

    public boolean buscar(Usuario p) {

        boolean b = false;

        Iterator<Usuario> it = creaIterador(this.listaUsuarios);

        while (it.hasNext()) {

            Usuario p2 = new Usuario();
            p2 = it.next();

            if ((p.getNombre().equals(p2.getNombre()) && (p.getContraseña().equals(p2.getContraseña())))) b = true;
        }

        return b;
    }
}