package com.example.huecas002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleHueca extends AppCompatActivity {
    private TextView nombreHuecaDetail;
    private TextView prioridadHuecaDetail;
    private TextView direcciomHuecaDetail;
    private TextView dislikeHuecaDetail;
    private ImageView imagenHueca;
    private Hueca itemDetail;
    ImageView imageView, imagenMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_hueca);

        initViews();
        initValues();

        imageView = (ImageView) findViewById(R.id.imagenMenu);
        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalleHueca.this, MenuActivity.class);
                startActivity(intent);
            }

        });
        imagenMain = (ImageView) findViewById(R.id.imagenMain);
        imagenMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalleHueca.this, MainActivity.class);
                startActivity(intent);
            }

        });

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