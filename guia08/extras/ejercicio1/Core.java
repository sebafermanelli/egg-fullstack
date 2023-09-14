package guia08.extras.ejercicio1;

import guia08.extras.ejercicio1.entidades.Raices;
import guia08.extras.ejercicio1.servicios.RaicesServices;

public class Core {
    public static void main(String[] args) {

        Raices ecuacion = RaicesServices.crearFuncion();

        RaicesServices.calcular(ecuacion);
    }
}
