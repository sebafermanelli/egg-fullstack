package guia11.ejercicio1.services;

import guia11.ejercicio1.Core;
import guia11.ejercicio1.model.Persona;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PersonaService {

    LinkedHashMap<Integer, Persona> personaList = new LinkedHashMap<Integer, Persona>();

    public void crearPersonas() {
        char rta;

        do {
            Persona persona = new Persona();

            System.out.print("Ingrese el nombre de la persona: ");
            persona.setNombre(Core.scanner.nextLine());

            System.out.print("Ingrese el apellido de la persona: ");
            persona.setApellido(Core.scanner.nextLine());

            System.out.print("Ingrese la edad de la persona: ");
            persona.setEdad(Core.scanner.nextInt());

            System.out.print("Ingrese el DNI de la persona: ");
            persona.setDocumento(Core.scanner.nextInt());
            while(personaList.containsKey(persona.getDocumento())) {
                System.out.println("Ya existe una persona con ese DNI");
                System.out.print("Ingrese el DNI de la persona: ");
                persona.setDocumento(Core.scanner.nextInt());
            }

            Core.scanner.nextLine();

            personaList.put(persona.getDocumento(), persona);

            do {
                System.out.print("Desea ingresar otra persona? S/N: ");
                rta = Core.scanner.next().toUpperCase().charAt(0);
            } while(rta != 'S' && rta != 'N');

            Core.scanner.nextLine();
        } while (rta == 'S');
    }

    public void mostrarPersonas() {
        System.out.println("Lista de personas:");
        for(Map.Entry<Integer, Persona> entry : personaList.entrySet()) {
            System.out.println("DNI: " + entry.getValue().getDocumento() + " - Nombre: " + entry.getValue().getNombre());
        }
    }

    public Persona buscarPersona() {
        System.out.println("Ingrese el DNI de la persona para adoptar un perro: ");
        Integer auxDocumento = Core.scanner.nextInt();

        Core.scanner.nextLine();

        for(Map.Entry<Integer, Persona> entry : personaList.entrySet()) {
            if (auxDocumento.equals(entry.getKey())) {
                return entry.getValue();
            }
        }

        return null;
    }
}