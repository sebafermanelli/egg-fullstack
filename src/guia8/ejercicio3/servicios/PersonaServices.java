package guia8.ejercicio3.servicios;

import guia8.ejercicio3.entidades.Persona;

import java.util.Scanner;

public class PersonaServices {

    static Scanner scanner = new Scanner(System.in);

    public static Persona crearPersona() {
        System.out.print("Ingrese el nombre de la persona: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la edad de la persona: ");
        int edad = scanner.nextInt();
        System.out.print("Ingrese el sexo de la persona (H-M-O): ");
        char sexo = scanner.next().toUpperCase().charAt(0);
        while(sexo != 'H' && sexo != 'M' && sexo != 'O') {
            System.out.print("Ingrese un caracter valido para sexo (H-M-O): ");
            sexo = scanner.next().toUpperCase().charAt(0);
        }
        System.out.print("Ingrese el peso de la persona en KG: ");
        double peso = scanner.nextDouble();
        System.out.print("Ingrese la altura de la persona en METROS: ");
        double altura = scanner.nextDouble();
        scanner.nextLine(); // consumir fin de linea
        return new Persona(nombre, edad, sexo, peso, altura);
    }

    public static boolean esMayorDeEdad(Persona p) {
        return p.getEdad() >= 18;
    }

    public static int calcularIMC(Persona p) {
        double pesoIdeal = (p.getPeso())/(Math.pow(p.getAltura(), 2));
        if (pesoIdeal < 20) {
            return -1;
        }
        if (pesoIdeal >= 20 && pesoIdeal <= 25) {
            return 0;
        }
        else {
            return 1;
        }
    }
}
