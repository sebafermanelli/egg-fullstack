package guia12.extras.ejercicio1.service;

import guia12.extras.ejercicio1.model.Barco;

import java.util.Scanner;

public class ServicioBarco {
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public Barco crearBarco() {
        System.out.print("Ingrese la matricula del barco: ");
        Integer matricula = scanner.nextInt();
        System.out.print("Ingrese la medida de la eslora del barco en metros: ");
        Double eslora = scanner.nextDouble();
        System.out.print("Ingrese el año de fabricacion del barco (1950-2023): ");
        int anioFabricacion = scanner.nextInt();
        while(anioFabricacion > 2023 || anioFabricacion < 1950) {
            System.out.print("Ingrese un año de fabricacion del barco correcto (1950-2023): ");
            anioFabricacion = scanner.nextInt();
        }

        return new Barco(matricula, eslora, anioFabricacion);
    }
}
