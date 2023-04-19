package guia7.ejercicio1;

import java.util.Scanner;

public class Core {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Libro libro1 = new Libro();
        System.out.println("Ingrese el ISBN del Libro:");
        libro1.setISBN(leer.nextInt());

        leer.nextLine(); // Consumir el final de linea del int para que el nextLine() siguiente no de error

        System.out.println("Ingrese el titulo del Libro:");
        libro1.setTitulo(leer.nextLine());

        System.out.println("Ingrese el autor del Libro:");
        libro1.setAutor(leer.nextLine());

        System.out.println("Ingrese la cantidad de paginas del Libro:");
        libro1.setPaginas(leer.nextInt());

        System.out.println(libro1.toString());
    }
}