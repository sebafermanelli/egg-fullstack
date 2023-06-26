package guia10.ejercicio4.comparators;

import guia10.ejercicio4.model.Pelicula;

public class Comparators {

    public static java.util.Comparator<Pelicula> compararTitulo = new java.util.Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula o1, Pelicula o2) {
            return o1.getTitulo().compareTo(o2.getTitulo());
        }
    };

    public static java.util.Comparator<Pelicula> compararDirector = new java.util.Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula o1, Pelicula o2) {
            return o1.getDirector().compareTo(o2.getDirector());
        }
    };

    public static java.util.Comparator<Pelicula> compararPeliculasDuracionAMenor = new java.util.Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula o1, Pelicula o2) {
            return o2.getDuracion().compareTo(o1.getDuracion());
        }
    };

    public static java.util.Comparator<Pelicula> compararPeliculasDuracionAMayor = new java.util.Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula o1, Pelicula o2) {
            return o1.getDuracion().compareTo(o2.getDuracion());
        }
    };
}
