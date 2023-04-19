package guia2;

import java.util.Scanner;

public class ejercicio4 {
    
    public static void main(String[] args) {
        int c, f;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese una temperatura en °C:");
        c = leer.nextInt();

        f = 32 + (9 * c / 5);

        System.out.println(c + " °C equivalen a " + f + "°F");
    }
}
