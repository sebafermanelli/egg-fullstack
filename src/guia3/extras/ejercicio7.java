package guia3.extras;

import java.util.Scanner;

public class ejercicio7 {
    
    public static void main(String[] args) {
        int n, cont, num, max, min, total;
        float promedio;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de numeros:");
        n = leer.nextInt();

        cont = 1;
        min = 0;
        max = 0;
        promedio = 0;
        total = 0;

        while (cont <= n) {
            System.out.println("Ingrese el numero " + cont + ":");
            num = leer.nextInt();

            if ( num >= 0) {
                if ( num < min || cont == 1 ) {
                    min = num;
                }

                if ( max < num ) {
                    max = num;
                }

                total = total + num;

                cont = cont + 1;
            }

        }

        promedio = total / n;

        System.out.println("El minimo es: " + min);
        System.out.println("El maximo es: " + max);
        System.out.println("El promedio es: " + promedio);

        cont = 1;
        min = 0;
        max = 0;
        promedio = 0;
        total = 0;

        do {
            System.out.println("Ingrese el numero " + cont + ":");
            num = leer.nextInt();

            if ( num >= 0) {
                if ( num < min || cont == 1 ) {
                    min = num;
                }

                if ( max < num ) {
                    max = num;
                }

                total = total + num;

                cont = cont + 1;
            }
        } while (cont <= n);

        promedio = total / n;

        System.out.println("El minimo es: " + min);
        System.out.println("El maximo es: " + max);
        System.out.println("El promedio es: " + promedio);
    }
}