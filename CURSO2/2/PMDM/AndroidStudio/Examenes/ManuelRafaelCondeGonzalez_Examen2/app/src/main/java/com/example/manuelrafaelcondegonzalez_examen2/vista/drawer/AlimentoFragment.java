package com.example.manuelrafaelcondegonzalez_examen2.vista.drawer;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manuelrafaelcondegonzalez_examen2.R;
import com.example.manuelrafaelcondegonzalez_examen2.modelo.entidades.Alimento;
import com.example.manuelrafaelcondegonzalez_examen2.vista.drawer.placeholder.PlaceholderContent;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class AlimentoFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    private ArrayList<Alimento> alimentos;

    private RecyclerView recyclerView;

    private MyAlimentoRecyclerViewAdapter adapterAlimentos;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AlimentoFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static AlimentoFragment newInstance(int columnCount) {
        AlimentoFragment fragment = new AlimentoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alimento_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyAlimentoRecyclerViewAdapter(PlaceholderContent.ITEMS));
        }
        return view;
    }
}