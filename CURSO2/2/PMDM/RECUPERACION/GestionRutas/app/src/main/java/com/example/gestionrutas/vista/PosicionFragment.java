package com.example.gestionrutas.vista;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gestionrutas.R;
import com.example.gestionrutas.modelo.colecciones.ListaGlobal;
import com.example.gestionrutas.modelo.entidades.Posicion;

import java.util.ArrayList;


public class PosicionFragment extends Fragment {


    private ListaGlobal datos = ListaGlobal.getGlobalData();
    private ArrayList<Posicion> listaPosiciones;

    private int mColumnCount;

    private PosicionRVAdapter adapter;
    private RecyclerView recyclerView;
    private OnListFragmentInteractionListener mListener;


    public PosicionFragment() {

        this.mColumnCount = 1;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_posicion_list, container, false);

        this.listaPosiciones = datos.getPosiciones().getListaPosiciones();

        this.adapter = new PosicionRVAdapter(this.listaPosiciones, this.mListener);

        // Definir el reciclerview
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            this.recyclerView = (RecyclerView) view;

            if (this.mColumnCount <= 1) {
                this.recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                this.recyclerView.setLayoutManager(new GridLayoutManager(context, this.mColumnCount));
            }

            this.recyclerView.setAdapter(adapter);
        }

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnListFragmentInteractionListener) {
            this.mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " Se debe implementar OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.mListener = null;
    }


    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Posicion item);
    }
}