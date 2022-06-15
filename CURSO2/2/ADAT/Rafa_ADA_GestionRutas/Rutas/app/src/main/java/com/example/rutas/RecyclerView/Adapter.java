package com.example.rutas.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import android.widget.TextView;


import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.rutas.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;

    public Adapter(List<ListElement> itemList, Context context){

        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount(){
        return mData.size();

    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_element,null);
        return new Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.bindData(mData.get(position));
    }



    public  void seeItems(List<ListElement> items){
        mData=items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView iconimage;
        TextView textviewRuta,RutaTV,status;

        ViewHolder(View itemview){
            super(itemview);
            iconimage =itemview.findViewById(R.id.IconImage);
            textviewRuta=itemview.findViewById(R.id.textviewRuta);
            RutaTV=itemview.findViewById(R.id.RutaTV);
            status=itemview.findViewById(R.id.status);
        }

        void bindData(final ListElement item){
            iconimage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            RutaTV.setText(item.getRuta());
            status.setText(item.getStatus());
        }
    }
}
