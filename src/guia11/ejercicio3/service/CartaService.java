package guia11.ejercicio3.service;

import guia11.ejercicio3.model.Carta;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class CartaService {

    Scanner scanner = new Scanner(System.in);
    LinkedList<Carta> baraja = new LinkedList<Carta>();
    LinkedList<Carta> cartasRepartidas = new LinkedList<Carta>();

    public void crearBaraja() {
        for (int i = 1; i <= 12; i++) {
            if (i == 8 || i == 9) {
                continue;
            }

            baraja.add(new Carta(i, "Espada"));
            baraja.add(new Carta(i, "Basto"));
            baraja.add(new Carta(i, "Oro"));
            baraja.add(new Carta(i, "Copa"));
        }
    }

    public void cartaSiguiente() {
        System.out.println(baraja.getFirst().getNum() + " - " + baraja.getFirst().getPalo());
    }

    public void mostrarBaraja() {
        System.out.println("Cartas en la baraja (" + baraja.size() + "):");
        for (Carta c : baraja) {
            System.out.println(c.getNum() + " - " + c.getPalo());
        }
    }

    public void mezclarBaraja() {
        Collections.shuffle(baraja);
    }

    public void darCartas() {
        System.out.print("Ingrese la cantidad de cartas a pedir: ");
        int cant = scanner.nextInt();

        if (cant > baraja.size()) {
            System.out.println("La cantidad ingresada supera las cartas que se pueden repartir");
        } else {
            for (int i = 1; i <= cant; i++) {
                Carta c = baraja.removeFirst();
                cartasRepartidas.add(c);
            }
        }
    }

    public void mostrarCartasRepartidas() {
        if (cartasRepartidas.isEmpty()) {
            System.out.println("No hay cartas repartidas");
        } else {
            System.out.println("Cartas repartidas (" + cartasRepartidas.size() + "):");
            for (Carta c : cartasRepartidas) {
                System.out.println(c.getNum() + " - " + c.getPalo());
            }
        }
    }
}
