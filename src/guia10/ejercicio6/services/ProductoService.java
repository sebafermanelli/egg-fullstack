package guia10.ejercicio6.services;

import guia10.ejercicio6.model.Producto;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductoService {

    static Scanner scanner = new Scanner(System.in);

    public static void addProducto(HashMap<String, Double> productoList) {
        Producto producto = new Producto();
        System.out.print("Ingrese el nombre del producto: ");
        producto.setNombre(scanner.nextLine());

        System.out.print("Ingrese el precio del produto: ");
        producto.setPrecio(scanner.nextDouble());

        scanner.nextLine();

        productoList.put(producto.getNombre(), producto.getPrecio());
        System.out.println("Agregando producto...");
    }

    public static void removeProducto(HashMap<String, Double> productoList) {
        System.out.print("Ingrese el nombre del producto: ");
        String producto = scanner.nextLine();

        if (productoList.containsKey(producto)) {
            productoList.remove(producto);
            System.out.println("Eliminando producto...");
        }
        else {
            System.out.println("El producto no existe");
        }
    }

    public static void editPrecio(HashMap<String, Double> productoList) {
        System.out.print("Ingrese el nombre del producto: ");
        String producto = scanner.nextLine();

        if (productoList.containsKey(producto)) {
            System.out.print("Ingrese el nuevo precio del producto (" + producto + "):");
            Double precio = scanner.nextDouble();
            productoList.replace(producto, precio);
            System.out.println("Cambiando el precio del producto...");
            scanner.nextLine();
        }
        else {
            System.out.println("El producto no existe");
        }
    }

    public static void showList(HashMap<String, Double> productoList) {
        System.out.println("Lista de productos: ");
        for(Map.Entry<String, Double> entry : productoList.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue());
        }
    }
}
