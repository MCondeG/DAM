package com.example.examenRec;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roomdesdecero.R;
import com.example.examenRec.adaptadores.ProductoAdapter;
import com.example.examenRec.room.Producto;

import java.util.ArrayList;

public class FragProducto extends Fragment {

    private RecyclerView recyclerProductos;
    public static ArrayList<Producto> listaproductos;
    ProductoAdapter adapter;

    public FragProducto() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_frag_producto, container, false);

        listaproductos = new ArrayList<>();

        recyclerProductos=(RecyclerView) vista.findViewById(R.id.recyclerId);
        recyclerProductos.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarLista();

        adapter= new ProductoAdapter(listaproductos);

        recyclerProductos.setAdapter(adapter);

        return inflater.inflate(R.layout.fragment_frag_producto, container, false);

    }
    private void llenarLista() {
        Producto p1= new Producto();
        p1.setIdProducto(3);
        p1.setNombrePro("raton");
        p1.setPrecio(80);
        listaproductos.add(p1);

    }
}