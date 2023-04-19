package guia3;

import java.util.Scanner;

public class ejercicio5 {
    
    public static void main(String[] args) {
        int limite, num, suma;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese un limite para la suma:");
        limite = leer.nextInt();

        suma = 0;

        while (suma <= limite) {
            System.out.println("Ingrese un numero para sumar:");
            num = leer.nextInt();

            suma = suma + num;

            System.out.println("La suma actual es: " + suma);
        }
    }
}