package guia12.extras.ejercicio1.service;

import guia12.extras.ejercicio1.model.*;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ServicioAlquiler {
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public Alquiler crearAlquiler(Cliente cliente) {
        Barco barco = null;

        System.out.print("Ingrese el tipo de barco (Yate, Velero, Lancha): ");
        String tipo = scanner.next();
        while(!tipo.equalsIgnoreCase("Yate") && !tipo.equalsIgnoreCase("Velero") && !tipo.equalsIgnoreCase("Lancha")) {
            System.out.print("Ingrese un tipo de barco correcto (Yate, Velero, Lancha): ");
            tipo = scanner.next();
        }
        if(tipo.equalsIgnoreCase("Yate")) {
            ServicioYate serviceYate = new ServicioYate();
            barco = serviceYate.crearYate();
        } else if (tipo.equalsIgnoreCase("Velero")) {
            ServicioVelero serviceVelero = new ServicioVelero();
            barco = serviceVelero.crearVelero();
        } else if (tipo.equalsIgnoreCase("Lancha")) {
            ServicioBarcoMotor serviceBarcoMotor = new ServicioBarcoMotor();
            barco = serviceBarcoMotor.crearBarcoMotor();
        }

        System.out.print("Ingrese el dia de devolucion del barco: ");
        int dia = scanner.nextInt();
        System.out.print("Ingrese el mes de devolucion del barco: ");
        int mes = scanner.nextInt();
        System.out.print("Ingrese el año que desea retirar el barco: ");
        int anio = scanner.nextInt();
        Date fechaActual = new Date();
        Date fechaDevolucion = new Date(anio-1900,mes-1,dia);
        while(fechaActual.getTime() > fechaDevolucion.getTime()) {
            System.out.print("Ingrese el dia de devolucion del barco: ");
            dia = scanner.nextInt();
            System.out.print("Ingrese el mes de devolucion del barco: ");
            mes = scanner.nextInt();
            System.out.print("Ingrese el año que desea retirar el barco: ");
            anio = scanner.nextInt();
            fechaActual = new Date();
            fechaDevolucion = new Date(anio-1900,mes-1,dia);
        }

        return new Alquiler(cliente, new Date(), fechaDevolucion, 0, barco);
    }

    public Double calcularAlquiler(Alquiler alquiler) {
        long tiempoAlquilerEnMilisegundos = (alquiler.getFechaDevolucion().getTime() - alquiler.getFechaAlquiler().getTime());
        long tiempoAlquilerEnDias = TimeUnit.MILLISECONDS.toDays(tiempoAlquilerEnMilisegundos);
        double valorAlquiler = 0;

        if(alquiler.getBarco() instanceof Yate) {
            valorAlquiler = (double) (tiempoAlquilerEnDias) * (alquiler.getBarco().calcularModulo());
        } else if(alquiler.getBarco() instanceof Velero) {
            valorAlquiler = (double) (tiempoAlquilerEnDias) * (alquiler.getBarco().calcularModulo());
        } else if(alquiler.getBarco() instanceof BarcoMotor) {
            valorAlquiler = (double) (tiempoAlquilerEnDias) * (alquiler.getBarco().calcularModulo());
        }
        return valorAlquiler;
    }
}
