package guia11.extras.ejercicio2.service;

import guia11.extras.ejercicio2.Core;
import guia11.extras.ejercicio2.model.Pelicula;

public class PeliculaService {

    public static Pelicula crearPelicula() {
        Pelicula pelicula = new Pelicula();

        System.out.print("Ingrese el titulo de la pelicula: ");
        pelicula.setTitulo(Core.scanner.next());

        System.out.print("Ingrese la duracion de la pelicula: ");
        pelicula.setDuracion(Core.scanner.nextDouble());

        System.out.print("Ingrese la edad minima para ver la pelicula: ");
        pelicula.setEdadMinima(Core.scanner.nextInt());

        System.out.print("Ingrese el nombre del director de la pelicula: ");
        pelicula.setDirector(Core.scanner.next());

        return pelicula;
    }
}