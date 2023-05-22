package guia11.ejercicio2.model;

import java.util.Random;

public class Revolver {
    private Integer posActual;
    private Integer posBala;

    public Revolver() {
    }

    public Integer getPosActual() {
        return posActual;
    }

    public void setPosActual(Integer posActual) {
        this.posActual = posActual;
    }

    public Integer getPosBala() {
        return posBala;
    }

    public void setPosBala(Integer posBala) {
        this.posBala = posBala;
    }

    @Override
    public String toString() {
        return "Revolver{" +
                "posActual=" + posActual +
                ", posBala=" + posBala +
                '}';
    }

    public void llenarRevolver() {
        Random aleatorio = new Random();
        this.setPosActual(aleatorio.nextInt(1,7));
        this.setPosBala(aleatorio.nextInt(1,7));
    }

    public boolean disparar() {
        return this.getPosActual().equals(this.getPosBala());
    }

    public void siguieteDisparo() {
        if (this.getPosActual().equals(6)) {
            this.setPosActual(1);
        }
        else {
            this.setPosActual(this.getPosActual() + 1);
        }
    }
}
