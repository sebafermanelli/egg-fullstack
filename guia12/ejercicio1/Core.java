package guia12.ejercicio1;

import guia12.ejercicio1.model.Animal;
import guia12.ejercicio1.model.Caballo;
import guia12.ejercicio1.model.Gato;
import guia12.ejercicio1.model.Perro;

public class Core {
    public static void main(String[] args) {

        Animal perro = new Perro("Stich", "Carne", 8, "Doberman");
        perro.Alimentarse();

        Animal perro2 = new Perro("Teddy", "Croquetas", 10, "Chihuahua");
        perro2.Alimentarse();

        Animal gato = new Gato("Pelusa", "Galletas", 15, "Siames");
        gato.Alimentarse();

        Animal caballo = new Caballo("Spark", "Pasto", 25, "Fino");
        caballo.Alimentarse();
    }
}
