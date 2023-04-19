package guia3.extras;

import java.util.Scanner;

public class ejercicio2 {
    
    public static void main(String[] args) {
        int a, b, c, d, aux;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese A, B, C y D:");
        a = leer.nextInt();
        b = leer.nextInt();
        c = leer.nextInt();
        d = leer.nextInt();

        System.out.println("A valia " + a);
        System.out.println("B valia " + b);
        System.out.println("C valia " + c);
        System.out.println("D valia " + d);

        aux = b;
        b = c;
        c = a;
        a = d;
        d = aux;

        System.out.println("A ahora vale " + a);
        System.out.println("B ahora vale " + b);
        System.out.println("C ahora vale " + c);
        System.out.println("D ahora vale " + d);
    }
}