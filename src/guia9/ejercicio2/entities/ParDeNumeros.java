package guia9.ejercicio2.entities;

public class ParDeNumeros {
    double num1, num2;

    public ParDeNumeros() {
        this.num1 = Math.random() * 10;
        this.num2 = Math.random() * 10;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }
}
