package guia4;

import java.util.Scanner;

public class ejercicio3 {
    
    public static void main(String[] args) {
        int euros;
        char moneda;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de euros a convertir:");
        euros = leer.nextInt();

        leer.nextLine(); // Consumir el final de linea del int para que el nextLine() siguiente no de error

        System.out.println("Ingrese la moneda: (D - Dolares / Y - Yenes / L - Libras)");
        moneda = leer.nextLine().toUpperCase().charAt(0);

        ConvertirA(moneda, euros);
    }

    public static void ConvertirA(char m, int cant) {
        if (m == 'D') {
            System.out.println((cant * 1.28611) + " DOLARES son " + cant + " EUROS");
        }
        else if (m == 'Y') {
            System.out.println((cant * 129.852) + " YENES son " + cant + " EUROS");
        }
        else if (m == 'L') {
            System.out.println((cant * 0.86) + " LIBRAS son " + cant + " EUROS");
        }
    }
}