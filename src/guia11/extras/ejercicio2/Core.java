package guia11.extras.ejercicio2;

import guia11.extras.ejercicio2.model.Cine;
import guia11.extras.ejercicio2.model.Espectador;
import guia11.extras.ejercicio2.service.CineService;
import guia11.extras.ejercicio2.service.EspectadorService;

import java.util.LinkedList;
import java.util.Scanner;

public class Core {

    public static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {
        LinkedList<Espectador> espectadores = new LinkedList<Espectador>();

        CineService cs = new CineService();
        EspectadorService es = new EspectadorService();

        Cine cine = cs.crearCine();

        es.crearEspectadores(espectadores);

        cs.asignarAsientos(cine, espectadores);

        cs.mostrarSala(cine);
    }
}
