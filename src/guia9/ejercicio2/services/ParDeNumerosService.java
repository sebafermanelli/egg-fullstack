package guia9.ejercicio2.services;

import guia9.ejercicio2.entities.ParDeNumeros;

import java.text.DecimalFormat;

public class ParDeNumerosService {

    public static DecimalFormat df = new DecimalFormat("#.###");

    public static void mostrarValores(ParDeNumeros n) {
        System.out.println("El numero 1 es: " + df.format(n.getNum1()));
        System.out.println("El numero 2 es: " + df.format(n.getNum2()));
    }

    public static double devolverMayor(ParDeNumeros n) {
        return Math.max(n.getNum1(), n.getNum2());
    }

    public static double devolverMenor(ParDeNumeros n) {
        return Math.min(n.getNum1(), n.getNum2());
    }

    public static double calcularPotencia(ParDeNumeros n) {
        int mayor = (int)(devolverMayor(n));
        int menor = (int)(devolverMenor(n));
        return Math.pow(mayor, menor);
    }

    public static double calcularRaiz(ParDeNumeros n) {
        int menor = (int)devolverMenor(n);
        menor = Math.abs(menor);
        return Math.sqrt(menor);
    }
}
