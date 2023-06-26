package guia8.ejercicio2;

import guia8.ejercicio2.entidades.Cafetera;
import guia8.ejercicio2.servicios.CafeteraServices;

public class Core {
    public static void main(String[] args) {
        Cafetera cafetera = CafeteraServices.crearCafetera();

        CafeteraServices.servirTaza(cafetera, 20);
        CafeteraServices.agregarCafe(cafetera, 50);

        CafeteraServices.llenarCafetera(cafetera);
        CafeteraServices.servirTaza(cafetera, 30);
        CafeteraServices.agregarCafe(cafetera, 10);
        CafeteraServices.servirTaza(cafetera, 110);

        CafeteraServices.agregarCafe(cafetera, 50);
        CafeteraServices.vaciarCafetera(cafetera);
        CafeteraServices.servirTaza(cafetera, 20);
    }
}
