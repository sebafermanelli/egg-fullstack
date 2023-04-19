package guia3.extras;

import java.util.Scanner;

public class ejercicio1 {
    
    public static void main(String[] args) {
        int tiempo, dias, horas;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el tiempo en minutos:");
        tiempo = leer.nextInt();

        dias = tiempo / 1440;
        tiempo = tiempo % 1440;

        horas = tiempo / 60;
        tiempo = tiempo % 60;

        System.out.println(dias + " dias, " + horas + " horas, " + tiempo + " minutos");
    }
}