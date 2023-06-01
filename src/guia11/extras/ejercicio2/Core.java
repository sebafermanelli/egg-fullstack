package guia11.extras.ejercicio2;

import guia11.extras.ejercicio2.model.Cine;
import guia11.extras.ejercicio2.model.Espectador;
import guia11.extras.ejercicio2.service.CineService;
import guia11.extras.ejercicio2.service.EspectadorService;

import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Core {

    public static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {
        LinkedList<Espectador> espectadores = new LinkedList<Espectador>();
        char rta = 'N';

        CineService cs = new CineService();
        EspectadorService es = new EspectadorService();

        Cine cine = cs.crearCine();
        es.crearEspectadores(espectadores);
        cs.asignarAsientos(cine, espectadores);
        cs.mostrarSala(cine);

        do {
            es.crearEspectador(espectadores);
            cs.asignarAsientos(cine, espectadores);
            cs.mostrarSala(cine);

            boolean disponibilidad = false;
            for (Map.Entry<String, Boolean> asiento : cine.getSala().entrySet()) {
                if (asiento.getValue()) {
                    disponibilidad = true;
                    break;
                }
            }
            if (disponibilidad) {
                do {
                    System.out.print("Desea ingresar otro espectador? S/N: ");
                    rta = Core.scanner.next().toUpperCase().charAt(0);
                } while (rta != 'S' && rta != 'N');
            }
        } while (rta == 'S');

    }
}
