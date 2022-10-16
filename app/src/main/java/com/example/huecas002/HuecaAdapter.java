package com.example.huecas002;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class HuecaAdapter extends FirestoreRecyclerAdapter <Hueca, HuecaAdapter.HuecaHolder> {

    public HuecaAdapter(@NonNull FirestoreRecyclerOptions<Hueca> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull HuecaHolder holder, int position, @NonNull Hueca model) {
     holder.textViewnombre.setText(model.getNombre());
     holder.textViewprioridad.setText(String.valueOf(model.getPrioridad()));
    }

    @NonNull
    @Override
    public HuecaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.huecaitem1,parent,false);
        return new HuecaHolder(v);
    }

    class HuecaHolder extends RecyclerView.ViewHolder {
        TextView textViewnombre;
        TextView textViewprioridad;

        public HuecaHolder(View itemView){
            super(itemView);
            textViewnombre = itemView.findViewById(R.id.text_huecanombre);
            textViewprioridad = itemView.findViewById(R.id.text_priority);
        }
    }
}
