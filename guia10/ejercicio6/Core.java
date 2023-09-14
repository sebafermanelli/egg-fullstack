package guia10.ejercicio6;

import guia10.ejercicio6.services.ProductoService;

import java.util.HashMap;
import java.util.Scanner;

public class Core {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            HashMap<String, Double> products = new HashMap<String, Double>();
            int op;

            do {
                System.out.println("1 - Ingresar producto");
                System.out.println("2 - Editar producto");
                System.out.println("3 - Eliminar producto");
                System.out.println("4 - Mostrar lista de productos");
                System.out.println("0 - Salir");
                System.out.print("Ingrese opcion: ");
                op = scanner.nextInt();

                scanner.nextLine();

                switch (op) {
                    case 0 -> System.out.println("Saliendo...");
                    case 1 -> ProductoService.addProducto(products);
                    case 2 -> {
                        ProductoService.editPrecio(products);
                        System.out.println("Presione cualquier tecla para volver al menu");
                        scanner.nextLine();
                    }
                    case 3 -> {
                        ProductoService.removeProducto(products);
                        System.out.println("Presione cualquier tecla para volver al menu");
                        scanner.nextLine();
                    }
                    case 4 -> {
                        ProductoService.showList(products);
                        System.out.println("Presione cualquier tecla para volver al menu");
                        scanner.nextLine();
                    }
                    default -> {
                        System.out.println("Opcion no valida");
                        System.out.println("Presione cualquier tecla para volver al menu");
                        scanner.nextLine();
                    }
                }
            } while (op != 0);
        }
    }
}
