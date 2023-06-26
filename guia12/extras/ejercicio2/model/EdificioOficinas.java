package guia12.extras.ejercicio2.model;

public class EdificioOficinas extends Edificio {
    protected Integer cantidadOficinas, personasPorOficina, numeroPisos;

    public EdificioOficinas(Double ancho, Double alto, Double largo, Integer cantidadOficinas, Integer personasPorOficina, Integer numeroPisos) {
        super(ancho, alto, largo);
        this.cantidadOficinas = cantidadOficinas;
        this.personasPorOficina = personasPorOficina;
        this.numeroPisos = numeroPisos;
    }

    public Integer getCantidadOficinas() {
        return cantidadOficinas;
    }

    public void setCantidadOficinas(Integer cantidadOficinas) {
        this.cantidadOficinas = cantidadOficinas;
    }

    public Integer getPersonasPorOficina() {
        return personasPorOficina;
    }

    public void setPersonasPorOficina(Integer personasPorOficina) {
        this.personasPorOficina = personasPorOficina;
    }

    public Integer getNumeroPisos() {
        return numeroPisos;
    }

    public void setNumeroPisos(Integer numeroPisos) {
        this.numeroPisos = numeroPisos;
    }

    @Override
    public String toString() {
        return "EdificioOficinas{" +
                "cantidadOficinas=" + cantidadOficinas +
                ", personasPorOficina=" + personasPorOficina +
                ", numeroPisos=" + numeroPisos +
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
        return (ancho * alto * largo);
    }

    public int trabajadoresTotales() {
        return cantidadOficinas * personasPorOficina * numeroPisos;
    }

    public int trabajadoresPorPiso() {
        return (cantidadOficinas * personasPorOficina * numeroPisos) / numeroPisos;
    }
}
