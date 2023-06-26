package guia10.ejercicio3.model;

import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private ArrayList<Integer> notas = new ArrayList<Integer>();

    public Alumno() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Integer> notas) {
        this.notas = notas;
    }
}
