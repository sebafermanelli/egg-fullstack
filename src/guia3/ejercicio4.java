package guia3;

import java.util.Scanner;

public class ejercicio4 {
    
    public static void main(String[] args) {
        String frase, primerLetra;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese una palabra para ver si empieza con A:");
        frase = leer.nextLine();

        primerLetra = frase.substring(0, 1);
        primerLetra = primerLetra.toUpperCase();

        if ( primerLetra.equals("A") ) {
            System.out.println("Correcto");
        }
        else {
            System.out.println("Incorrecto");
        }
    }
}