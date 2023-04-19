package guia8.ejercicio3;

import guia8.ejercicio3.entidades.Persona;
import guia8.ejercicio3.servicios.PersonaServices;

public class Core {

    static int mayores, menores, debajo, ideal, sobrepeso;
    static Persona[] personaList = new Persona[2];

    public static void main(String[] args) {

        cargarPersonas(personaList);

        clearScreen();

        mayores = 0;
        menores = 0;
        debajo = 0;
        ideal = 0;
        sobrepeso = 0;

        mostrarPersonas(personaList);

        System.out.println("Un " + ((mayores*100)/(personaList.length)) + "% son mayores");
        System.out.println("Un " + ((menores*100)/(personaList.length)) + "% son menores");
        System.out.println("Un " + ((debajo*100)/(personaList.length)) + "% esta por debajo del peso ideal");
        System.out.println("Un " + ((ideal*100)/(personaList.length)) + "% esta en el peso ideal");
        System.out.println("Un " + ((sobrepeso*100)/(personaList.length)) + "% tiene sobrepeso");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void cargarPersonas(Persona[] personaList) {
        for (int i = 0; i < personaList.length; i++) {
            personaList[i] = PersonaServices.crearPersona();
        }
    }

    public static void mostrarPersonas(Persona[] personaList) {
        for (Persona persona : personaList) {
            boolean esMayor = PersonaServices.esMayorDeEdad(persona);
            if (esMayor) {
                System.out.println(persona.getNombre() + " es mayor de edad");
                mayores += 1;
            } else {
                System.out.println(persona.getNombre() + " es menor de edad");
                menores += 1;
            }
            System.out.println(persona.getNombre() + " tiene " + persona.getEdad() + " años");

            int imc = PersonaServices.calcularIMC(persona);
            if (imc == -1) {
                System.out.println(persona.getNombre() + " esta debajo de su peso ideal");
                debajo += 1;
            } else if (imc == 0) {
                System.out.println(persona.getNombre() + " esta en su peso ideal");
                ideal += 1;
            } else if (imc == 1) {
                System.out.println(persona.getNombre() + " esta con sobrepeso");
                sobrepeso += 1;
            }

            System.out.println();
        }
    }
}
