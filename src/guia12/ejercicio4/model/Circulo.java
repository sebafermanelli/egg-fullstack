package guia12.ejercicio4.model;

import guia12.ejercicio4.interfaces.CalculosFormas;

public class Circulo implements CalculosFormas {
    double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return PI * Math.pow(radio, 2);
    }

    @Override
    public double calcularPerimetro() {
        return PI * (radio * 2);
    }
}
