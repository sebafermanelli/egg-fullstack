package guia3.extras;

import java.util.Scanner;

public class ejercicio11 {
    
    public static void main(String[] args) {
        int num, cant;

        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese un numero:");
        num = leer.nextInt();

        cant = 0;

        do {
            num /= 10;
            cant++;
        } while (num != 0);

        System.out.println("El numero posee " + cant + " caracteres");
    }
}