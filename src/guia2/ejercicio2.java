package guia2;

import java.util.Scanner;

public class ejercicio2 {
    
    public static void main(String[] args) {
        String nombre;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese su nombre:");
        nombre = leer.nextLine();

        System.out.println("Hola, " + nombre);
    }
}
