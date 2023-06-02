package guia12.ejercicio2.model;

import guia12.ejercicio2.Core;

public class Electrodomestico {
    protected Double precio;
    protected String color;
    protected char consumo;
    protected Double peso;

    public Electrodomestico() {
    }

    public Electrodomestico(Double precio, String color, char consumo, Double peso) {
        this.precio = precio;
        this.color = comprobarColor(color);
        this.consumo = comprobarConsumoEnergetico(consumo);
        this.peso = peso;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsumo() {
        return consumo;
    }

    public void setConsumo(char consumo) {
        this.consumo = consumo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public char comprobarConsumoEnergetico(char letra) {
        if (letra == 'A' || letra == 'B' || letra == 'C' || letra == 'D' || letra == 'E' || letra == 'F') {
            return letra;
        } else {
            return 'F';
        }
    }

    public String comprobarColor(String color) {
        color = color.toLowerCase();
        if (color.equals("blanco") || color.equals("negro") || color.equals("rojo") || color.equals("azul") || color.equals("gris")) {
            return color;
        } else {
            return "blanco";
        }
    }

    public void crearElectrodomestico() {
        System.out.print("Ingrese el precio del electrodomestico (Minimo 1000.0): ");
        this.setPrecio(Core.scanner.nextDouble());
        if (this.getPrecio() < 1000) {
            System.out.println("El precio del electrodomestico se establecio en $1000.0");
            this.setPrecio(1000.0);
        }
        System.out.print("Ingrese el color del electrodomestico (blanco, negro, rojo, azul y gris): ");
        this.setColor(Core.scanner.next());
        System.out.print("Ingrese el consumo del electrodomestico (A,B,C,D,E,F): ");
        this.setConsumo(Core.scanner.next().charAt(0));
        System.out.print("Ingrese el peso del electrodomestico (Kg): ");
        this.setPeso(Core.scanner.nextDouble());
        if (this.getPeso() < 1.0) {
            System.out.println("El peso minimo es de 1 Kg");
            this.setPeso(1.0);
        }
    }

    public void precioFinal() {
        switch (this.getConsumo()) {
            case 'A' -> this.setPrecio(this.getPrecio() + 1000.0);
            case 'B' -> this.setPrecio(this.getPrecio() + 800.0);
            case 'C' -> this.setPrecio(this.getPrecio() + 600.0);
            case 'D' -> this.setPrecio(this.getPrecio() + 500.0);
            case 'E' -> this.setPrecio(this.getPrecio() + 300.0);
            case 'F' -> this.setPrecio(this.getPrecio() + 100.0);
        }

        if (this.getPeso() <= 19) {
            this.setPrecio(this.getPrecio() + 100.0);
        } else if (this.getPeso() >= 20 && this.getPeso() <= 49) {
            this.setPrecio(this.getPrecio() + 500.0);
        } else if (this.getPeso() >= 50 && this.getPeso() <= 79) {
            this.setPrecio(this.getPrecio() + 800.0);
        } else if (this.getPeso() >= 80) {
            this.setPrecio(this.getPrecio() + 1000.0);
        }
    }
}
