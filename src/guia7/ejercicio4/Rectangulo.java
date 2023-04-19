package guia7.ejercicio4;

import java.util.Scanner;

public class Rectangulo {
    
    private int base, altura;
    
    Rectangulo() {
    }

    Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getBase() {
        return this.base;
    }

    public int getAltura() {
        return this.altura;
    }

    public void crearRectangulo() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la base del rectangulo:");
        this.base = leer.nextInt();

        System.out.println("Ingrese la altura del rectangulo:");
        this.altura = leer.nextInt();
    }

    public int superficie() {
        return base * altura;
    }

    public int perimetro() {
        return (base + altura) * 2;
    }

    public void crearRectanguloAsteriscos() {
        for (int i = 0; i < this.altura; i++) {
            for (int j = 0; j < this.base; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
