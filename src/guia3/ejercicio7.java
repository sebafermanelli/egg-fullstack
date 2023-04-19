package guia3;

import java.util.Scanner;

public class ejercicio7 {
    
    public static void main(String[] args) {
        int correcto, incorrecto;
        String frase;

        Scanner leer = new Scanner(System.in);
        correcto = 0;
        incorrecto = 0;

        System.out.println("Ingrese una frase de 5 caracteres que comience con X y termine en O (&&&&& para finalizar):");
        do {
            frase = leer.nextLine();
            if (frase.length() == 5 && frase.substring(0,1).equals("X") && frase.substring(4,5).equals("O")) {
                correcto = correcto + 1;
            }
            else if (frase.equals("&&&&&") == true) {
                System.out.println("Contando...");
            }
            else {
                incorrecto = incorrecto + 1;
            }
        } while (frase.equals("&&&&&") == false);

        System.out.println("Frases correctas: " + correcto);
        System.out.println("Frases incorrectas: " + incorrecto);
    }
}