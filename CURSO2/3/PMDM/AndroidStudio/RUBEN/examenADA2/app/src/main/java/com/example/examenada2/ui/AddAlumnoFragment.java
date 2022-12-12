package com.example.examenada2.ui;

import android.os.Bundle;


import com.example.examenada2.daos.daoAlumno;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.examenada2.R;
import com.example.examenada2.models.Alumnos;

public class AddAlumnoFragment extends Fragment {

    public AddAlumnoFragment() {
    }

    public static AddAlumnoFragment newInstance(String param1, String param2) {
        AddAlumnoFragment fragment = new AddAlumnoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_alumno, container, false);

        view.findViewById(R.id.add_alumno_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewb) {
                EditText nombre = view.findViewById(R.id.editTextNombre);
                EditText apellidos = view.findViewById(R.id.editTextApellidos);
                EditText DNI = view.findViewById(R.id.editTextDNI);
                EditText notaMedia = view.findViewById(R.id.editTextNotaMedia);
                if (!nombre.getText().toString().equals("") && !apellidos.getText().toString().equals("") && !DNI.getText().toString().equals("") && !notaMedia.getText().toString().equals("")){
                    Alumnos al = new Alumnos();
                    al.setNombre(nombre.getText().toString());
                    al.setApellidos(apellidos.getText().toString());
                    al.setDNI(DNI.getText().toString());
                    al.setNotaMedia(Float.valueOf(notaMedia.getText().toString()));
                    daoAlumno.addAlumno(al);
                    Log.i("E", daoAlumno.showAlumnos());
                    Navigation.findNavController(view).navigateUp();
                }else{
                    Toast.makeText(getActivity(), "Rellena todos los campos para añadir un alumnos por favor", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}