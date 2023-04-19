package guia5.extras;

import java.util.Scanner;

public class ejercicio5 {
    
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int[][] matriz = new int[3][3];
        int suma = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = (int)(Math.random() * 10);
                suma += matriz[i][j];
            }
        }

        System.out.println("La suma de los elementos de la matriz es: " + suma);
    }
}
