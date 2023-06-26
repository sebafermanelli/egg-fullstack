package guia11.extras.ejercicio2.model;

import java.util.HashMap;

public class Cine {
    String nombre;
    HashMap<String, Boolean> sala = new HashMap<String, Boolean>();
    Double valorEntrada;
    Pelicula pelicula;

    public Cine() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashMap<String, Boolean> getSala() {
        return sala;
    }

    public void setSala(HashMap<String, Boolean> sala) {
        this.sala = sala;
    }

    public Double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(Double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "Cine{" +
                "nombre='" + nombre + '\'' +
                ", sala=" + sala +
                ", valorEntrada=" + valorEntrada +
                ", pelicula=" + pelicula +
                '}';
    }
}
