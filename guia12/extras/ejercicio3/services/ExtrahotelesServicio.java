package guia12.extras.ejercicio3.services;

import guia12.extras.ejercicio3.model.Alojamiento;
import guia12.extras.ejercicio3.model.Camping;
import guia12.extras.ejercicio3.model.Residencia;

import java.util.ArrayList;

public class ExtrahotelesServicio {

    public void cargarExtrahoteles(ArrayList<Alojamiento> alojamientos) {
        Camping camping1 = new Camping("Camping 1", "Direccion 1", "Localidad 1", "Gerente 1", true, 5000, 100, 8, true);
        Camping camping2 = new Camping("Camping 2", "Direccion 2", "Localidad 2", "Gerente 2", false, 1500, 50, 3, false);
        Residencia residencia1 = new Residencia("Residencia 1", "Direccion 1", "Localidad 1", "Gerente 1", false, 1500, 500, true, false);
        Residencia residencia2 = new Residencia("Residencia 2", "Direccion 2", "Localidad 2", "Gerente 2", true, 2000, 800, false, true);

        alojamientos.add(camping1);
        alojamientos.add(camping2);
        alojamientos.add(residencia1);
        alojamientos.add(residencia2);
    }

    public void mostrarExtrahoteles(ArrayList<Alojamiento> alojamientos) {
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento instanceof Camping c) {
                System.out.println(c);
            }
            if (alojamiento instanceof Residencia r) {
                System.out.println(r);
            }
        }
    }

    public void mostrarCampingConRestaurante(ArrayList<Alojamiento> alojamientos) {
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento instanceof Camping c) {
                if (c.isRestaurante()) {
                    System.out.println(c);
                }
            }
        }
    }

    public void mostrarResidenciasConDescuento(ArrayList<Alojamiento> alojamientos) {
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento instanceof Residencia r) {
                if (r.isDescuentoGremio()) {
                    System.out.println(r);
                }
            }
        }
    }
}
