package guia12.extras.ejercicio2.model;

public abstract class Edificio {
    protected Double ancho, alto, largo;

    public Edificio(Double ancho, Double alto, Double largo) {
        this.ancho = ancho;
        this.alto = alto;
        this.largo = largo;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public Double getAlto() {
        return alto;
    }

    public void setAlto(Double alto) {
        this.alto = alto;
    }

    public Double getLargo() {
        return largo;
    }

    public void setLargo(Double largo) {
        this.largo = largo;
    }

    @Override
    public String toString() {
        return "Edificio{" +
                "ancho=" + ancho +
                ", alto=" + alto +
                ", largo=" + largo +
                '}';
    }

    public abstract double calcularSuperficie();

    public abstract double calcularVolumen();
}
