package guia13.ejercicio1;

import guia8.ejercicio3.entidades.Persona;

public class Main {
    public static void main(String[] args) {
        try {
            Persona persona = null;
            System.out.println(persona.esMayorDeEdad());
        } catch (Exception e) {
            System.out.println("Error: La persona no puede ser null");
        }
    }
}
