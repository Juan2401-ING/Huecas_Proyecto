package com.example.huecas002;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Acerca extends AppCompatActivity {

    ImageView imageView, imagenMain;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);

        imageView = (ImageView) findViewById(R.id.ImagenMenu);
        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Acerca.this, MenuActivity.class);
                startActivity(intent);
            }

        });
        imagenMain = (ImageView) findViewById(R.id.ImagenHouse);
        imagenMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Acerca.this, MainActivity.class);
                startActivity(intent);
            }

        });

    }
}