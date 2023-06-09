package guia12.extras.ejercicio1.model;

public class Yate extends BarcoMotor {
    protected Integer camarotes;

    public Yate(Integer matricula, Double eslora, Integer anioFabricacion, Integer potenciaCv, Integer camarotes) {
        super(matricula, eslora, anioFabricacion, potenciaCv);
        this.camarotes = camarotes;
    }

    public Integer getCamarotes() {
        return camarotes;
    }

    public void setCamarotes(Integer camarotes) {
        this.camarotes = camarotes;
    }

    @Override
    public String toString() {
        return "Yate{" +
                "camarotes=" + camarotes +
                ", potenciaCv=" + potenciaCv +
                ", matricula=" + matricula +
                ", eslora=" + eslora +
                ", anioFabricacion=" + anioFabricacion +
                '}';
    }

    public Double calcularModulo() {
        return super.calcularModulo() + camarotes;
    }
}
