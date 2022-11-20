package com.example.huecas002;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class DetalleHueca extends AppCompatActivity {
    private TextView nombreHuecaDetail;
    private TextView prioridadHuecaDetail;
    private TextView direcciomHuecaDetail;
    private TextView dislikeHuecaDetail;
    private ImageView imagenHueca;
    private Hueca itemDetail;
    ImageView imageView, imagenMain;
    ImageButton btnlike;
    ArrayList<Hueca> listahueca = new ArrayList<Hueca>();
    int index = 0;
    TextView prueba;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_hueca);

        FirebaseAuth fb = FirebaseAuth.getInstance();

        initViews();
        initValues();

        imageView = (ImageView) findViewById(R.id.ImagenMenu);
        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalleHueca.this, MenuActivity.class);
                startActivity(intent);
            }

        });
        imagenMain = (ImageView) findViewById(R.id.ImagenHouse);
        imagenMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalleHueca.this, MainActivity.class);
                startActivity(intent);
            }

        });

        btnlike = findViewById(R.id.ButtonLike);

        btnlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseUser user = fb.getCurrentUser();
                if(user!=null){
                    addfavorite();
                    Intent intent = new Intent(DetalleHueca.this, Favritos.class);
                    intent.putExtra("listaDatos", listahueca);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(DetalleHueca.this, RegistroActivity.class);
                    startActivity(intent);
                    Toast.makeText(DetalleHueca.this, "Necesita estar registrado", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void addfavorite(){
        itemDetail = (Hueca) getIntent().getExtras().getSerializable("itemDetail");
        listahueca.add(new Hueca(itemDetail.getNombre(),itemDetail.getPrioridad(),itemDetail.getDislike(),itemDetail.getUbicacion(),itemDetail.getImagen()));
    }

    private void initViews(){
        nombreHuecaDetail = findViewById(R.id.detailNombre);
        prioridadHuecaDetail = findViewById(R.id.detailPrioridad);
        dislikeHuecaDetail = findViewById(R.id.disliketext);
        direcciomHuecaDetail = findViewById(R.id.detailDireccion);
        imagenHueca = findViewById(R.id.detailHuecaImagen);
    }
    private void initValues(){
        itemDetail = (Hueca) getIntent().getExtras().getSerializable("itemDetail");
        nombreHuecaDetail.setText(itemDetail.getNombre());
        prioridadHuecaDetail.setText(""+itemDetail.getPrioridad());
        dislikeHuecaDetail.setText(""+itemDetail.getDislike());
        //direcciomHuecaDetail.setText(itemDetail.getUbicacion());
        direcciomHuecaDetail.setText((Html.fromHtml(
                "" +
                        "<a href=\"https://www.google.com/maps/place/Pontificia+Universidad+Católica+del+Ecuador/@37.3318412,-122.0323645\">" +
                        "Ubicación"+
                        "</a>")));
        direcciomHuecaDetail.setMovementMethod(LinkMovementMethod.getInstance());
        imagenHueca.setImageResource(itemDetail.getImagen());
    }
}