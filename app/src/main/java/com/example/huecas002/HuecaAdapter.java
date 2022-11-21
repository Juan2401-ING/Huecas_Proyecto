package com.example.huecas002;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HuecaAdapter extends RecyclerView.Adapter<HuecaAdapter.ViewHolder> implements Filterable {


    public interface  OnItemClickListener{
        void onItemClick(Hueca hueca);
    }
    public static class  ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre, prioridad, direccion, dislike;
        ImageView fotoHueca, ubicacion;
        public ViewHolder(View itemView){
            super(itemView);

            nombre= (TextView) itemView.findViewById(R.id.text_huecanombre);
            prioridad= (TextView) itemView.findViewById(R.id.text_priority);
            dislike= (TextView) itemView.findViewById(R.id.text_dislike);
            direccion= (TextView) itemView.findViewById(R.id.txt_direccion);
            fotoHueca= (ImageView) itemView.findViewById(R.id.imagenView);
            ubicacion = (ImageView) itemView.findViewById(R.id.ubicacion);
        }
    }
    public List<Hueca> huecaList;
    public List<Hueca> huecaListfull;

    public HuecaAdapter(List<Hueca> huecaList) {

        this.huecaList = huecaList;
        huecaListfull = new ArrayList<>(huecaList);
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
        holder.dislike.setText(""+huecaList.get(position).getDislike());

        //holder.direccion.setText(huecaList.get(position).getUbicacion());
        //holder.fotoHueca.setImageResource(huecaList.get(position).getImagen());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),DetalleHueca.class);
                intent.putExtra("itemDetail", item);
                holder.itemView.getContext().startActivity(intent);

            }
        });
        holder.fotoHueca.setImageResource(huecaList.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return huecaList.size();
    }

    @Override
    public Filter getFilter() {
        return filtro;
    }
     private Filter filtro = new Filter() {
         @Override
         protected FilterResults performFiltering(CharSequence constraint) {
             List<Hueca> listaFiltrada = new ArrayList<>();

             if(constraint == null || constraint.length() == 0){
                 listaFiltrada.addAll(huecaListfull);

             }else {
                 String filterPattern = constraint.toString().toLowerCase().trim();

                 for (Hueca item:huecaListfull ){
                     if(item.getNombre().toLowerCase().contains(filterPattern)){
                         listaFiltrada.add(item);

                     }
                 }


             }
             FilterResults resultadofiltro = new FilterResults();
             resultadofiltro.values= listaFiltrada;
             return  resultadofiltro;


         }

         @Override
         protected void publishResults(CharSequence constraint, FilterResults results) {
            huecaList.clear();
            huecaList.addAll((List) results.values);
            notifyDataSetChanged();
         }
     };
}