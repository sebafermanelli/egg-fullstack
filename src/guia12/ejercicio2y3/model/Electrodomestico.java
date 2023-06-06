package guia12.ejercicio2y3.model;

import guia12.ejercicio2y3.Core;

public class Electrodomestico {
    protected Double precio;
    protected String color;
    protected char consumoE;
    protected Double peso;

    public Electrodomestico() {
    }

    public Electrodomestico(Double precio, String color, char consumoE, Double peso) {
        this.precio = precio;
        this.color = color;
        this.consumoE = consumoE;
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

    public char getCe() {
        return consumoE;
    }

    public void setCe(char consumoE) {
        this.consumoE = consumoE;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public char comprobarConsumoElectrico(char letra) {
        if (letra == 'A' || letra == 'B' || letra == 'C' || letra == 'D' || letra == 'E' || letra == 'F') {
            return letra;
        } else {
            return 'F';
        }
    }

    public String comprobarColor(String color) {
        if (color.equalsIgnoreCase("blanco") || color.equalsIgnoreCase("negro") || color.equalsIgnoreCase("rojo") || color.equalsIgnoreCase("azul") || color.equalsIgnoreCase("gris")) {
            return color;
        } else {
            return "blanco";
        }
    }

    public void crearElectrodomestico() {
        System.out.print("Ingrese el precio del electrodomestico (Minimo 1000.0): ");
        precio = Core.scanner.nextDouble();
        if (precio < 1000) {
            System.out.println("El precio del electrodomestico se establecio en $1000.0");
            precio = 1000.0;
        }
        System.out.print("Ingrese el color del electrodomestico (blanco, negro, rojo, azul y gris): ");
        color = comprobarColor(Core.scanner.next());
        System.out.print("Ingrese el consumo del electrodomestico (A,B,C,D,E,F): ");
        consumoE = comprobarConsumoElectrico(Core.scanner.next().toUpperCase().charAt(0));
        System.out.print("Ingrese el peso del electrodomestico (Kg): ");
        peso = Core.scanner.nextDouble();
        if (peso < 1.0) {
            System.out.println("El peso minimo es de 1 Kg");
            peso = 1.0;
        }
    }

    public void precioFinal() {
        switch (consumoE) {
            case 'A' -> precio += 1000;
            case 'B' -> precio += 800;
            case 'C' -> precio += 600;
            case 'D' -> precio += 500;
            case 'E' -> precio += 300;
            case 'F' -> precio += 100;
        }

        if (peso >= 1 && peso <= 19) {
            precio += 100;
        } else if (peso >= 20 && peso <= 49) {
            precio += 500;
        } else if (peso >= 50 && peso <= 79) {
            precio += 800;
        } else if (peso >= 80) {
            precio += 1000;
        }
    }
}
