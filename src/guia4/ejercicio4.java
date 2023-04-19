package guia4;

import java.util.Scanner;

public class ejercicio4 {
    
    public static void main(String[] args) {
        int numero;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese un numero para saber si es primo o no:");
        numero = leer.nextInt();

        if (EsPrimo(numero)) {
            System.out.println("El numero " + numero + " es primo");
        }
        else {
            System.out.println("El numero " + numero + " no es primo");
        }
    }

    public static boolean EsPrimo(int  num) {
        int cont;

        cont = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                cont++;
            }
        }

        if (cont == 2) {
            return true;
        }
        else {
            return false;
        }
    }
}