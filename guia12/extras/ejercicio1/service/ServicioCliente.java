package guia12.extras.ejercicio1.service;

import guia12.extras.ejercicio1.model.Cliente;

import java.util.Scanner;

public class ServicioCliente {
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public Cliente crearCliente() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el id del cliente: ");
        Integer id = scanner.nextInt();

        return new Cliente(nombre, id);
    }
}
