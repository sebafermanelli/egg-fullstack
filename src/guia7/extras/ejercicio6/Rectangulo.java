package guia7.extras.ejercicio6;

public class Rectangulo {
    
    private int lado1, lado2;

    Rectangulo() {
    }

    Rectangulo(int lado1, int lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }

    public int getLado1() {
        return lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public double calcular_area() {
        return this.lado1 * this.lado2;
    }
}
