package guia2;

import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        int num, doble, triple;
        double raiz;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese un numero:");
        num = leer.nextInt();

        doble = num * 2;
        triple = num * 3;
        raiz = Math.sqrt(num);

        System.out.println("El doble de " + num + " es: " + doble);
        System.out.println("El triple de " + num + " es: " + triple);
        System.out.println("La raiz de " + num + " es: " + raiz);
    }
}
