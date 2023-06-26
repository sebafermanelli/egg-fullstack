package guia9.ejercicio1.services;

import guia9.ejercicio1.entities.Cadena;

public class CadenaServices {

    public static int mostrarVocales(Cadena frase) {
        int cont = 0;
        for (int i = 0; i < frase.getLongitud(); i++) {
            if ((frase.getFrase().toUpperCase().charAt(i) == 'A') ||
                    (frase.getFrase().toUpperCase().charAt(i) == 'E') ||
                    (frase.getFrase().toUpperCase().charAt(i) == 'I') ||
                    (frase.getFrase().toUpperCase().charAt(i) == 'O') ||
                    (frase.getFrase().toUpperCase().charAt(i) == 'U')) {
                cont++;
            }
        }
        return cont;
    }

    public static void invertirFrase(Cadena frase) {
        for (int i = frase.getLongitud() - 1; i >= 0; i--) {
            System.out.print(frase.getFrase().charAt(i));
        }
        System.out.println();
    }

    public static int vecesRepetido(Cadena frase, String letra) {
        int cont = 0;
        for (int i = 0; i < frase.getLongitud(); i++) {
            if (frase.getFrase().toUpperCase().charAt(i) == letra.toUpperCase().charAt(0)) {
                cont++;
            }
        }
        return cont;
    }

    public static boolean compararLongitud(Cadena frase, String otraFrase) {
        return frase.getLongitud() == otraFrase.length();
    }

    public static void unirFrases(Cadena frase, String otraFrase) {
        System.out.println(frase.getFrase() + otraFrase);
    }

    public static void reemplazarA(Cadena frase, String letra) {
        StringBuilder nuevaFrase = new StringBuilder();
        for (int i = 0; i < frase.getLongitud(); i++) {
            if (frase.getFrase().toUpperCase().charAt(i) == 'A') {
                nuevaFrase.append(letra.charAt(0));
            } else {
                nuevaFrase.append(frase.getFrase().charAt(i));
            }
        }
        frase.setFrase(nuevaFrase.toString());
    }

    public static boolean contiene(Cadena frase, String letra) {
        for (int i = 0; i < frase.getLongitud(); i++) {
            if (frase.getFrase().toUpperCase().charAt(i) == letra.toUpperCase().charAt(0)) {
                return true;
            }
        }
        return false;
    }
}