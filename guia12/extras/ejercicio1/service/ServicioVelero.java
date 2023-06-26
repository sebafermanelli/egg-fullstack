package guia12.extras.ejercicio1.service;

import guia12.extras.ejercicio1.model.Barco;
import guia12.extras.ejercicio1.model.Velero;

import java.util.Scanner;

public class ServicioVelero extends ServicioBarco {
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public Velero crearVelero() {
        Barco barco = super.crearBarco();

        System.out.print("Ingrese la cantidad de mastiles que tiene el barco: ");
        int mastiles = scanner.nextInt();

        return new Velero(barco.getMatricula(), barco.getEslora(), barco.getAnioFabricacion(), mastiles);
    }
}
