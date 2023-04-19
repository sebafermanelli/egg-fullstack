package guia3.extras;

import java.util.Scanner;

public class ejercicio5 {
    
    public static void main(String[] args) {
        char clase;
        int costo;
        double costoFinal;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese una clase de socio (A, B o C):");
        do {
            clase = leer.next().toUpperCase().charAt(0);
        } while (clase != 'A' && clase != 'B' && clase != 'C');

        System.out.println("Ingrese el costo del tratamiento:");
        costo = leer.nextInt();

        costoFinal = 0;

        if (clase == 'A') {
            costoFinal = costo * 0.50;
        }
        else if (clase == 'B') {
            costoFinal = costo * 0.65;
        }
        else if (clase == 'C') {
            costoFinal = costo;
        }

        System.out.println("El tratamiento cuesta $" +  costo + " pero como el socio es de clase " + clase + ", el valor final es: $" + costoFinal);
    }
}