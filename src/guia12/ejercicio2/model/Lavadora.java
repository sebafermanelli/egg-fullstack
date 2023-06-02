package guia12.ejercicio2.model;

import guia12.ejercicio2.Core;

public class Lavadora extends Electrodomestico {
    protected Integer carga;

    public Lavadora() {
    }

    public Lavadora(Double precio, String color, char consumo, Double peso, Integer carga) {
        super(precio, color, consumo, peso);
        this.carga = carga;
    }

    public Integer getCarga() {
        return carga;
    }

    public void setCarga(Integer carga) {
        this.carga = carga;
    }

    public void crearLavadora() {
        super.crearElectrodomestico();
        System.out.print("Ingrese la carga de la lavadora (Kg): ");
        this.setCarga(Core.scanner.nextInt());
    }

    public void precioFinal() {
        super.precioFinal();
        if (this.carga > 30) {
            super.setPrecio(super.getPrecio() + 500.0);
        }
    }
}
