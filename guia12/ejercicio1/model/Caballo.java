package guia12.ejercicio1.model;

public class Caballo extends Animal {

    public Caballo(String nombre, String alimento, Integer edad, String raza) {
        super(nombre, alimento, edad, raza);
    }

    public void Alimentarse() {
        System.out.println(super.getNombre() + " es un " + super.getRaza() + " y come " + super.getAlimento());
    }
}
