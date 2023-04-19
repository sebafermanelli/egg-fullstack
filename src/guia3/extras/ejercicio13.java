package guia3.extras;

import java.util.Scanner;

public class ejercicio13 {
    
    public static void main(String[] args) {
        int altura;

        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese la altura de la escalera:");
        altura = leer.nextInt();

        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}