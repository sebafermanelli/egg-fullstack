package guia12.extras.ejercicio1.model;

public class BarcoMotor extends Barco {
    protected Integer potenciaCv;

    public BarcoMotor(Integer matricula, Double eslora, Integer anioFabricacion, Integer potenciaCv) {
        super(matricula, eslora, anioFabricacion);
        this.potenciaCv = potenciaCv;
    }

    public Integer getPotenciaCv() {
        return potenciaCv;
    }

    public void setPotenciaCv(Integer potenciaCv) {
        this.potenciaCv = potenciaCv;
    }

    @Override
    public String toString() {
        return "BarcoMotor{" +
                "potenciaCv=" + potenciaCv +
                ", matricula=" + matricula +
                ", eslora=" + eslora +
                ", anioFabricacion=" + anioFabricacion +
                '}';
    }

    public Double calcularModulo() {
        return super.calcularModulo() + potenciaCv;
    }
}
