package guia11.ejercicio1.services;

import guia11.ejercicio1.Core;
import guia11.ejercicio1.model.Perro;

import java.util.ArrayList;

public class PerroService {

    ArrayList<Perro> perroList = new ArrayList<Perro>();

    public void crearPerros() {
        char rta;

        do {
            Perro perro = new Perro();

            System.out.print("Ingrese el nombre del perro: ");
            perro.setNombre(Core.scanner.nextLine());

            System.out.print("Ingrese la raza del perro: ");
            perro.setRaza(Core.scanner.nextLine());

            System.out.print("Ingrese la edad del perro (en años): ");
            perro.setEdad(Core.scanner.nextInt());

            Core.scanner.nextLine();

            do {
                System.out.print("Ingrese el tamaño del perro (grande / mediano / chico): ");
                perro.setTamano(Core.scanner.nextLine().toLowerCase());
            } while (!perro.getTamano().equals("grande") && !perro.getTamano().equals("mediano") && !perro.getTamano().equals("chico"));

            perroList.add(perro);

            do {
                System.out.print("Desea ingresar otro perro? S/N: ");
                rta = Core.scanner.next().toUpperCase().charAt(0);
            } while (rta != 'S' && rta != 'N');

            Core.scanner.nextLine();
        } while (rta == 'S');
    }

    public void mostrarPerros() {
        System.out.println("Lista de perros:");
        for (Perro p : perroList) {
            System.out.println("Nombre: " + p.getNombre() + " - Raza: " + p.getRaza());
        }
    }

    public Perro buscarPerro() {
        System.out.println("Ingrese el nombre del perro a ser adoptado: ");
        String auxNombre = Core.scanner.nextLine();

        for (Perro perro : perroList) {
            if (auxNombre.equals(perro.getNombre())) {
                perroList.remove(perro);

                return perro;
            }
        }

        return null;
    }
}
