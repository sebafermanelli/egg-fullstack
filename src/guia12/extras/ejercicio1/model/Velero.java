package guia12.extras.ejercicio1.model;

public class Velero extends Barco {
    protected Integer cantMastiles;

    public Velero(Integer matricula, Double eslora, Integer anioFabricacion, Integer cantMastiles) {
        super(matricula, eslora, anioFabricacion);
        this.cantMastiles = cantMastiles;
    }

    public Integer getCantMastiles() {
        return cantMastiles;
    }

    public void setCantMastiles(Integer cantMastiles) {
        this.cantMastiles = cantMastiles;
    }

    @Override
    public String toString() {
        return "Velero{" +
                "cantMastiles=" + cantMastiles +
                ", matricula=" + matricula +
                ", eslora=" + eslora +
                ", anioFabricacion=" + anioFabricacion +
                '}';
    }

    public Double calcularModulo() {
        return super.calcularModulo() + cantMastiles;
    }
}
