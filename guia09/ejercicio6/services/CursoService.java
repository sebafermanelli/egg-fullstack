package guia9.ejercicio6.services;

import guia9.ejercicio6.entities.Curso;

import java.util.Scanner;

public class CursoService {

    static Scanner scanner = new Scanner(System.in);

    public static Curso crearCurso() {
        Curso curso = new Curso();

        System.out.print("Ingrese el nombre del curso: ");
        curso.setNombreCurso(scanner.nextLine());

        System.out.print("Ingrese la cantidad de horas diarias: ");
        curso.setCantidadHorasPorDia(scanner.nextInt());

        System.out.print("Ingrese la cantidad de dias por semana: ");
        curso.setCantidadDiasPorSemana(scanner.nextInt());

        scanner.nextLine();

        System.out.print("Ingrese el turno del curso (mañana/tarde): ");
        curso.setTurno(scanner.nextLine());
        while (!curso.getTurno().equalsIgnoreCase("mañana") && !curso.getTurno().equalsIgnoreCase("tarde")) {
            System.out.print("Turno incorrecto, ingrese mañana o tarde: ");
            curso.setTurno(scanner.nextLine());
        }

        System.out.print("Ingrese el precio por hora del curso: ");
        curso.setPrecioPorHora(scanner.nextDouble());

        scanner.nextLine();
        curso.setAlumnos(cargarAlumnos(curso));
        return curso;
    }

    public static String[] cargarAlumnos(Curso curso) {
        String[] alumnos = new String[curso.getAlumnos().length];
        for (int i = 0; i < alumnos.length; i++) {
            System.out.print("Ingrese el nombre del alumno " + (i + 1) + ": ");
            alumnos[i] = scanner.nextLine();
        }
        return alumnos;
    }

    public static double calcularGananciaSemanal(Curso curso) {
        return (curso.getCantidadHorasPorDia() * curso.getPrecioPorHora() * curso.getAlumnos().length * curso.getCantidadDiasPorSemana());
    }
}
