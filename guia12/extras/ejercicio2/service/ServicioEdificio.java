package guia12.extras.ejercicio2.service;

import java.util.Scanner;

public class ServicioEdificio {
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public Double anchoEdificio() {
        System.out.print("Ingrese el ancho del edificio: ");
        return scanner.nextDouble();
    }

    public Double altoEdificio() {
        System.out.print("Ingrese el alto del edificio: ");
        return scanner.nextDouble();
    }

    public Double largoEdificio() {
        System.out.print("Ingrese el largo del edificio: ");
        return scanner.nextDouble();
    }
}
