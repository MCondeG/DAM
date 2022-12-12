package com.example.examenada2.adapters;

import com.example.examenada2.R;
import com.example.examenada2.daos.daoAlumno;
import com.example.examenada2.models.Alumnos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterAlumnos extends RecyclerView.Adapter<AdapterAlumnos.ViewHolderAlumnos> {
    @NonNull
    @Override
    public ViewHolderAlumnos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        return new ViewHolderAlumnos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAlumnos holder, int position) {
        holder.asignDatos(daoAlumno.getAlumnos().get(position));
    }

    @Override
    public int getItemCount() {
        return daoAlumno.getAlumnos().size();
    }

    public class ViewHolderAlumnos extends RecyclerView.ViewHolder {

        TextView alumno;
        ImageButton delete;

        View view;

        public ViewHolderAlumnos(@NonNull View itemView) {
            super(itemView);
            alumno = itemView.findViewById(R.id.textViewAlumno);
            delete = itemView.findViewById(R.id.imageButton);
            view = itemView;
        }

        public void asignDatos(Alumnos alumnos) {
            alumno.setText(alumnos.toString());
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View viewb) {
                    int idx = daoAlumno.getAlumnos().indexOf(alumnos);
                    daoAlumno.getAlumnos().remove(idx);
                    notifyItemRemoved(idx);
                }
            });
        }
    }
}
