package com.example.huecas002;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Favritos extends AppCompatActivity {

    ImageView imageView, imagenMain;
    private HuecaAdapter huecaAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Hueca> listaDatos;
    boolean comprobar = false;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favritos);

        listaDatos = (ArrayList<Hueca> ) getIntent().getSerializableExtra("listaDatos");
        comprobar = listaDatos.isEmpty();

        if (comprobar == false){
            recyclerView = (RecyclerView) findViewById(R.id.recyclerhuecas);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            huecaAdapter = new HuecaAdapter(obtenerHuecas());
            recyclerView.setAdapter(huecaAdapter);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white)));
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.txt_layout);
            imageView = (ImageView) findViewById(R.id.ImagenMenu);
        }
        else{
            Toast.makeText(this, "No tiene favoritos", Toast.LENGTH_SHORT).show();
        }


        imageView = (ImageView) findViewById(R.id.ImagenMenu);
        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Favritos.this, MenuActivity.class);
                startActivity(intent);
            }

        });
        imagenMain = (ImageView) findViewById(R.id.ImagenHouse);
        imagenMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Favritos.this, MainActivity.class);
                startActivity(intent);
            }

        });

    }

    public List<Hueca> obtenerHuecas(){
        listaDatos = (ArrayList<Hueca> ) getIntent().getSerializableExtra("listaDatos");
        return listaDatos;
    }

}