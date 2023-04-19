package guia3;

import java.util.Scanner;

public class ejercicio2 {
    
    public static void main(String[] args) {
        String frase;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese una palabra para ver si es igual a eureka:");
        frase = leer.nextLine();

        if ( frase.equals("eureka") ) {
            System.out.println("Correcto");
        }
        else {
            System.out.println("Incorrecto");
        }
    }
}