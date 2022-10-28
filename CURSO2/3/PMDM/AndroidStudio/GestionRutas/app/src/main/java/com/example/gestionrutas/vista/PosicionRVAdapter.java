package com.example.gestionrutas.vista;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gestionrutas.R;
import com.example.gestionrutas.modelo.entidades.Posicion;
import com.example.gestionrutas.vista.PosicionFragment.OnListFragmentInteractionListener;

import java.util.ArrayList;


public class PosicionRVAdapter extends RecyclerView.Adapter<PosicionRVAdapter.ViewHolder> {


    private final ArrayList<Posicion> posiciones;
    private final OnListFragmentInteractionListener mListener;


    public PosicionRVAdapter(ArrayList<Posicion> items, OnListFragmentInteractionListener listener) {

        this.posiciones = items;
        this.mListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_posicion, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final Posicion posicion;
        posicion = this.posiciones.get(position);

        holder.textViewNombre.setText(posicion.getNombre());
        holder.textViewLatitud.setText(Double.toString(posicion.getLatitud()));
        holder.textViewLongitud.setText(Double.toString(posicion.getLongitud()));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onListFragmentInteraction(posicion);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.posiciones.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        public final TextView textViewNombre;
        public final TextView textViewLatitud;
        public final TextView textViewLongitud;


        public ViewHolder(View view) {
            super(view);

            this.mView = view;
            this.textViewNombre = view.findViewById(R.id.posicion_nombre);
            this.textViewLatitud = view.findViewById(R.id.posicion_latitud);
            this.textViewLongitud = view.findViewById(R.id.posicion_longitud);
        }
    }
}




