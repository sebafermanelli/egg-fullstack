package guia2;

import java.util.Scanner;

public class ejercicio3 {
    
    public static void main(String[] args) {
        String frase;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese una frase:");
        frase = leer.nextLine();

        System.out.println("Frase en mayusculas:");
        System.out.println(frase.toUpperCase());
        System.out.println("Frase en minusculas:");
        System.out.println(frase.toLowerCase());
    }
}