package guia12.extras.ejercicio3;

import guia12.extras.ejercicio3.model.Alojamiento;
import guia12.extras.ejercicio3.services.ExtrahotelesServicio;
import guia12.extras.ejercicio3.services.HotelesServicio;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Alojamiento> alojamientos = new ArrayList<Alojamiento>();

        HotelesServicio hotelesServicio = new HotelesServicio();
        ExtrahotelesServicio extrahotelesServicio = new ExtrahotelesServicio();

        hotelesServicio.cargarHoteles(alojamientos);
        extrahotelesServicio.cargarExtrahoteles(alojamientos);

        System.out.println("Todos los alojamientos:");
        hotelesServicio.mostrarHoteles(alojamientos);
        extrahotelesServicio.mostrarExtrahoteles(alojamientos);

        System.out.println();
        System.out.println("Hoteles de mas caro a mas barato:");
        hotelesServicio.mostrarHotelesOrdenadosPorPrecio(alojamientos);

        System.out.println();
        System.out.println("Todos los campings con restaurante:");
        extrahotelesServicio.mostrarCampingConRestaurante(alojamientos);

        System.out.println();
        System.out.println("Todas las residencias que tienen descuento:");
        extrahotelesServicio.mostrarResidenciasConDescuento(alojamientos);
    }
}