package guia11.ejercicio2.model;

import guia11.ejercicio2.Core;

import java.util.ArrayList;

public class Juego {
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private Revolver revolver;

    public Juego() {
    }

    public void crearJuego() {
        System.out.print("Ingrese la cantidad de jugadores (1-6): ");
        int cant = Core.scanner.nextInt();
        Core.scanner.nextLine();
        if (cant > 6 || cant < 1) {
            cant = 6;
        }

        for (int i = 1; i < cant + 1; i++) {
            Jugador jugador = new Jugador();
            jugador.setId(i);
            jugador.setNombre("Jugador " + jugador.getId());

            jugadores.add(jugador);
        }

        System.out.println(cant + " jugadores cargados...");

        revolver = new Revolver();
        System.out.println("Cargando revolver...");
        revolver.llenarRevolver();
    }

    public boolean ronda() {

        for (Jugador j : jugadores) {
            System.out.print("Presione cualquier tecla para disparar");
            Core.scanner.nextLine();

            if (j.disparo(revolver)) {
                System.out.println("El " + j.getNombre() + " se disparo y murio");
                return true;
            } else {
                System.out.println("El " + j.getNombre() + " se disparo y no murio");
            }
        }
        return false;
    }
}
