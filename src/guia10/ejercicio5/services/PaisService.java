package guia10.ejercicio5.services;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class PaisService {

    Scanner scanner = new Scanner(System.in);
    TreeSet<String> paises = new TreeSet<>();

    public void cargarPais() {
        String strPais;

        System.out.print("Ingrese el nombre del pais: ");
        strPais = scanner.nextLine();

        if (paises.contains(strPais)) {
            System.out.println("El pais ingresado ya se encuentra registrado");
        }

        paises.add(strPais);
    }

    public void mostrarPaises() {
        System.out.println(paises);
    }

    public void eliminarPais(String pais) {
        Iterator<String> iterator = paises.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            if (iterator.next().equals(pais)) {
                iterator.remove();
                found = true;
            }
        }

        if (!found) {
            System.out.println("El pais  no se encontró");
        }
    }
}
