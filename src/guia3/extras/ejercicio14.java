package guia3.extras;

import java.util.Scanner;

public class ejercicio14 {
    
    public static void main(String[] args) {
        int totalEdad, edad, cantFamilias, cantHijos, cantTotalHijos;
        float promedioEdad;

        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de familias:");
        cantFamilias = leer.nextInt();

        totalEdad = 0;
        promedioEdad = 0;
        cantTotalHijos = 0;

        for (int i = 1; i <= cantFamilias; i++) {
            System.out.println("Ingrese la cantidad de hijos de la familia " + i + ":");
            cantHijos = leer.nextInt();

            for (int j = 1; j <= cantHijos; j++) {
                System.out.println("Ingrese la edad del hijo " + j + ":");
                edad = leer.nextInt();

                totalEdad += edad;
                cantTotalHijos++;
            }
        }

        promedioEdad = totalEdad / cantTotalHijos;

        System.out.println("El promedio de la edad de todos los hijos es: " + promedioEdad);
    }
}