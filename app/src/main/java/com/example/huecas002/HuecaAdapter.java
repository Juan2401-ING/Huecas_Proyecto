package com.example.huecas002;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HuecaAdapter extends RecyclerView.Adapter<HuecaAdapter.ViewHolder> {


    public interface  OnItemClickListener{
        void onItemClick(Hueca hueca);
    }

    public static class  ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre, prioridad, direccion;
        //ImageView fotoHueca;
        public ViewHolder(View itemView){
            super(itemView);
            nombre= (TextView) itemView.findViewById(R.id.text_huecanombre);
            prioridad= (TextView) itemView.findViewById(R.id.text_priority);
            direccion= (TextView) itemView.findViewById(R.id.txt_direccion);
            //fotoHueca= (ImageView) itemView.findViewById(R.id.imagenView);
        }
    }
    public List<Hueca> huecaList;

    public HuecaAdapter(List<Hueca> huecaList) {

        this.huecaList = huecaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.huecaitem1,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        final Hueca item = huecaList.get(position);
        holder.nombre.setText(huecaList.get(position).getNombre());
        holder.prioridad.setText(""+huecaList.get(position).getPrioridad());
        holder.direccion.setText(huecaList.get(position).getUbicacion());
        //holder.fotoHueca.setImageResource(huecaList.get(position).getImagen());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),DetalleHueca.class);
                intent.putExtra("itemDetail", item);
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return huecaList.size();
    }
}