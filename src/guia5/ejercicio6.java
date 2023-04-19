package guia5;

import java.util.Scanner;

public class ejercicio6 {
    
    public static void main(String[] args) {
        int[][] matriz = new int[3][3];
        int[] fila = new int[3];
        int[] columna = new int[3];
        int diagonal, auxFila, auxColumna;
        boolean magic = true;

        Scanner leer = new Scanner(System.in);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.println("Ingrese el numero de la fila: " + i + " columna: " + j + ":");
                do {
                    matriz[i][j] = leer.nextInt();
                } while(matriz[i][j] < 1 || matriz[i][j] > 9);
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

        diagonal = 0;

        for (int i = 0; i < matriz.length; i++) {
            auxFila = 0;
            auxColumna = 0;

            for (int j = 0; j < matriz.length; j++) {
                if (i == j) {
                    diagonal += matriz[i][j];
                }
                auxFila += matriz[i][j];
                auxColumna += matriz[j][i];
            }
            columna[i] = auxColumna;
            fila[i] = auxFila;
        }

        for (int i = 0; i < fila.length; i++) {
            if (fila[i] != diagonal || columna[i] != diagonal) {
                magic = false;
            }
        }

        System.out.println();
        if (magic) {
            System.out.println("La matriz es magica");
        }
        else {
            System.out.println("La matriz no es magica");
        }
    }
}