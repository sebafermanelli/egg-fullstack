package guia5.extras;

import java.util.Scanner;

public class ejercicio1 {

    public static void main(String[] args) {
        int n;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingresa el tamaño del arreglo:");
        n = leer.nextInt();

        int[] elementos = new int[n];

        for (int i = 0; i < elementos.length; i++) {
            System.out.println("Ingrese un numero a sumar:");
            elementos[i] = leer.nextInt();
        }

        System.out.println("El valor de la suma de los elementos: " + Sumar(elementos));
    }

    public static int Sumar(int[] e) {
        int suma = 0;

        for (int i = 0; i < e.length; i++) {
            suma += e[i];
        }

        return suma;
    }
}
