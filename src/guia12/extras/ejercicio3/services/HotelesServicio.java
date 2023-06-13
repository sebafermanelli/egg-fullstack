package guia12.extras.ejercicio3.services;

import guia12.extras.ejercicio3.model.Alojamiento;
import guia12.extras.ejercicio3.model.Hotel;
import guia12.extras.ejercicio3.model.Hotel4;
import guia12.extras.ejercicio3.model.Hotel5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HotelesServicio {

    public void cargarHoteles(ArrayList<Alojamiento> alojamientos) {
        Hotel5 hotel5estrellas1 = new Hotel5("Hotel 1", "Direccion 1", "Localidad 1", "Gerente 1", 10, 2, 3, 50.0, "A", "Restaurante 5 1", 100, 2, 5, 25);
        Hotel5 hotel5estrellas2 = new Hotel5("Hotel 2", "Direccion 2", "Localidad 2", "Gerente 2", 13, 1, 6, 50.0, "B", "Restaurante 5 2", 120, 4, 3, 15);
        Hotel4 hotel4estrellas1 = new Hotel4("Hotel 3", "Direccion 3", "Localidad 3", "Gerente 3", 15, 1, 4, 50.0, "B", "Restaurante 4 1", 80);
        Hotel4 hotel4estrellas2 = new Hotel4("Hotel 4", "Direccion 4", "Localidad 4", "Gerente 4", 12, 4, 3, 50.0, "B", "Restaurante 4 2", 60);

        alojamientos.add(hotel4estrellas1);
        alojamientos.add(hotel4estrellas2);
        alojamientos.add(hotel5estrellas1);
        alojamientos.add(hotel5estrellas2);
    }

    public void mostrarHoteles(ArrayList<Alojamiento> alojamientos) {
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento instanceof Hotel4 h) {
                System.out.println(h);
            }
            if (alojamiento instanceof Hotel5 h) {
                System.out.println(h);
            }
        }
    }

    public void mostrarHotelesOrdenadosPorPrecio(ArrayList<Alojamiento> alojamientos) {
        List<Hotel> hoteles = new ArrayList<Hotel>();

        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento instanceof Hotel h) {
                hoteles.add(h);
            }
        }

        hoteles.sort(new Comparator<Hotel>() {
            @Override
            public int compare(Hotel o1, Hotel o2) {
                return o2.getPrecioHabitacion().compareTo(o1.getPrecioHabitacion());
            }
        });

        for (Hotel h : hoteles) {
            if (h instanceof Hotel4 h4) {
                System.out.println(h4);
            }
            if (h instanceof Hotel5 h5) {
                System.out.println(h5);
            }
        }
    }
}
