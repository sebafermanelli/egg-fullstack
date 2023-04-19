package guia5;

import java.util.Scanner;

public class ejercicio2 {
    
    public static void main(String[] args) {
        int n, numBuscar;
        boolean encontro = false;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el tamaño del vector:");
        n = leer.nextInt();
        int[] aleatorios = new int[n];

        for (int i = 0; i < aleatorios.length; i++) {
            aleatorios[i] = (int)(Math.random() * 10);
        }

        System.out.println("Ingrese un numero a buscar entre el 0-10:");
        numBuscar = leer.nextInt();

        for (int i = 0; i < aleatorios.length; i++) {
            if (numBuscar == aleatorios[i]) {
                System.out.println("El numero: " + numBuscar + " se encuentra en la posicion: " + (i+1));
                encontro = true;
            }
        }

        if (encontro == false) {
            System.out.println("No se encontro ninguna coincidencia");
        }
    }
}