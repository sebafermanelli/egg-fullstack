package guia5;

public class ejercicio1 {

    public static void main(String[] args) {
        int[] numeros = new int[100];
        int aux = 0;

        for (int i = 0; i < numeros.length; i++) {
            aux += 1;
            numeros[i] = aux;
        }

        for (int i = (numeros.length-1); 0 <= i; i--) {
            System.out.println(numeros[i]);
        }
    }
}