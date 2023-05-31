package guia10.ejercicio1;

import guia10.ejercicio1.services.MascotaService;

import java.util.Scanner;

public class Core {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean repeat = true;

        do {
            MascotaService.crearMascota();

            System.out.print("Desea agregar otra mascota? S/N: ");
            char rta = scanner.next().toUpperCase().charAt(0);
            while (rta != 'S' && rta != 'N') {
                System.out.print("Ingrese S/N: ");
                rta = scanner.next().toUpperCase().charAt(0);
            }

            if (rta == 'N') {
                repeat = false;
            }
        } while (repeat);

        MascotaService.MostrarListaMascotas();
    }
}
