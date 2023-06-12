package guia12.ejercicio4;

import guia12.ejercicio4.model.Circulo;
import guia12.ejercicio4.model.Rectangulo;

public class Main {
    public static void main(String[] args) {
        Circulo c = new Circulo(2);
        Rectangulo r = new Rectangulo(2, 5);

        System.out.println("Circulo:");
        System.out.println("Area: " + c.calcularArea() + " - Perimetro:" + c.calcularPerimetro());
        System.out.println("Rectangulo:");
        System.out.println("Area: " + r.calcularArea() + " - Perimetro:" + r.calcularPerimetro());
    }
}
