package guia7.ejercicio2;

import java.util.Scanner;

public class Circunferencia {
    
    private double radio;

    Circunferencia() {
    }

    Circunferencia(double radio) {
        this.radio = radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return this.radio;
    }

    public double area() {
        return ((Math.PI) * Math.pow(this.radio, 2));
    }

    public double perimetro() {
        return 2 * Math.PI * this.radio;
    }

    public void crearCircunferencia() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Escribe el radio de la circunferencia:");
        this.radio = leer.nextDouble();
    }
}
