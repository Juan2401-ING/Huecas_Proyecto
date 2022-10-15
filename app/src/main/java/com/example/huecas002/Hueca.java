package com.example.huecas002;

public class Hueca {
    private String nombre;
    private int prioridad;

    public Hueca(){}

    public Hueca(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }
    public int getPrioridad() {
        return prioridad;
    }


}
