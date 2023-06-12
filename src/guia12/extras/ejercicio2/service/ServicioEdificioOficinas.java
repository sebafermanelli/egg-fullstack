package guia12.extras.ejercicio2.service;

import guia12.extras.ejercicio2.model.EdificioOficinas;

public class ServicioEdificioOficinas extends ServicioEdificio {

    public EdificioOficinas crearEdificioOficinas() {
        Double ancho = super.anchoEdificio();
        Double alto = super.altoEdificio();
        Double largo = super.largoEdificio();

        System.out.print("Ingrese la cantidad de oficinas por piso: ");
        Integer cantidadOficinas = scanner.nextInt();
        System.out.print("Ingrese la cantidad de personas por oficina por piso: ");
        Integer personasPorOficina = scanner.nextInt();
        System.out.print("Ingrese el numero de pisos del edificio: ");
        Integer numeroPisos = scanner.nextInt();

        return new EdificioOficinas(ancho, alto, largo, cantidadOficinas, personasPorOficina, numeroPisos);
    }

    public void cantidadDeTrabajadores(EdificioOficinas edificio) {
        System.out.println("En el edificio en total trabajan: " + edificio.trabajadoresTotales());
        System.out.println("En el edificio por piso trabajan: " + edificio.trabajadoresPorPiso());
    }
}
