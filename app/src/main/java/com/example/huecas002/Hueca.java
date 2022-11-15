package com.example.huecas002;

import java.io.Serializable;

public class Hueca implements Serializable {
    //Atributos
    private String nombre;
    private int prioridad;
    private int dislike;
    private int imagen;
    private String ubicacion;


    public Hueca(){}

    public Hueca(String nombre, int prioridad, int dislike, String ubicacion, int imagen) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.dislike = dislike;
        this.ubicacion = ubicacion;
        this.imagen = imagen;

    }

    public String getNombre() {
        return nombre;
    }
    public int getPrioridad() {
        return prioridad;
    }
    public int getDislike() {
        return dislike;
    }
    public String getUbicacion() {return ubicacion; }
    public int getImagen() {return imagen; }
}