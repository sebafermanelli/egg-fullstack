package guia3;

import java.util.Scanner;

public class ejercicio8 {
    
    public static void main(String[] args) {
        int lado;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la longitud de cada lado del cuadrado:");
        lado = leer.nextInt();

        for (int i = 0; i < lado; i++) {
            for (int j = 0; j < lado; j++) {
                if ((j != 0 && j != lado-1) && (i != 0 && i != lado-1)) {
                    System.out.print("  ");
                }
                else {
                    System.out.print("* ");
                }
            }
            System.out.println("");
        }
    }
}