package guia8.extras.ejercicio2.servicios;

import guia8.extras.ejercicio2.entidades.NIF;

import java.util.Scanner;

public class NIFService {

    static Scanner scanner = new Scanner(System.in);
    static char[] letra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    public static NIF crearNif () {
        System.out.print("Ingrese el DNI: ");
        long dni = scanner.nextLong();

        int posNIF = (int)(dni % 23);
        char nif = letra[posNIF];
        return new NIF(dni, nif);
    }

    public static void mostrarNif (NIF nif) {
        System.out.println("Su NIF: " + nif.getNIF());
    }
}
