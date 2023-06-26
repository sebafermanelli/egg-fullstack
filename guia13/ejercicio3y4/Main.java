package guia13.ejercicio3y4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a, b;
        int c = 0, d = 0;
        
        System.out.print("Ingrese el primer numero: ");
        a = scanner.nextLine();
        System.out.print("Ingrese el segundo numero: ");
        b = scanner.nextLine();

        try {
            c = Integer.parseInt(a);
            d = Integer.parseInt(b);
            try {
                int division = c/d;

                System.out.print("La division es: ");
                System.out.println(division);
            } catch (Exception e) {
                System.out.println("Error numerico: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error de string: " + e.getMessage());
        }
    }
}
