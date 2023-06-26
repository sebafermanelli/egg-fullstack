package guia11.extras.ejercicio1;

import guia11.extras.ejercicio1.model.Perro;
import guia11.extras.ejercicio1.model.Persona;
import guia11.extras.ejercicio1.services.PerroService;
import guia11.extras.ejercicio1.services.PersonaService;

import java.util.LinkedList;
import java.util.Scanner;

public class Core {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PersonaService ps = new PersonaService();
        PerroService pp = new PerroService();

        ps.crearPersonas();
        pp.crearPerros();

        adoptar(ps, pp);
    }

    public static void adoptar(PersonaService ps, PerroService pp) {
        char rta;
        LinkedList<Persona> adopcionesList = new LinkedList<Persona>();

        do {
            ps.mostrarPersonas();
            System.out.println();
            pp.mostrarPerros();
            System.out.println();

            Persona persona = ps.buscarPersona();
            while (persona == null) {
                System.out.println("No se encontro la persona con ese DNI");
                persona = ps.buscarPersona();
            }
            Perro perro = pp.buscarPerro();
            while (perro == null) {
                System.out.println("No se encontro el perro con ese nombre");
                perro = pp.buscarPerro();
            }

            persona.setPerro(perro);
            adopcionesList.add(persona);

            System.out.println(persona.getNombre() + " adopto a " + perro.getNombre());

            if (pp.cantidadPerros() != 0) {
                do {
                    System.out.print("Desea registrar otra adopcion? S/N: ");
                    rta = Core.scanner.next().toUpperCase().charAt(0);
                    Core.scanner.nextLine();
                } while (rta != 'S' && rta != 'N');
            } else {
                rta = 'N';
            }
        } while (rta == 'S');

        System.out.println("Lista de personas con sus mascotas:");
        for (Persona entry : adopcionesList) {
            System.out.println("DNI: " + entry.getDocumento() + " - Nombre: " + entry.getNombre() + " - Nombre de mascota:" + entry.getPerro().getNombre());
        }
    }
}
