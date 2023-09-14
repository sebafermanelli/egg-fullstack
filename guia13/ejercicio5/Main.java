package guia13.ejercicio5;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random rand = new Random();
            int num = rand.nextInt(1,10);
            int ingresado = 0;
            int i = 1;

            do {
                try {
                    System.out.print(num + "Ingrese un numero: ");
                    ingresado = scanner.nextInt();
                    if (ingresado != num) {
                        System.out.println("El numero ingresado es incorrecto! " + i + " intentos");
                        i++;
                    }
                } catch (Exception e) {
                    System.out.println("Ingresaste algo incorrecto! " + i + " intentos");
                    i++;
                }
                scanner.nextLine();
            } while (num != ingresado);
        }
        System.out.println("Adivinaste!");
    }
}
