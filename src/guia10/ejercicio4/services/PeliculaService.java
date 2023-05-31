package guia10.ejercicio4.services;

import guia10.ejercicio4.comparators.Comparators;
import guia10.ejercicio4.model.Pelicula;

import java.util.ArrayList;
import java.util.Scanner;

public class PeliculaService {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Pelicula> peliculasList = new ArrayList<Pelicula>();

    public void crearPelicula() {
        char rta;
        do {
            Pelicula peli = new Pelicula();

            System.out.print("Ingrese el titulo de la pelicula: ");
            peli.setTitulo(scanner.nextLine());

            System.out.print("Ingrese el director de la pelicula: ");
            peli.setDirector(scanner.nextLine());

            System.out.print("Ingrese la duracion de la pelicula (en hs): ");
            peli.setDuracion(scanner.nextInt());

            peliculasList.add(peli);

            do {
                System.out.print("Desea cargar otra pelicula? S/N: ");
                rta = scanner.next().toUpperCase().charAt(0);
            } while ((rta != 'S') && (rta != 'N'));

            scanner.nextLine();
        } while (rta == 'S');
    }

    public void mostrarPeliculas() {
        for (Pelicula p : peliculasList) {
            System.out.println(p.toString());
        }
    }

    public void mostrarPeliculasMayorA1hs() {
        for (Pelicula p : peliculasList) {
            if (p.getDuracion() > 1) {
                System.out.println(p.toString());
            }
        }
    }

    public void ordenarPeliculasDuracionAMenor() {
        peliculasList.sort(Comparators.compararPeliculasDuracionAMenor);
    }

    public void ordenarPeliculasDuracionAMayor() {
        peliculasList.sort(Comparators.compararPeliculasDuracionAMayor);
    }

    public void ordenarPeliculasTitulo() {
        peliculasList.sort(Comparators.compararTitulo);
    }

    public void ordenarPeliculasDirector() {
        peliculasList.sort(Comparators.compararDirector);
    }
}
