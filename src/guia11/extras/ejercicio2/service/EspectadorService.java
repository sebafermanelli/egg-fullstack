package guia11.extras.ejercicio2.service;

import guia11.extras.ejercicio1.Core;
import guia11.extras.ejercicio2.model.Espectador;

import java.util.LinkedList;
import java.util.Random;

public class EspectadorService {

    public void crearEspectadores(LinkedList<Espectador> espectadores) {
        Random random = new Random();
        for (int i = 0; i < 48; i++) {
            Espectador espectador = new Espectador();
            espectador.setNombre("Espectador " + (i+1));
            espectador.setEdad(random.nextInt(1,70));
            espectador.setDinero(random.nextDouble(1500));

            espectadores.add(espectador);
        }
    }

    public void crearEspectador(LinkedList<Espectador> espectadores) {
        Espectador espectador = new Espectador();

        System.out.print("Ingrese el nombre del espectador: ");
        espectador.setNombre(Core.scanner.next());

        System.out.print("Ingrese la edad del espectador: ");
        espectador.setEdad(Core.scanner.nextInt());

        System.out.print("Ingrese el dinero del espectador: ");
        espectador.setDinero(Core.scanner.nextDouble());

        espectadores.add(espectador);
    }
}
