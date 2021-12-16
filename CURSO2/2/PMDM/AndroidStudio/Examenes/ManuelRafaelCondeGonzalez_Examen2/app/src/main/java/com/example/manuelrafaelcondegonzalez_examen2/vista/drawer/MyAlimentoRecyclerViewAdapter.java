package com.example.manuelrafaelcondegonzalez_examen2.vista.drawer;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.manuelrafaelcondegonzalez_examen2.R;
import com.example.manuelrafaelcondegonzalez_examen2.modelo.entidades.Alimento;
import com.example.manuelrafaelcondegonzalez_examen2.vista.drawer.placeholder.PlaceholderContent.PlaceholderItem;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyAlimentoRecyclerViewAdapter extends RecyclerView.Adapter<MyAlimentoRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<Alimento> alimentos;
    private final OnListFragmentInteractionListener mListener;

    public MyAlimentoRecyclerViewAdapter(ArrayList<Alimento> items, OnListFragmentInteractionListener listener) {
        alimentos = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_alimento, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ;
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        public final TextView textViewNombre;
        public final TextView textViewCalorias;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewNombre = view.findViewById(R.id.nombre);
            textViewCalorias = view.findViewById(R.id.calorias);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}