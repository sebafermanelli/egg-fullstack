package guia12.ejercicio2y3.model;

import guia12.ejercicio2y3.Core;

public class Televisor extends Electrodomestico {
    private Integer pulgadas;
    private Boolean sintonizador;

    public Televisor() {
    }

    public Televisor(Double precio, String color, char consumoE, Double peso, Integer pulgadas, Boolean sintonizador) {
        super(precio, color, consumoE, peso);
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

    @Override
    public String toString() {
        return "Televisor{" +
                "pulgadas=" + pulgadas +
                ", sintonizador=" + sintonizador +
                ", precio=" + precio +
                ", color='" + color + '\'' +
                ", ce=" + consumoE +
                ", peso=" + peso +
                '}';
    }

    public void crearTelevisor() {
        super.crearElectrodomestico();
        System.out.print("Ingrese las pulgadas del televisor: ");
        pulgadas = Core.scanner.nextInt();
        System.out.print("Ingrese si el televisor posee sintonizador (S/N): ");
        char rta = Core.scanner.next().toLowerCase().charAt(0);
        while (rta != 's' && rta != 'n') {
            System.out.print("Ingrese si el televisor posee sintonizador (S/N): ");
            rta = Core.scanner.next().toLowerCase().charAt(0);
        }
        sintonizador = rta == 's';
    }

    public void precioFinal() {
        super.precioFinal();
        if (pulgadas > 40) {
            precio *= 1.3;
        }
        if (sintonizador) {
            precio += 500;
        }
    }
}
