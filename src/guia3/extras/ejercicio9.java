package guia3.extras;

import java.util.Scanner;

public class ejercicio9 {
    
    public static void main(String[] args) {
        int num1, num2, cociente, residuo;

        Scanner leer = new Scanner(System.in);

        cociente = 0;

        System.out.println("Ingrese el primer numero para la division:");
        num1 = leer.nextInt();
        System.out.println("Ingrese el segundo numero para la division:");
        num2 = leer.nextInt();

        residuo = num1;

        do {
            cociente++;
            residuo -= num2;
        } while ( residuo >= num2 );

        System.out.println("El residuo es " + residuo + " y el cociente es " + cociente);
    }
}