package guia12.extras.ejercicio1.service;

import guia12.extras.ejercicio1.model.BarcoMotor;
import guia12.extras.ejercicio1.model.Yate;

import java.util.Scanner;

public class ServicioYate extends ServicioBarcoMotor {
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public Yate crearYate() {
        BarcoMotor barcoMotor = super.crearBarcoMotor();

        System.out.print("Ingrese la cantidad de camarotes: ");
        int camarotes = scanner.nextInt();

        return new Yate(barcoMotor.getMatricula(), barcoMotor.getEslora(), barcoMotor.getAnioFabricacion(), barcoMotor.getPotenciaCv(), camarotes);
    }
}
