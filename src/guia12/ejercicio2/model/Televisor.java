package guia12.ejercicio2.model;

import guia12.ejercicio2.Core;

public class Televisor extends Electrodomestico {
    protected Integer pulgadas;
    protected Boolean sintonizador;

    public Televisor() {
    }

    public Televisor(Double precio, String color, char consumo, Double peso, Integer pulgadas, Boolean sintonizador) {
        super(precio, color, consumo, peso);
        this.pulgadas = pulgadas;
        this.sintonizador = sintonizador;
    }

    public Integer getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(Integer pulgadas) {
        this.pulgadas = pulgadas;
    }

    public Boolean getSintonizador() {
        return sintonizador;
    }

    public void setSintonizador(Boolean sintonizador) {
        this.sintonizador = sintonizador;
    }

    public void crearTelevisor() {
        super.crearElectrodomestico();
        System.out.print("Ingrese las pulgadas del televisor: ");
        this.setPulgadas(Core.scanner.nextInt());
        System.out.print("Ingrese si el televisor posee sintonizador (S/N): ");
        char rta = Core.scanner.next().toLowerCase().charAt(0);
        while (rta != 's' && rta != 'n') {
            System.out.print("Ingrese si el televisor posee sintonizador (S/N): ");
            rta = Core.scanner.next().toLowerCase().charAt(0);
        }
        this.setSintonizador(rta == 's');
    }

    public void precioFinal() {
        super.precioFinal();
        if (this.pulgadas > 40) {
            super.setPrecio(super.getPrecio() * 1.3);
        }
        if (this.sintonizador) {
            super.setPrecio(super.getPrecio() + 500.0);
        }
    }
}
