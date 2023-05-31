package guia11.extras.ejercicio2.service;

import guia11.extras.ejercicio1.Core;
import guia11.extras.ejercicio2.model.Espectador;

import java.util.LinkedList;

public class EspectadorService {

    public void crearEspectadores(LinkedList<Espectador> espectadores) {
        char rta;
        do {
            Espectador espectador = new Espectador();
            System.out.print("Ingrese el nombre del espectador: ");
            espectador.setNombre(Core.scanner.next());

            System.out.print("Ingrese la edad del espectador: ");
            espectador.setEdad(Core.scanner.nextInt());

            System.out.print("Ingrese el dinero del espectador: ");
            espectador.setDinero(Core.scanner.nextDouble());

            espectadores.add(espectador);

            if (48 > espectadores.size()) {
                do {
                    System.out.print("Desea ingresar otro espectador? S/N: ");
                    rta = Core.scanner.next().toUpperCase().charAt(0);
                } while (rta != 'S' && rta != 'N');
            } else {
                rta = 'N';
            }
        } while (rta == 'S');
    }
}
