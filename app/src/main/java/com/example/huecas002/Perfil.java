package com.example.huecas002;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Perfil extends AppCompatActivity {

    ImageView imageView, imagenMain;

    TextView name, lastname, email;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    DatabaseReference Base_de_datos;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        name = findViewById(R.id.nombre);
        lastname = findViewById(R.id.apellido);
        email = findViewById(R.id.mail);

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();

        Base_de_datos = FirebaseDatabase.getInstance().getReference("Usuarios");
        Base_de_datos.child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String nombre = ""+snapshot.child("nombre").getValue();
                    name.setText(nombre);
                    String apellido = ""+snapshot.child("apellido").getValue();
                    lastname.setText(apellido);
                    String mail = ""+snapshot.child("mail").getValue();
                    email.setText(mail);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        imageView = (ImageView) findViewById(R.id.ImagenMenu);
        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Perfil.this, MenuActivity.class);
                startActivity(intent);
            }

        });
        imagenMain = (ImageView) findViewById(R.id.ImagenHouse);
        imagenMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Perfil.this, MainActivity.class);
                startActivity(intent);
            }

        });

    }
}