package guia12.ejercicio1.model;

public class Perro extends Animal {

    public Perro(String nombre, String alimento, Integer edad, String raza) {
        super(nombre, alimento, edad, raza);
    }

    public void Alimentarse() {
        System.out.println(super.getNombre() + " es un " + super.getRaza() + " y come " + super.getAlimento());
    }
}
