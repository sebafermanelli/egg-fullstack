package guia12.extras.ejercicio2.service;

import guia12.extras.ejercicio2.model.Polideportivo;

public class ServicioPolideportivo extends ServicioEdificio {

    public Polideportivo crearPolideportivo() {
        Double ancho = super.anchoEdificio();
        Double alto = super.altoEdificio();
        Double largo = super.largoEdificio();

        System.out.print("Ingrese el nombre del polideportivo: ");
        String nombre = scanner.next();

        System.out.print("Ingrese si el polideportivo " + nombre + " sera techado o no (S/N): ");
        char rta = scanner.next().toUpperCase().charAt(0);
        while (rta != 'S' && rta != 'N') {
            System.out.print("Ingrese si el polideportivo " + nombre + " sera techado o no nuevamente (S/N): ");
            rta = scanner.next().toUpperCase().charAt(0);
        }
        if (rta == 'S') {
            return new Polideportivo(ancho, alto, largo, nombre, true);
        } else {
            return new Polideportivo(ancho, alto, largo, nombre, false);
        }
    }
}
