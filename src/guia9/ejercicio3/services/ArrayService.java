package guia9.ejercicio3.services;

import java.util.Arrays;

public class ArrayService {
    public void inicializarA(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random() * 10;
        }
    }

    public void mostrarArray(double[] array) {
        String str = Arrays.toString(array);
        System.out.println(str);
    }

    public double[] ordenarArray(double[] array) {
        Arrays.sort(array);

        double[] aux = new double[array.length];
        int j = aux.length-1;
        for (int i = 0; i < array.length; i++) {
            aux[i] = array[j];
            j--;
        }
        return aux;
    }

    public double[] inicializarB(double[] arrayB, double[] arrayA) {
        if (arrayB.length <= arrayA.length) {
            arrayB = Arrays.copyOf(arrayA, arrayB.length);
            Arrays.fill(arrayB, 10, arrayB.length, 0.5);
        }
        else {
            System.out.println("Error");
        }

        return arrayB;
    }
}
