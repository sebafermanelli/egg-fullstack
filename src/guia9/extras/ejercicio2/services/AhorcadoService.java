package guia9.extras.ejercicio2.services;

import guia9.extras.ejercicio2.entities.Ahorcado;

import java.util.Scanner;

public class AhorcadoService {

    static Scanner scanner = new Scanner(System.in);

    public static Ahorcado crearJuego() {
        Ahorcado juego = new Ahorcado();

        System.out.print("Ingrese la palabra a adivinar: ");
        String palabra = scanner.nextLine();

        System.out.print("Ingrese la cantidad de intentos para adivinar: ");
        juego.setCantJugadasMax(scanner.nextInt());

        char[] palabraAux = new char[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            palabraAux[i] = palabra.charAt(i);
        }
        juego.setPalabra(palabraAux);

        return juego;
    }

    public static int longitud(Ahorcado juego) {
        return juego.getPalabra().length;
    }

    public static boolean buscar(Ahorcado juego, char letra) {
        for (int i = 0; i < juego.getPalabra().length; i++) {
            if (letra == juego.getPalabra()[i]) {
                return true;
            }
        }
        return false;
    }

    public static int encontradas(Ahorcado juego, char letra) {
        for (int i = 0; i < juego.getPalabra().length; i++) {
            if (letra == juego.getPalabra()[i]) {
                juego.setCantLetrasEncontradas(juego.getCantLetrasEncontradas() + 1);
            }
        }
        return juego.getCantLetrasEncontradas();
    }

    public static int intentos(Ahorcado juego) {
        juego.setCantJugadasMax(juego.getCantJugadasMax() - 1);
        return juego.getCantJugadasMax();
    }

    public static void juego() {
        Ahorcado juego = crearJuego();

        do {
            System.out.print("Ingrese una letra: ");
            char letra = scanner.next().charAt(0);

            System.out.println("Longitud de la palabra: " + juego.getPalabra().length);
            System.out.print("Mensaje: ");
            if (buscar(juego, letra)) {
                System.out.print("La letra pertenece a la palabra");
            } else {
                System.out.print("La letra no pertenece a la palabra");
                intentos(juego);
            }
            System.out.println();
            System.out.println("Numero de letras (encontradas, faltantes): (" + encontradas(juego, letra) + "," + (juego.getPalabra().length - juego.getCantLetrasEncontradas()) + ")");
            System.out.println("Numero de oportunidades restantes: " + juego.getCantJugadasMax());
        } while (juego.getCantJugadasMax() != 0 && juego.getCantLetrasEncontradas() != juego.getPalabra().length);

        if (juego.getCantLetrasEncontradas() == juego.getPalabra().length) {
            System.out.println("Ganaste!");
        } else {
            System.out.println("Perdiste!");
        }
    }
}
