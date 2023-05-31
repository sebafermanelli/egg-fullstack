package guia11.extras.ejercicio2.service;

import guia11.extras.ejercicio2.Core;
import guia11.extras.ejercicio2.model.Cine;
import guia11.extras.ejercicio2.model.Espectador;
import guia11.extras.ejercicio2.model.Pelicula;

import java.util.*;

public class CineService {

    public static <K, V> K getRandomKey(Map<K, V> sala) {
        // Obtener la lista de claves
        List<K> keys = new ArrayList<>(sala.keySet());

        // Generar un número aleatorio
        Random random = new Random();
        int randomIndex = random.nextInt(keys.size());

        // Obtener la clave aleatoria
        return keys.get(randomIndex);
    }

    public Cine crearCine() {
        Cine cine = new Cine();

        System.out.print("Ingrese el nombre del cine: ");
        cine.setNombre(Core.scanner.next());

        crearSala(cine);
        System.out.println("Cargando asientos en sala...");

        System.out.print("Ingrese el valor de la entrada al cine: ");
        cine.setValorEntrada(Core.scanner.nextDouble());

        Pelicula peli = PeliculaService.crearPelicula();
        cine.setPelicula(peli);

        return cine;
    }

    public void crearSala(Cine cine) {
        for (int i = 8; i >= 1; i--) {
            for (int j = 65; j <= 70; j++) {
                char letra = (char) j;
                String asiento = String.valueOf(i) + letra;
                cine.getSala().put(asiento, true);
            }
        }
    }

    public void asignarAsientos(Cine cine, LinkedList<Espectador> espectadores) {
        do {
            String asientoAleatorio = getRandomKey(cine.getSala());
            while (!cine.getSala().get(asientoAleatorio)) {
                asientoAleatorio = getRandomKey(cine.getSala());
            }
            Espectador e = espectadores.getFirst();
            if ((e.getDinero() >= cine.getValorEntrada()) && (e.getEdad() >= cine.getPelicula().getEdadMinima())) {
                espectadores.removeFirst();
                cine.getSala().replace(asientoAleatorio, false);
            } else {
                espectadores.removeFirst();
                System.out.println(e.getNombre() + " es un sinverguenza");
            }
        } while (!espectadores.isEmpty());
    }

    public void mostrarSala(Cine cine) {
        System.out.println(cine.getNombre() + " SALA: ");
        for (int i = 8; i >= 1; i--) {
            for (int j = 65; j <= 70; j++) {
                char letra = (char) j;
                String asiento = String.valueOf(i) + letra;
                if (cine.getSala().get(asiento)) {
                    System.out.print(asiento + " |");
                } else {
                    System.out.print(asiento + "X|");
                }
            }
            System.out.println();
        }
    }
}
