package guia5;

import java.util.Scanner;

public class ejercicio5 {

    public static void main(String[] args) {
        int[][] matriz = new int[3][3];
        boolean antisimetrica = true;

        Scanner leer = new Scanner(System.in);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.println("Ingrese el numero de la fila: " + i + " columna: " + j + ":");
                matriz[i][j] = leer.nextInt();
            }
            System.out.println();
        }

        System.out.println("Matriz:");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] < 0) {
                    System.out.print(matriz[i][j] + " ");
                }
                else {
                    System.out.print(matriz[i][j] + "  ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Matriz traspuesta:");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[j][i] < 0) {
                    System.out.print(matriz[j][i] + " ");
                }
                else {
                    System.out.print(matriz[j][i] + "  ");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] != -(matriz[j][i])) {
                    antisimetrica = false;
                }
            }
        }

        System.out.println();
        if (antisimetrica) {
            System.out.println("La matriz es antisimetrica");
        }
        else {
            System.out.println("La matriz no es antisimetrica");
        }
    }
}