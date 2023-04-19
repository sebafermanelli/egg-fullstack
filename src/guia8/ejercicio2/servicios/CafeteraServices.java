package guia8.ejercicio2.servicios;

import guia8.ejercicio2.entidades.Cafetera;

import java.util.Scanner;

public class CafeteraServices {

    static Scanner scanner = new Scanner(System.in);

    public static Cafetera crearCafetera() {
        System.out.print("Ingrese la capacidad maxima de la cafetera: ");
        int capacidadMaxima = scanner.nextInt();
        System.out.print("Ingrese la cantidad actual que contiene la cafetera: ");
        int cantidadActual = scanner.nextInt();
        System.out.println("Creando la cafetera...");
        return new Cafetera(capacidadMaxima, cantidadActual);
    }

    public static void llenarCafetera(Cafetera cafetera) {
        cafetera.setCantidadActual(cafetera.getCapacidadMaxima());
        System.out.println("Llenando cafetera...");
    }

    public static void servirTaza(Cafetera cafetera, int cantidad) {
        if (cantidad > cafetera.getCantidadActual()) {
            cantidad = cafetera.getCantidadActual();
        }
        cafetera.setCantidadActual(cafetera.getCantidadActual() - cantidad);
        if (cantidad != 0) {
            System.out.println("Se ha servido una taza con " + cantidad + "ml de cafe");
        }
        else {
            System.out.println("No hay agua para servir cafe");
        }
    }

    public static void vaciarCafetera(Cafetera cafetera) {
        cafetera.setCantidadActual(0);
        System.out.println("Vaciando cafetera...");
    }

    public static void agregarCafe(Cafetera cafetera, int cantidad) {
        if (cantidad > (cafetera.getCapacidadMaxima() - cafetera.getCantidadActual())) {
            cantidad = (cafetera.getCapacidadMaxima() - cafetera.getCantidadActual());
        }
        cafetera.setCantidadActual(cafetera.getCantidadActual() + cantidad);
        System.out.println("Se ha agregado agua a la cafetera, actualmente tiene: " + cafetera.getCantidadActual() + "ml");
    }
}
