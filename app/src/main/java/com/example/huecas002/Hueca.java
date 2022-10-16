package com.example.huecas002;

public class Hueca {
    //Atributos
    private String nombre;
    private int prioridad;
    private String imagen;

    public Hueca(){}

    public Hueca(String nombre, int prioridad, String imagen) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }
    public int getPrioridad() {
        return prioridad;
    }
    public String getImagen() {return imagen; }
}
