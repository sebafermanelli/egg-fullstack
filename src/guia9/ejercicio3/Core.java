package guia9.ejercicio3;

import guia9.ejercicio3.services.ArrayService;

import java.util.SortedMap;

public class Core {
    public static void main(String[] args) {
        double[] A = new double[50];
        double[] B = new double[20];

        ArrayService as = new ArrayService();

        System.out.println("Inicializando arreglo A...");
        as.inicializarA(A);
        System.out.println("Arreglo A:");
        as.mostrarArray(A);

        System.out.println("Arreglo A ordenado de mayor a menor:");
        as.mostrarArray(as.ordenarArray(A));

        System.out.println("Inicializando arreglo B y cambio en A...");
        B = as.inicializarB(B,A);

        System.out.println("Arreglo A:");
        as.mostrarArray(A);
        System.out.println("Arreglo B:");
        as.mostrarArray(B);
    }
}
