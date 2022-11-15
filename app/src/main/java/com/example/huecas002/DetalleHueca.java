package com.example.huecas002;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetalleHueca extends AppCompatActivity {
    private TextView nombreHuecaDetail;
    private TextView prioridadHuecaDetail;
    private TextView direcciomHuecaDetail;
    private Hueca itemDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_hueca);

        initViews();
        initValues();

    }
    private void initViews(){
        nombreHuecaDetail = findViewById(R.id.detailNombre);
        prioridadHuecaDetail = findViewById(R.id.detailPrioridad);
        direcciomHuecaDetail = findViewById(R.id.detailDireccion);
    }
    private void initValues(){
        itemDetail = (Hueca) getIntent().getExtras().getSerializable("itemDetail");
        nombreHuecaDetail.setText(itemDetail.getNombre());
        prioridadHuecaDetail.setText(""+itemDetail.getPrioridad());
        direcciomHuecaDetail.setText(itemDetail.getUbicacion());
            }
}