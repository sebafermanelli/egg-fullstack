package guia4;

import java.util.Scanner;

public class ejercicio1 {
    
    public static void main(String[] args) {
        int num1, num2, opcion;
        char rta;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese un numero entero positivo:");
        num1 = leer.nextInt();

        System.out.println("Ingrese otro numero entero positivo:");
        num2 = leer.nextInt();

        opcion = 0;

        while (opcion != 5) {
            System.out.println("----------------");
            System.out.println("1 - Sumar");
            System.out.println("2 - Restar");
            System.out.println("3 - Multiplicar");
            System.out.println("4 - Dividir");
            System.out.println("5 - Salir");
            System.out.println("----------------");
            System.out.print("Elija opcion: ");
            opcion = leer.nextInt();

            leer.nextLine(); // Consumir el final de linea del int para que el nextLine() siguiente no de error

            switch (opcion) {
                case 1 -> {
                    clearScreen();
                    System.out.println("La suma es: " + Suma(num1, num2));
                }
                case 2 -> {
                    clearScreen();
                    System.out.println("La resta es: " + Resta(num1, num2));
                }
                case 3 -> {
                    clearScreen();
                    System.out.println("La multiplicacion es: " + Multiplicacion(num1, num2));
                }
                case 4 -> {
                    clearScreen();
                    System.out.println("La division es: " + Division(num1, num2));
                }
                case 5 -> {
                    clearScreen();
                    System.out.println("¿Seguro desea salir? S/N");
                    rta = leer.nextLine().toUpperCase().charAt(0);
                    if (rta == 'S') {
                        clearScreen();
                        System.out.println("Saliendo...");
                    } else {
                        opcion = 0;
                    }
                }
                default -> {
                    clearScreen();
                    System.out.println("Opcion no valida");
                }
            }
        }
    }

    public static int Suma(int n1, int n2) {
        return n1 + n2;
    }

    public static int Resta(int n1, int n2) {
        return n1 - n2;
    }

    public static int Multiplicacion(int n1, int n2) {
        return n1 * n2;
    }

    public static int Division(int n1, int n2) {
        return n1 / n2;
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}