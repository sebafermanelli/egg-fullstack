package guia12.extras.ejercicio2.model;

public class Polideportivo extends Edificio {
    protected String nombre;
    protected boolean techo;

    public Polideportivo(Double ancho, Double alto, Double largo, String nombre, boolean techo) {
        super(ancho, alto, largo);
        this.nombre = nombre;
        this.techo = techo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isTecho() {
        return techo;
    }

    public void setTecho(boolean techo) {
        this.techo = techo;
    }

    @Override
    public String toString() {
        return "Polideportivo{" +
                "nombre='" + nombre + '\'' +
                ", techo=" + techo +
                ", ancho=" + ancho +
                ", alto=" + alto +
                ", largo=" + largo +
                '}';
    }

    @Override
    public double calcularSuperficie() {
        return 2 * ((ancho * alto) + (ancho * largo) + (alto * largo));
    }

    @Override
    public double calcularVolumen() {
        return (ancho * alto * this.getLargo());
    }
}
