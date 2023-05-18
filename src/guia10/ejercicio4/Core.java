package guia10.ejercicio4;

import guia10.ejercicio4.services.PeliculaService;

public class Core {
    public static void main(String[] args) {
        PeliculaService ps = new PeliculaService();

        ps.crearPelicula();

        System.out.println();
        System.out.println("Todas las peliculas: ");
        ps.mostrarPeliculas();

        System.out.println();
        System.out.println("Peliculas queduran mas de 1 hs: ");
        ps.mostrarPeliculasMayorA1hs();

        System.out.println();
        System.out.println("Peliculas ordenadas por duracion (mayor a menor): ");
        ps.ordenarPeliculasDuracionAMenor();
        ps.mostrarPeliculas();

        System.out.println();
        System.out.println("Peliculas ordenadas por duracion (menor a mayor):");
        ps.ordenarPeliculasDuracionAMayor();
        ps.mostrarPeliculas();

        System.out.println();
        System.out.println("Peliculas ordenadas por titulo: ");
        ps.ordenarPeliculasTitulo();
        ps.mostrarPeliculas();

        System.out.println();
        System.out.println("Peliculas ordenadas por director: ");
        ps.ordenarPeliculasDirector();
        ps.mostrarPeliculas();
    }
}
