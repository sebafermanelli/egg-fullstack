package guia11.ejercicio3;

import guia11.ejercicio3.service.CartaService;

import java.util.Scanner;

public class Core {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            CartaService cs = new CartaService();
            int op;

            cs.crearBaraja();
            cs.mezclarBaraja();

            do {
                System.out.println("1 - Mostrar carta siguiente");
                System.out.println("2 - Mostrar baraja");
                System.out.println("3 - Mostrar cartas repartidas");
                System.out.println("4 - Dar una carta");
                System.out.println("0 - Salir");
                op = scanner.nextInt();

                switch (op) {
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    case 1:
                        cs.cartaSiguiente();
                        break;
                    case 2:
                        cs.mostrarBaraja();
                        break;
                    case 3:
                        cs.mostrarCartasRepartidas();
                        break;
                    case 4:
                        cs.darCartas();
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        break;
                }
            } while (op != 0);
        }
    }
}
