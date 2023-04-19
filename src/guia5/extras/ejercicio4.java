package guia5.extras;

import java.util.Scanner;

public class ejercicio4 {
    
    public static void main(String[] args) {
        double[] notaFinal = new double[10];
        double tp1, tp2, i1, i2, prom;
        int aprobados, desaprobados;

        Scanner leer = new Scanner(System.in);
        for (int i = 0; i < notaFinal.length; i++) {
            System.out.println("Ingrese la nota de PRIMER TP del alumno " + (i+1) + ": ");
            do {
                tp1 = leer.nextDouble();
            } while (tp1 < 1 || tp1 > 10);
            System.out.println("Ingrese la nota de SEGUNDO TP del alumno " + (i+1) + ": ");
            do {
                tp2 = leer.nextDouble();
            } while (tp2 < 1 || tp2 > 10);
            System.out.println("Ingrese la nota de PRIMER INT del alumno " + (i+1) + ": ");
            do {
                i1 = leer.nextDouble();
            } while (i1 < 1 || i1 > 10);
            System.out.println("Ingrese la nota de SEGUNDO INT del alumno " + (i+1) + ": ");
            do {
                i2 = leer.nextDouble();
            } while (i2 < 1 || i2 > 10);

            prom = (tp1 * 0.1) + (tp2 * 0.15) + (i1 * 0.25) + (i2 * 0.5);

            notaFinal[i] = prom;
        }

        aprobados = 0;
        desaprobados = 0;

        for (int i = 0; i < notaFinal.length; i++) {
            if (notaFinal[i] >= 7) {
                aprobados++;
            }
            else {
                desaprobados++;
            }
        }

        System.out.println("La cantidad de aprobados es: " + aprobados);
        System.out.println("La cantidad de desaprobados es: " + desaprobados);
    }
}