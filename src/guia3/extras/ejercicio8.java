package guia3.extras;

import java.util.Scanner;

public class ejercicio8 {
    
    public static void main(String[] args) {
        int num, cantPar, cantImpar, cantTotal;
        float multiplo;

        Scanner leer = new Scanner(System.in);

        cantPar = 0;
        cantImpar = 0;
        cantTotal = 0;

        do {
            System.out.println("Escribe un numero:");
            num = leer.nextInt();

            multiplo = num % 5;
            if ( multiplo != 0 && num >= 0) {
                if ( (num % 2) == 0) {
                    cantPar = cantPar + 1;
                }
                else {
                    cantImpar = cantImpar + 1;
                }

                cantTotal = cantTotal + 1;
            }
        } while ( multiplo != 0);

        System.out.println("La cantidad de numeros es: " + cantTotal);
        System.out.println("La cantidad de numeros pares es: " + cantPar);
        System.out.println("La cantidad de numeros impares es: " + cantImpar);
    }
}