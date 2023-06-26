package guia12.extras.ejercicio1.service;

import guia12.extras.ejercicio1.model.Barco;
import guia12.extras.ejercicio1.model.BarcoMotor;

import java.util.Scanner;

public class ServicioBarcoMotor extends ServicioBarco {
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public BarcoMotor crearBarcoMotor() {
        Barco barco = super.crearBarco();

        System.out.print("Ingrese la potencia del barco en CV: ");
        int cv = scanner.nextInt();

        return new BarcoMotor(barco.getMatricula(), barco.getEslora(), barco.getAnioFabricacion(), cv);
    }
}
