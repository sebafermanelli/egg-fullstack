package guia12.ejercicio2;

import guia12.ejercicio2.model.Lavadora;
import guia12.ejercicio2.model.Televisor;

import java.util.Scanner;

public class Core {
    public static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {
        Lavadora lavadora = new Lavadora();
        Televisor televisor = new Televisor();

        lavadora.crearLavadora();
        System.out.println();
        televisor.crearTelevisor();
        System.out.println();

        lavadora.precioFinal();
        televisor.precioFinal();

        System.out.println("El precio final de la lavadora es: " + lavadora.getPrecio());
        System.out.println("El precio final del televisor es: " + televisor.getPrecio());
    }
}
