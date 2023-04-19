package guia8.extras.ejercicio1.servicios;

import guia8.extras.ejercicio1.entidades.Raices;

import java.util.Scanner;

public class RaicesServices {

    static Scanner scanner = new Scanner(System.in);

    public static Raices crearFuncion() {
        System.out.print("Ingrese el valor de A: ");
        int a = scanner.nextInt();
        System.out.print("Ingrese el valor de B: ");
        int b = scanner.nextInt();
        System.out.print("Ingrese el valor de C: ");
        int c = scanner.nextInt();
        return new Raices(a,b,c);
    }

    public static double getDiscriminante(Raices r) {
        return ((Math.pow(r.getB(), 2))-4*r.getA()*r.getC());
    }

    public static boolean tieneRaices(Raices r) {
        return getDiscriminante(r) > 0;
    }

    public static boolean tieneRaiz(Raices r) {
        return getDiscriminante(r) == 0;
    }

    public static void obtenerRaices(Raices r) {
        if (tieneRaices(r)) {
            double menosB = -r.getB();
            double raiz = Math.sqrt(Math.pow(r.getB(), 2)-(4*r.getA()*r.getC()));
            double sobre = (2*r.getA());

            double r1 = (menosB + raiz) / sobre;
            double r2 = (menosB - raiz) / sobre;
            System.out.println("r1 = " + r1 + " r2 = " + r2);
        }
    }

    public static void obtenerRaiz(Raices r) {
        if (tieneRaiz(r)) {
            double menosB = -r.getB();
            double raiz = Math.sqrt(Math.pow(r.getB(), 2)-(4*r.getA()*r.getC()));
            double sobre = (2*r.getA());

            double r1 = (menosB + raiz) / sobre;
            System.out.println("r1/r2 = " + r1);
        }
    }

    public static void calcular(Raices r) {
        if (tieneRaices(r)) {
            obtenerRaices(r);
        }
        else if (tieneRaiz(r)) {
            obtenerRaiz(r);
        }
        else {
            System.out.println("No tiene raices");
        }
    }
}
