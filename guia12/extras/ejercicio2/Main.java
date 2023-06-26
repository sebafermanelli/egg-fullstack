package guia12.extras.ejercicio2;

import guia12.extras.ejercicio2.model.Edificio;
import guia12.extras.ejercicio2.model.EdificioOficinas;
import guia12.extras.ejercicio2.model.Polideportivo;
import guia12.extras.ejercicio2.service.ServicioEdificioOficinas;
import guia12.extras.ejercicio2.service.ServicioPolideportivo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Edificio> edificios = new ArrayList<Edificio>();

        ServicioEdificioOficinas servicioOficinas = new ServicioEdificioOficinas();
        ServicioPolideportivo servicioPolideportivo = new ServicioPolideportivo();

        int n = 4;
        for (int i = 0; i < n; i++) {
            System.out.println("Datos del edificio");
            if (i < (n / 2)) {
                Polideportivo polideportivo = servicioPolideportivo.crearPolideportivo();
                edificios.add(polideportivo);
            } else {
                EdificioOficinas oficina = servicioOficinas.crearEdificioOficinas();
                edificios.add(oficina);
            }
            System.out.println();
        }

        for (Edificio edificio : edificios) {
            System.out.println(edificio.toString());
        }

        System.out.println();

        for (Edificio edificio : edificios) {
            if (edificio instanceof Polideportivo) {
                if (((Polideportivo) edificio).isTecho()) {
                    System.out.println("El polideportivo " + ((Polideportivo) edificio).getNombre() + " es techado");
                } else {
                    System.out.println("El polideportivo " + ((Polideportivo) edificio).getNombre() + " no es techado");
                }
            }
            if (edificio instanceof EdificioOficinas) {
                servicioOficinas.cantidadDeTrabajadores((EdificioOficinas) edificio);
            }
            System.out.println();
        }
    }
}
