package com.example.huecas002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MenuActivity extends AppCompatActivity {

    TextView textViewPersona, textViewFavorito, textViewAcercade;
    Button cerrarsesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textViewPersona = (TextView) findViewById(R.id.textMiperfil);
        textViewFavorito = (TextView) findViewById(R.id.textFavorito);
        textViewAcercade = (TextView) findViewById(R.id.textAcercade);
        cerrarsesion = findViewById(R.id.btnCerrarSesion);
        FirebaseAuth fb = FirebaseAuth.getInstance();


        textViewPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(MenuActivity.this, RegistroActivity.class);
                startActivity(intent);

                Toast.makeText(MenuActivity.this, "Necesita estar registrado", Toast.LENGTH_LONG).show();*/
                FirebaseUser user = fb.getCurrentUser();
                if(user!=null){
                    Intent intent = new Intent(MenuActivity.this, Perfil.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MenuActivity.this, RegistroActivity.class);
                    startActivity(intent);

                    Toast.makeText(MenuActivity.this, "Necesita estar registrado", Toast.LENGTH_LONG).show();
                }
            }
        });
        textViewFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(MenuActivity.this, RegistroActivity.class);
                startActivity(intent);

                Toast.makeText(MenuActivity.this, "Necesita estar registrado", Toast.LENGTH_LONG).show();*/
                FirebaseUser user = fb.getCurrentUser();
                if(user!=null){
                    Intent intent = new Intent(MenuActivity.this, Favritos.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MenuActivity.this, RegistroActivity.class);
                    startActivity(intent);

                    Toast.makeText(MenuActivity.this, "Necesita estar registrado", Toast.LENGTH_LONG).show();
                }
            }
        });
        textViewAcercade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, Acerca.class);
                startActivity(intent);
            }
        });
        cerrarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MenuActivity.this, "Sesión Cerrada", Toast.LENGTH_SHORT).show();
                irLogin();
            }
        });

    }

    private void irLogin() {
        Intent i = new Intent(this,LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}