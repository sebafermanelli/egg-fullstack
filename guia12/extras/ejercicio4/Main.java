package guia12.extras.ejercicio4;

import guia12.extras.ejercicio4.model.Estudiante;
import guia12.extras.ejercicio4.model.PersonalServicio;
import guia12.extras.ejercicio4.model.Profesor;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante(54839223, "Jose Spesto", "Soltero", "1 A");
        Profesor profesor = new Profesor(33948266, "Maria Rosa Manzotti", "Casada", 2008, 6, "Matematicas");
        PersonalServicio personalServicio = new PersonalServicio(28394883, "Daniel Higgen", "Divorciado", 2015, 9, "Decanato");

        System.out.print("La profesora " + profesor.getNombreApellido() + " estaba " + profesor.getEstadoCivil());
        profesor.setEstadoCivil("Divorciada");
        System.out.print(" pero ahora esta " + profesor.getEstadoCivil());

        System.out.println();

        System.out.print("El personal " + personalServicio.getNombreApellido() + " estaba en el despacho " + personalServicio.getNroDespacho());
        personalServicio.setNroDespacho(14);
        System.out.print(" pero ahora esta en el despacho " + personalServicio.getNroDespacho());

        System.out.println();

        System.out.print("El alumno " + estudiante.getNombreApellido() + " estaba en el curso " + estudiante.getCurso());
        estudiante.setCurso("2 B");
        System.out.print(" pero ahora paso de año a " + estudiante.getCurso());

        System.out.println();

        System.out.print("La profesora " + profesor.getNombreApellido() + " estaba dando " + profesor.getMateria());
        profesor.setMateria("Probabilidad");
        System.out.print(" pero ahora esta dando " + profesor.getMateria());

        System.out.println();

        System.out.print("El personal " + personalServicio.getNombreApellido() + " estaba en el area de " + personalServicio.getSector());
        personalServicio.setSector("Secretaria");
        System.out.print(" pero ahora esta en area de " + personalServicio.getSector());
    }
}
