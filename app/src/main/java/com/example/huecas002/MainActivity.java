package com.example.huecas002;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("Hueca");
    private HuecaAdapter adapter;


    DrawerLayout mDrawerLayout;
    NavigationView navigationView;
    ImageView imageView;
    List<Hueca> huecas;
    private RecyclerView recyclerView;
    private HuecaAdapter huecaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        huecaAdapter = new HuecaAdapter(obtenerHuecas());
        recyclerView.setAdapter(huecaAdapter);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white)));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.txt_layout);
        imageView = (ImageView) findViewById(R.id.imagenMenu);
        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
            }

        });
        //Navigation Drawer
    }
    public List<Hueca> obtenerHuecas(){
        List<Hueca> huecas = new ArrayList<>();
        huecas = new ArrayList<>();
        huecas.add(new Hueca("Abysmo",5,"Quito",R.drawable.abysmo));
        huecas.add(new Hueca("Poliburger",2,"Quito",R.drawable.poliburger));
        huecas.add(new Hueca("La Sanducheria",5,"Quito",R.drawable.sanducheria));
        huecas.add(new Hueca("Rincon Orense",3,"Quito",R.drawable.rinconorense));
        huecas.add(new Hueca("Ecuaviche",5,"Quito",R.drawable.ecuaviche));
        huecas.add(new Hueca("Chao Pecaeo Veintimilla",5,"Quito",R.drawable.chaopescaoveintimilla));
        huecas.add(new Hueca("Marcando el Camino",5,"Quito",R.drawable.marcandoelcamino));
        huecas.add(new Hueca("Mi playita cevichera",5,"Quito",R.drawable.miplayita));
        huecas.add(new Hueca("Juarez la Mexicana",5,"Quito",R.drawable.juarezlamexicana));
        huecas.add(new Hueca("Banderas de la FOch",5,"Quito",R.drawable.banderas));
        huecas.add(new Hueca("PapasLaMana",5,"Quito",R.drawable.papaslamana));
        return huecas;
    }


}