package guia10.ejercicio3.services;

import guia10.ejercicio3.Core;
import guia10.ejercicio3.model.Alumno;

import java.util.ArrayList;

public class AlumnoService {

    ArrayList<Alumno> alumnoList = new ArrayList<Alumno>();

    public void addAlumno() {
        Alumno newAlumno = new Alumno();
        char rta;

        do {
            System.out.print("Ingrese el nombre del alumno: ");
            newAlumno.setNombre(Core.scanner.nextLine());

            System.out.print("Ingrese la primer nota del alumno: ");
            newAlumno.getNotas().add(Core.scanner.nextInt());

            System.out.print("Ingrese la segunda nota del alumno: ");
            newAlumno.getNotas().add(Core.scanner.nextInt());

            System.out.print("Ingrese la tercer nota del alumno: ");
            newAlumno.getNotas().add(Core.scanner.nextInt());

            do {
                System.out.print("Desea ingresar otro alumno? S/N: ");
                rta = Core.scanner.next().toUpperCase().charAt(0);
            } while ((rta != 'S') && (rta != 'N'));

            Core.scanner.nextLine();

            alumnoList.add(newAlumno);
        } while (rta == 'S');
    }

    public void notaFinal(String nombre) {
        Alumno getAlumno = null;
        Integer notaTotal = 0;
        double promedio = 0;

        for (Alumno a : alumnoList) {
            if (a.getNombre().equals(nombre)) {
                getAlumno = a;
                for (Integer n : a.getNotas()) {
                    notaTotal += n;
                }
            }
        }

        promedio = notaTotal / 3;

        if (getAlumno != null) {
            System.out.println("La nota promedio final de " + getAlumno.getNombre() + " es: " + promedio);
        } else {
            System.out.println("El alumno ingresado no existe");
        }

    }
}
