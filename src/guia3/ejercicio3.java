package guia3;

import java.util.Scanner;

public class ejercicio3 {

    public static void main(String[] args) {
        String frase;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese una palabra para ver si su longitud es 8:");
        frase = leer.nextLine();

        if ( frase.length() == 8 ) {
            System.out.println("Correcto, longitud: " + frase.length());
        }
        else {
            System.out.println("Incorrecto, longitud: " + frase.length());
        }
    }
}