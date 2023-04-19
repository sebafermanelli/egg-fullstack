package guia5.extras;

import java.util.Scanner;

public class ejercicio7 {
    
    public static void main(String[] args) {
        int n;

        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese el valor de N para la serie:");
        n = leer.nextInt();

        int[] vector = new int[n];

        Fibonacci(vector);
        MostrarVector(vector);
    }

    public static void Fibonacci(int[] sucesion) {
        for (int i = 0; i < sucesion.length; i++) {
            if (i <= 1) {
                sucesion[i] = 1;
            }
            else {
                sucesion[i] = sucesion[i-1] + sucesion[i-2];
            }
        }
    }

    public static void MostrarVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i == (vector.length-1)) {
                System.out.print(vector[i]);
            }
            else {
                System.out.print(vector[i] + ", ");
            }
        }
    }
}
