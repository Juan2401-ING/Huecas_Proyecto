package com.example.huecas002;

import java.io.Serializable;

public class Hueca implements Serializable {
    //Atributos
    private String nombre;
    private int prioridad;
    //private int imagen;
    private String ubicacion;


    public Hueca(){}

    public Hueca(String nombre, int prioridad, String ubicacion) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.ubicacion = ubicacion;

    }

    public String getNombre() {
        return nombre;
    }
    public int getPrioridad() {
        return prioridad;
    }
    public String getUbicacion() {return ubicacion; }
}