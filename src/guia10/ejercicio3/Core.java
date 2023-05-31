package guia10.ejercicio3;

import guia10.ejercicio3.services.AlumnoService;

import java.util.Scanner;

public class Core {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AlumnoService as = new AlumnoService();
        as.addAlumno();

        System.out.println("Ingrese el nombre del alumno ");
        String nombre = scanner.nextLine();
        as.notaFinal(nombre);
    }
}
