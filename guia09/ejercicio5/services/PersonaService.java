package guia09.ejercicio5.services;

import guia09.ejercicio5.entities.Persona;

import java.util.Date;
import java.util.Scanner;

public class PersonaService {

    Scanner leer = new Scanner(System.in);

    public Persona crearPersona() {
        System.out.print("Ingrese el nombre: ");
        String nombre = leer.nextLine();
        System.out.println("Ingrese la fecha de nacimiento");
        System.out.print("Ingrese el dia: ");
        int d = leer.nextInt();
        while (d > 31 || 1 > d) {
            System.out.print("Ingrese el dia de su nacimiento entre 1 y 31: ");
            d = leer.nextInt();
        }
        System.out.print("Ingrese el mes: ");
        int m = leer.nextInt();
        while (m > 12 || 1 > m) {
            System.out.print("Ingrese el mes de su nacimiento entre 1 y 12: ");
            m = leer.nextInt();
        }
        System.out.print("Ingrese el año de su nacimiento: ");
        int a = leer.nextInt();

        Date nac = new Date(a - 1900, m - 1, d);
        return new Persona(nombre, nac);
    }

    public int calcularEdad(Persona p) {
        Date actual = new Date();
        return (int) ((actual.getTime() - p.getNacimiento().getTime()) / 31556900000L);
    }

    public boolean menorQue(Persona p, int edad) {
        return calcularEdad(p) < edad;
    }

    public void mostrarPersona(Persona p) {
        System.out.println("Nombre: " + p.getNombre());
        System.out.println("Edad: " + calcularEdad(p));
    }
}
