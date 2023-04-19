package guia2;

import java.util.Scanner;

public class ejercicio1 {
    
    public static void main(String[] args) {
        int num1, num2, suma;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese un primer numero entero:");
        num1 = leer.nextInt();

        System.out.println("Ingrese un segundo numero entero:");
        num2 = leer.nextInt();

        suma = num1 + num2;

        System.out.println("La suma es: " + suma);
    }
}