package com.example.huecas002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    TextView textViewPersona, textViewFavorito, textViewAcercade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textViewPersona = (TextView) findViewById(R.id.textMiperfil);
        textViewFavorito = (TextView) findViewById(R.id.textFavorito);
        textViewAcercade = (TextView) findViewById(R.id.textAcercade);


        textViewPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, RegistroActivity.class);
                startActivity(intent);

                Toast.makeText(MenuActivity.this, "Necesita estar registrado", Toast.LENGTH_LONG).show();
            }
        });
        textViewFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, RegistroActivity.class);
                startActivity(intent);

                Toast.makeText(MenuActivity.this, "Necesita estar registrado", Toast.LENGTH_LONG).show();
            }
        });
        textViewAcercade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, Acerca.class);
                startActivity(intent);
            }
        });

    }
}