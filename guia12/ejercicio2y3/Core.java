package guia12.ejercicio2y3;

import guia12.ejercicio2y3.model.Electrodomestico;
import guia12.ejercicio2y3.model.Lavadora;
import guia12.ejercicio2y3.model.Televisor;

import java.util.ArrayList;
import java.util.Scanner;

public class Core {
    public static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {
        ArrayList<Electrodomestico> electrodomesticos = new ArrayList<Electrodomestico>();
        char agregar;
        do {
            System.out.println("1- Lavadora");
            System.out.println("2- Televisor");
            System.out.print("Ingrese opcion: ");
            int op = scanner.nextInt();
            while (op != 1 && op != 2) {
                op = scanner.nextInt();
            }

            if (op == 1) {
                Lavadora lavadora = new Lavadora();
                lavadora.crearLavadora();
                lavadora.precioFinal();
                electrodomesticos.add(lavadora);
            } else {
                Televisor televisor = new Televisor();
                televisor.crearTelevisor();
                televisor.precioFinal();
                electrodomesticos.add(televisor);
            }

            System.out.print("Desea agregar otro electrodomestico? S/N: ");
            agregar = scanner.next().toLowerCase().charAt(0);
            while (agregar != 's' && agregar != 'n') {
                agregar = scanner.next().toLowerCase().charAt(0);
            }
        } while (agregar == 's');

        System.out.println("Mis electrodomesticos: ");
        for (Electrodomestico e : electrodomesticos) {
            System.out.println(e.toString());
        }

        System.out.println();

        double sumaTotal = 0;
        double sumaLavadora = 0;
        double sumaTelevisor = 0;
        for (Electrodomestico e : electrodomesticos) {
            sumaTotal += e.getPrecio();
            if (e instanceof Lavadora lavadora) {
                sumaLavadora += lavadora.getPrecio();
            } else if (e instanceof Televisor televisor) {
                sumaTelevisor += televisor.getPrecio();
            }
        }
        System.out.println("La suma total de electrodomesticos es: $" + sumaTotal);
        System.out.println("La suma total de lavadoras es: $" + sumaLavadora);
        System.out.println("La suma total de televisores es: $" + sumaTelevisor);
    }
}
