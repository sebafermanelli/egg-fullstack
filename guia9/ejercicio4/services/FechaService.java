package guia9.ejercicio4.services;

import java.util.Date;
import java.util.Scanner;

public class FechaService {

    Scanner leer = new Scanner(System.in);

    public Date fechaNacimiento() {
        System.out.print("Ingrese el dia de su nacimiento: ");
        int d = leer.nextInt();
        while (d > 31 || 1 > d) {
            System.out.print("Ingrese el dia de su nacimiento entre 1 y 31: ");
            d = leer.nextInt();
        }
        System.out.print("Ingrese el mes de su nacimiento: ");
        int m = leer.nextInt();
        while (m > 12 || 1 > m) {
            System.out.print("Ingrese el mes de su nacimiento entre 1 y 12: ");
            m = leer.nextInt();
        }
        System.out.print("Ingrese el año de su nacimiento: ");
        int a = leer.nextInt();

        return new Date(a - 1900, m - 1, d);
    }

    public Date fechaActual() {
        return new Date();
    }

    public long edad(Date nac, Date actual) {
        return (actual.getTime() - nac.getTime()) / 31556900000L;
    }
}
