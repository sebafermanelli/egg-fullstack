package guia11.ejercicio2;

import guia11.ejercicio2.model.Juego;

import java.util.Scanner;

public class Core {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Juego juego = new Juego();

        juego.crearJuego();

        boolean siguiente = juego.ronda();
        while (!siguiente) {
            siguiente = juego.ronda();
        }
    }
}
