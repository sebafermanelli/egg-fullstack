package guia3.extras;

import java.util.Scanner;

public class ejercicio3 {
    
    public static void main(String[] args) {
        String letra;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese un caracter:");
        do {
            letra = leer.nextLine().toUpperCase();

            if (letra.length() != 1) {
                System.out.println("No es un caracter");
            }
        } while (letra.length() != 1);

        if (letra.equals("A") || letra.equals("E") || letra.equals("I") || letra.equals("O") || letra.equals("U")) {
            System.out.println("Es vocal");
        }
        else {
            System.out.println("No es vocal");
        }
    }
}