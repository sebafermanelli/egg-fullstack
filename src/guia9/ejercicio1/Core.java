package guia9.ejercicio1;

import guia9.ejercicio1.entities.Cadena;
import guia9.ejercicio1.services.CadenaServices;

public class Core {
    public static void main(String[] args) {
        Cadena frase = new Cadena("Hola, esto es una cadena de prueba");

        System.out.println("La cadena tiene la letra a? " + CadenaServices.contiene(frase, "a"));
        System.out.println("Hay un total de " + CadenaServices.mostrarVocales(frase) + " vocales en la cadena");
        System.out.println("La cadena invertida:");
        CadenaServices.invertirFrase(frase);
        System.out.println("Hay " + CadenaServices.vecesRepetido(frase, "a") + " A en la cadena");
        System.out.println("Las cadenas tienen la misma longitud? " + CadenaServices.compararLongitud(frase, "Hola, esta es otra cadena de prueba con mayor longitud"));
        CadenaServices.unirFrases(frase, " y aca le agrego mas texto");
        System.out.println("La letra A reemplazada por %:");
        CadenaServices.reemplazarA(frase, "%");
        System.out.println(frase.getFrase());
    }
}
