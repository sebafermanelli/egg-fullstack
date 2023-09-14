package guia03;

import java.util.Scanner;

public class ejercicio7 {

    public static void main(String[] args) {
        int correcto, incorrecto;
        String frase;

        try (Scanner leer = new Scanner(System.in)) {
            correcto = 0;
            incorrecto = 0;

            System.out.println("Ingrese una frase de 5 caracteres que comience con X y termine en O (&&&&& para finalizar):");
            do {
                frase = leer.nextLine();
                if (frase.length() == 5 && frase.charAt(0) == 'X' && frase.charAt(4) == 'O') {
                    correcto = correcto + 1;
                } else if (frase.equals("&&&&&")) {
                    System.out.println("Contando...");
                } else {
                    incorrecto = incorrecto + 1;
                }
            } while (!frase.equals("&&&&&"));
        }
        System.out.println("Frases correctas: " + correcto);
        System.out.println("Frases incorrectas: " + incorrecto);
    }
}