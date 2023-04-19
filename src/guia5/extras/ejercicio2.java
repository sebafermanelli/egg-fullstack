package guia5.extras;

import java.util.Scanner;

public class ejercicio2 {
    
    public static void main(String[] args) {
        int n;
        boolean iguales = true;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el tamaño del arreglo:");
        n = leer.nextInt();

        int[] vectorA = new int[n];
        int[] vectorB = new int[n];

        for (int i = 0; i < vectorA.length; i++) {
            System.out.println("Ingrese el numero del vector A:");
            vectorA[i] = leer.nextInt();
            System.out.println("Ingrese el numero del vector B:");
            vectorB[i] = leer.nextInt();

            System.out.println();
        }

        for (int i = 0; i < vectorA.length; i++) {
            if (vectorA[i] != vectorB[i]) {
                System.out.println("Los vectores A y B son diferentes");
                iguales = false;
                break;
            }
        }

        if (iguales) {
            System.out.println("Los vectores A y B son iguales");
        }
    }
}
