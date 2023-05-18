package guia10.ejercicio2.services;

import guia10.ejercicio1.model.Mascota;

import java.util.ArrayList;
import java.util.Scanner;

public class MascotaService {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> mascotas = new ArrayList<String>();

    public static void crearMascota() {
        Mascota mascota = new Mascota();
        System.out.print("Ingrese el nombre de la mascota: ");
        mascota.setNombre(scanner.nextLine());

        System.out.print("Ingrese la raza de la mascota: ");
        mascota.setRaza(scanner.nextLine());

        String msct = mascota.getNombre() + " - " + mascota.getRaza();

        mascotas.add(msct);
    }

    public static void MostrarListaMascotas() {
        for (String i: mascotas) {
            System.out.println(i);
        }
    }

    public static String obtenerMascotaNombre(String nombre) {
        String getOne = "No existe esa mascota";
        for (String i: mascotas) {
            if (i.startsWith(nombre)) {
                getOne = i;
                return getOne;
            }
        }
        return getOne;
    }
}
