package guia8.extras.ejercicio2;

import guia8.extras.ejercicio2.entidades.NIF;
import guia8.extras.ejercicio2.servicios.NIFService;

public class Core {
    public static void main(String[] args) {
        NIF nif = NIFService.crearNif();

        System.out.println("DNI: " + nif.getDni());
        System.out.println("CLASE: " + nif.getLetra());
        System.out.println("NIF: " + nif.getNIF());
        System.out.println();
        NIFService.mostrarNif(nif);
    }
}