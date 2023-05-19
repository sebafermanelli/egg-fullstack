package guia11.ejercicio1;

import guia11.ejercicio1.model.Perro;
import guia11.ejercicio1.model.Persona;
import guia11.ejercicio1.services.PerroService;
import guia11.ejercicio1.services.PersonaService;

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

        System.out.println(persona.getNombre() + " adopto a " + perro.getNombre());
    }
}
