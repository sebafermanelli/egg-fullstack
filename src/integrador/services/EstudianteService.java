package integrador.services;

import integrador.entities.Estudiante;

import java.util.Scanner;

public class EstudianteService {

    static Scanner scanner = new Scanner(System.in);

    public static Estudiante crearEstudiante() {
        Estudiante estudiante = new Estudiante();

        System.out.print("Ingrese el nombre del estudiante: ");
        estudiante.setNombre(scanner.nextLine());

        System.out.print("Ingrese la nota del estudiante: ");
        estudiante.setNota(scanner.nextInt());
        scanner.nextLine();

        return estudiante;
    }

    public static double obtenerPromedio(Estudiante[] estudiante) {
        double notaTotal = 0;
        for (Estudiante e : estudiante) {
            notaTotal += e.getNota();
        }

        return (notaTotal / estudiante.length);
    }

    public static String[] obtenerNombresMayorPromedio(Estudiante[] estudiante) {
        int longitud = 0;
        for (Estudiante i : estudiante) {
            if (i.getNota() > obtenerPromedio(estudiante)) {
                longitud++;
            }
        }

        String[] aux = new String[longitud];

        int j = 0;
        for (Estudiante i : estudiante) {
            if (i.getNota() > obtenerPromedio(estudiante)) {
                aux[j] = i.getNombre();
                j++;
            }
        }

        return aux;
    }

    public static Estudiante[] obtenerEstudianteMayorPromedio(Estudiante[] estudiante) {
        int longitud = 0;
        for (Estudiante i : estudiante) {
            if (i.getNota() > obtenerPromedio(estudiante)) {
                longitud++;
            }
        }

        Estudiante[] aux = new Estudiante[longitud];

        int j = 0;
        for (Estudiante i : estudiante) {
            if (i.getNota() > obtenerPromedio(estudiante)) {
                aux[j] = i;
                j++;
            }
        }

        return aux;
    }
}
