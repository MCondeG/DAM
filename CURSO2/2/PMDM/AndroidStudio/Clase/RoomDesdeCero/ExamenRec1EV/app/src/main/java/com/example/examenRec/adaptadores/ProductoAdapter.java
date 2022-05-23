package com.example.examenRec.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdesdecero.R;
import com.example.examenRec.room.Producto;

import java.util.ArrayList;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {

    ArrayList<Producto> listaProducto;

    public ProductoAdapter(ArrayList<Producto> listaproducto) {

        this.listaProducto = listaproducto;
    }

    @Override
    public ProductoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_producto, null, false);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductoViewHolder holder, int position) {
        holder.txtNombre.setText(listaProducto.get(position).getNombrePro());
        holder.txtInformacion.setText(listaProducto.get(position).getPrecio()+ "€");

    }

    @Override
    public int getItemCount() {
        return listaProducto.size();
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtNombre, txtInformacion;


        public ProductoViewHolder(View itemView) {
            super(itemView);
            txtNombre = (TextView) itemView.findViewById(R.id.idNombrePro);
            txtInformacion = (TextView) itemView.findViewById(R.id.idInfoPre);

        }

    }

    public String getItem(int id) {
        return listaProducto.get(id).getNombrePro();
    }



    /*private AlertDialog alertEditKcal(View vi, int posicion) {

        LayoutInflater inflater = LayoutInflater.from(vi.getContext());
        View view = inflater.inflate(R.layout.dialogo_edit_ali, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(vi.getContext());
        builder
                .setView(view)
                .setTitle("Introduzca Cantidad KCAl a modificar")
                .setPositiveButton("OK", (dialog, id) -> {
                    EditText editText = (EditText) (view.findViewById(R.id.et_nombre));
                    Editable texto = editText.getText();
                    Toast.makeText(vi.getContext(), texto.toString(), Toast.LENGTH_SHORT).show();
                    listaProducto.get(posicion).setkCal(texto.toString());

                })

                .setNegativeButton("Cancelar", (dialog, id) -> {
                    dialog.cancel();
                });

        AlertDialog dialogo = builder.create();
        dialogo.show();

        return dialogo;
    }

    public AlertDialog AlertañadirAli(View vi) {

        LayoutInflater inflater = LayoutInflater.from(vi.getContext());
        View view = inflater.inflate(R.layout.dialogo_addali, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(vi.getContext());
        builder
                .setView(view)
                .setTitle("Introduzca Cantidad KCAl a modificar")
                .setPositiveButton("OK", (dialog, id) -> {
                    EditText edit_nombre = (EditText) (view.findViewById(R.id.et_nombre));
                    Editable textoNombre = edit_nombre.getText();
                    EditText edit_kcal= (EditText)(view.findViewById((R.id.et_cantidad)));
                    Editable textoKcal= edit_kcal.getText();

                    Toast.makeText(vi.getContext(), textoNombre.toString(), Toast.LENGTH_SHORT).show();

                    listaProducto.add(new Producto(textoNombre.toString(),textoKcal.toString()));
                    notifyDataSetChanged();


                })

                .setNegativeButton("Cancelar", (dialog, id) -> {
                    dialog.cancel();
                });

        AlertDialog dialogo = builder.create();
        dialogo.show();

        return dialogo;
    }

*/

}