package guia15.ejercicio1;

import guia15.ejercicio1.service.FabricanteService;
import guia15.ejercicio1.service.ProductoService;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) throws Exception {
        ProductoService productoService = new ProductoService();
        FabricanteService fabricanteService = new FabricanteService();
        int op;
        do {
            System.out.println("1 - Listar los productos");
            System.out.println("2 - Listar los fabricantes");
            System.out.println("3 - Ingresar un producto");
            System.out.println("4 - Ingresar un fabricante");
            System.out.println("5 - Editar un producto");
            System.out.println("6 - Editar un fabricante");
            System.out.println("7 - Eliminar un producto");
            System.out.println("8 - Eliminar un fabricante");
            System.out.print("Ingrese la opcion: ");
            do {
                op = scanner.nextInt();
            } while (op < 0 || op > 8);
            switch (op) {
                case 0:
                    System.out.println("Cerrando programa...");
                    break;
                case 1:
                    System.out.println("Productos: ");
                    productoService.listar();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Fabricantes: ");
                    fabricanteService.listar();
                    System.out.println();
                    break;
                case 3:
                    productoService.insert();
                    System.out.println("Agregando producto...");
                    break;
                case 4:
                    fabricanteService.insert();
                    System.out.println("Agregando fabricante...");
                    break;
                case 5:
                    productoService.update();
                    System.out.println("Modificando producto...");
                    break;
                case 6:
                    fabricanteService.update();
                    System.out.println("Modificando fabricante...");
                    break;
                case 7:
                    productoService.delete();
                    System.out.println("Eliminando producto...");
                    break;
                case 8:
                    fabricanteService.delete();
                    System.out.println("Eliminando fabricante...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (op != 0);
    }
}
