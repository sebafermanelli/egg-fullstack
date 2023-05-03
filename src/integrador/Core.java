package integrador;

import integrador.entities.Estudiante;
import integrador.services.EstudianteService;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Core {
    public static void main(String[] args) {
        Estudiante[] estudiantes = new Estudiante[8];
        for (int i = 0; i < estudiantes.length; i++) {
            estudiantes[i] = EstudianteService.crearEstudiante();
        }

        System.out.println("El promedio de notas del curso es: " + EstudianteService.obtenerPromedio(estudiantes));

        String[] nombresMayoresAlPromedio = EstudianteService.obtenerNombresMayorPromedio(estudiantes);
        System.out.println("Arreglo con los nombres de estudiantes que superaron el promedio:");
        System.out.println(Arrays.toString(nombresMayoresAlPromedio));

        System.out.println("Arreglo con los estudiantes que superaron el promedio:");
        Estudiante[] estudiantesMayoresAlPromedio = EstudianteService.obtenerEstudianteMayorPromedio(estudiantes);
        for (Estudiante estudiante : estudiantesMayoresAlPromedio) {
            System.out.println(estudiante.toString());
        }
    }
}
