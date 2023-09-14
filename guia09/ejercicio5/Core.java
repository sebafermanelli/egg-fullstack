package guia09.ejercicio5;

import guia09.ejercicio5.entities.Persona;
import guia09.ejercicio5.services.PersonaService;

import java.util.Scanner;

public class Core {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            PersonaService ps = new PersonaService();
            Persona p = ps.crearPersona();

            ps.mostrarPersona(p);

            System.out.print("Ingrese una edad para comparar: ");
            int num = scanner.nextInt();

            System.out.println(num + " es mayor que la edad de la persona (" + ps.calcularEdad(p) + ")? " + ps.menorQue(p, num));
        }
    }
}
