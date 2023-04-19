package guia3.extras;

import java.util.Scanner;

public class ejercicio6 {
    
    public static void main(String[] args) {
        int n, bajos;
        float alturaPromedio, alturaPromedio160, alturaTotal, alturaTotal160, altura;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de personas:");
        n = leer.nextInt();

        alturaTotal160 = 0;
        alturaTotal = 0;
        alturaPromedio160 = 0;
        alturaPromedio = 0;
        bajos = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("Ingresar la altura de la persona " + i + ":");
            altura = leer.nextFloat();

            if (altura < 1.60) {
                bajos = bajos + 1;
                alturaTotal160 = alturaTotal160 + altura;
            }

            alturaTotal = alturaTotal + altura;
        }

        alturaPromedio = alturaTotal / n;
        alturaPromedio160 = alturaTotal160 / bajos;

        System.out.println("El promedio de la altura de personas que miden menos de 1.60m es: " + alturaPromedio160);
        System.out.println("El promedio de la altura de todas las personas es: " + alturaPromedio);
    }
}