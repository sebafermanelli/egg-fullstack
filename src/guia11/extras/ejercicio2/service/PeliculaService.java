package guia11.extras.ejercicio2.service;

import guia11.extras.ejercicio2.Core;
import guia11.extras.ejercicio2.model.Cine;
import guia11.extras.ejercicio2.model.Espectador;
import guia11.extras.ejercicio2.model.Pelicula;

public class PeliculaService {

    public static Pelicula crearPelicula(Cine cine) {
        Pelicula pelicula = new Pelicula();
        int op = 0;
        do {
            System.out.println("CARTELERA DE " + cine.getNombre());
            System.out.println("1 - RAPIDOS Y FURIOSOS X");
            System.out.println("2 - MARIO BROS");
            System.out.println("3 - LOS GUARDIANES DE LA GALAXIA III");
            System.out.print("Ingrese opcion: ");
            op = Core.scanner.nextInt();

            switch (op) {
                case 1 -> {
                    pelicula.setTitulo("RAPIDOS Y FURIOSOS X");
                    pelicula.setDirector("LUIS FLORES");
                    pelicula.setDuracion(120);
                    pelicula.setEdadMinima(18);
                }
                case 2 -> {
                    pelicula.setTitulo("MARIO BROS");
                    pelicula.setDirector("LUIS FLORES");
                    pelicula.setDuracion(140);
                    pelicula.setEdadMinima(7);
                }
                case 3 -> {
                    pelicula.setTitulo("LOS GUARDIANES DE LA GALAXIA III");
                    pelicula.setDirector("LUIS FLORES");
                    pelicula.setDuracion(90);
                    pelicula.setEdadMinima(16);
                }
                default -> System.out.println("Esa pelicula no esta disponible");
            }
        } while(op < 1 || op > 3);

        /*
        System.out.print("Ingrese el titulo de la pelicula: ");
        pelicula.setTitulo(Core.scanner.next());

        System.out.print("Ingrese la duracion de la pelicula: ");
        pelicula.setDuracion(Core.scanner.nextInt());

        System.out.print("Ingrese la edad minima para ver la pelicula: ");
        pelicula.setEdadMinima(Core.scanner.nextInt());

        System.out.print("Ingrese el nombre del director de la pelicula: ");
        pelicula.setDirector(Core.scanner.next());
        */

        return pelicula;
    }
}