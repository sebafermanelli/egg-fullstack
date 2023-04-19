package guia7.extras.ejercicio2;

import java.util.Scanner;

public class Puntos {
    
    private int x1,y1,x2,y2;

    Puntos() {
    }

    Puntos(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public void crearPuntos() {
        Scanner leer = new Scanner(System.in);
        System.out.print("X1: ");
        this.x1 = leer.nextInt();
        System.out.print("Y1: ");
        this.y1 = leer.nextInt();

        System.out.print("X2: ");
        this.x2 = leer.nextInt();
        System.out.print("Y2: ");
        this.y2 = leer.nextInt();
    }

    public double distancia() {
        double d, x, y;

        x = Math.pow(this.x2-this.x1, 2);
        y = Math.pow(this.y2-this.y1, 2);
        d = Math.sqrt(x+y);
        return d;
    }
}