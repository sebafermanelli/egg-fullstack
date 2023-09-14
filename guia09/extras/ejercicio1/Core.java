package guia09.extras.ejercicio1;

import java.util.Scanner;

public class Core {
    public static void main(String[] args) {
        String[] meses = new String[]{"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
        String mesSecreto = meses[9];

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Adivine el mes secreto");
            System.out.print("Introduzca el nombre del mes: ");
            String mesIngresado = scanner.nextLine().toLowerCase();

            while (!mesIngresado.equals(mesSecreto)) {
                System.out.println("Incorrecto! Te doy una pista: comienza con " + mesSecreto.charAt(0));
                System.out.print("Introduzca el nombre del mes nuevamente: ");
                mesIngresado = scanner.nextLine();
            }
        }

        System.out.println("Adivinaste! El mes era " + mesSecreto);
    }
}
