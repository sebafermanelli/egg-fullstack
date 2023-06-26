package guia10.ejercicio5;

import guia10.ejercicio5.services.PaisService;

import java.util.Scanner;

public class Core {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaisService ps = new PaisService();
        char rta;

        do {
            ps.cargarPais();

            do {
                System.out.print("Desea seguir cargando paises? S/N: ");
                rta = scanner.next().toUpperCase().charAt(0);
            } while (rta != 'S' && rta != 'N');
        } while (rta == 'S');

        scanner.nextLine();
        ps.mostrarPaises();

        System.out.print("Ingrese un pais para eliminarlo: ");
        String paisEliminar = scanner.nextLine();
        ps.eliminarPais(paisEliminar);
        ps.mostrarPaises();
    }
}
