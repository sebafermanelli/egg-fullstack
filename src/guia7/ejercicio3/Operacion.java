package guia7.ejercicio3;

import java.util.Scanner;

public class Operacion {
    
    private int num1, num2;

    public Operacion() {
    }

    public Operacion(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNumero1() {
        return this.num1;
    }

    public int getNumero2() {
        return this.num2;
    }

    public void setNumero1(int num1) {
        this.num1 = num1;
    }

    public void setNumero2(int num2) {
        this.num2 = num2;
    }

    public int sumar() {
        return this.num1 + this.num2;
    }

    public int restar() {
        return this.num1 - this.num2;
    }

    public int multiplicar() {
        if (num1 == 0 || num2 == 0) {
            System.out.println("Error. Cero detectado en la multiplicacion");
        }
        return num1 * num2;
    }

    public double dividir() {
        if (num2 != 0) {
            return (double)(num1/num2);
        }
        else {
            System.out.println("Error. Cero detectado en la division");
            return 0;
        }
    }

    public void crearOperacion() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el primer numero para operar:");
        this.num1 = leer.nextInt();

        System.out.println("Ingrese el segundo numero para operar:");
        this.num2 = leer.nextInt();
    }
}
