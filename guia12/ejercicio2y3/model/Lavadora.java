package guia12.ejercicio2y3.model;

import guia12.ejercicio2y3.Core;

public class Lavadora extends Electrodomestico {
    private Double carga;

    public Lavadora() {
    }

    public Lavadora(Double precio, String color, char consumoE, Double peso, Double carga) {
        super(precio, color, consumoE, peso);
        this.carga = carga;
    }

    public Double getCarga() {
        return carga;
    }

    public void setCarga(Double carga) {
        this.carga = carga;
    }


    @Override
    public String toString() {
        return "Lavadora{" +
                "carga=" + carga +
                ", precio=" + precio +
                ", color='" + color + '\'' +
                ", ce=" + consumoE +
                ", peso=" + peso +
                '}';
    }

    public void crearLavadora() {
        super.crearElectrodomestico();
        System.out.print("Ingrese la carga de la lavadora (Kg): ");
        carga = Core.scanner.nextDouble();
    }

    public void precioFinal() {
        super.precioFinal();
        if (carga > 30) {
            precio += 500;
        }
    }
}
