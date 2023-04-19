package guia5.extras;

import java.util.Scanner;

public class ejercicio6 {
    
    public static void main(String[] args) {
        String[] palabras = new String[5];
        char[][] sopa = new char[20][20];
        int fila = (int)(Math.random() * 20);
        int pos = 0;

        Scanner leer = new Scanner(System.in);
        for (int i = 0; i < palabras.length; i++) {
            System.out.println("Ingrese la palabra " + (i+1) + ": ");
            do {
                palabras[i] = leer.next();
            } while (palabras[i].length() < 3 || palabras[i].length() > 5);
        }

        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];
            int longitud = palabra.length();

            while(pos + longitud > 20) {
                fila = (int)(Math.random() * 20);
                pos = 0;
            }

            for (int j = 0; j < longitud; j++) {
                sopa[fila][pos+j] = palabra.charAt(j);
            }

            pos += longitud + 1;
        }

        for (int i = 0; i < sopa.length; i++) {
            for (int j = 0; j < sopa.length; j++) {
                if (sopa[i][j] == '\0') {
                    sopa[i][j] = (char)((Math.random() * 10) + '0');
                }
            }
        }

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(sopa[i][j] + " ");
            }
            System.out.println();
        }
    }
}
