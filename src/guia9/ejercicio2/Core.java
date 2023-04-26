package guia9.ejercicio2;

import guia9.ejercicio2.entities.ParDeNumeros;
import guia9.ejercicio2.services.ParDeNumerosService;

public class Core {
    public static void main(String[] args) {
        ParDeNumeros prueba = new ParDeNumeros();

        ParDeNumerosService.mostrarValores(prueba);
        System.out.println("El mayor es: " + ParDeNumerosService.df.format(ParDeNumerosService.devolverMayor(prueba)));
        System.out.println("El menor es: " + ParDeNumerosService.df.format(ParDeNumerosService.devolverMenor(prueba)));
        System.out.println("La potencia del mayor elevado al menor es: " + ParDeNumerosService.calcularPotencia(prueba));
        System.out.println("La raiz cuadrada del menor es: " + ParDeNumerosService.df.format(ParDeNumerosService.calcularRaiz(prueba)));
    }
}
