package guia4;

import java.util.Scanner;

public class ejercicio2 {
    
    public static void main(String[] args) {
        int n;

        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de personas a cargar:");
        n = leer.nextInt();

        leer.nextLine(); // Consumir el final de linea del int para que el nextLine() siguiente no de error

        String[] nombre = new String[n];
        int[] edad = new int[n];

        InicializarDatos(nombre, edad);
        CargarDatos(nombre, edad, leer);
        MostrarDatos(nombre, edad);
    }

    public static void InicializarDatos(String[] name, int[] age) {
        for (int i = 0; i < name.length; i++) {
            name[i] = "";
            age[i] = 0;
        }
    }

    public static void CargarDatos(String[] name, int[] age, Scanner leer) {
        String seguir;

        for (int i = 0; i < name.length; i++) {
            System.out.println("Ingrese el nombre de la persona " + (i+1) + ":");
            name[i] = leer.nextLine();

            System.out.println("Ingrese la edad de " + name[i] + ":");
            age[i] = leer.nextInt();

            leer.nextLine(); // Consumir el final de linea del int para que el nextLine() siguiente no de error

            if (i != name.length-1) {
                System.out.println("Desea ingresar otra persona? (Si / No) ");
                do {
                    seguir = leer.nextLine().toUpperCase();
                } while(seguir.equals("SI") && seguir.equals("NO"));
                

                if (seguir.equals("NO")) {
                    break;
                }
            }
        }
    }

    public static void MostrarDatos(String[] name, int[] age) {
        for (int i = 0; i < name.length; i++) {
            if (name[i].isEmpty()) {
                break;
            }
            if (age[i] < 18) {
            System.out.println(name[i] + " es menor, tiene " + age[i] + " años.");
            }
            else {
                System.out.println(name[i] + " es mayor, tiene " + age[i] + " años.");
            }
        }
    }
}