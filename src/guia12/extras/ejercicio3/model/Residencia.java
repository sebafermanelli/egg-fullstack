package guia12.extras.ejercicio3.model;

public class Residencia extends Extrahotel {
    protected Integer cantHabitaciones;
    protected boolean descuentoGremio;
    protected boolean campoDeportivo;

    public Residencia() {
    }

    public Residencia(String nombre, String direccion, String localidad, String gerente, boolean privado, Integer mt2, Integer cantHabitaciones, boolean descuentoGremio, boolean campoDeportivo) {
        super(nombre, direccion, localidad, gerente, privado, mt2);
        this.cantHabitaciones = cantHabitaciones;
        this.descuentoGremio = descuentoGremio;
        this.campoDeportivo = campoDeportivo;
    }

    public Integer getCantHabitaciones() {
        return cantHabitaciones;
    }

    public void setCantHabitaciones(Integer cantHabitaciones) {
        this.cantHabitaciones = cantHabitaciones;
    }

    public boolean isDescuentoGremio() {
        return descuentoGremio;
    }

    public void setDescuentoGremio(boolean descuentoGremio) {
        this.descuentoGremio = descuentoGremio;
    }

    public boolean isCampoDeportivo() {
        return campoDeportivo;
    }

    public void setCampoDeportivo(boolean campoDeportivo) {
        this.campoDeportivo = campoDeportivo;
    }

    @Override
    public String toString() {
        return "Residencia{" +
                "cantHabitaciones=" + cantHabitaciones +
                ", descuentoGremio=" + descuentoGremio +
                ", campoDeportivo=" + campoDeportivo +
                ", privado=" + privado +
                ", mt2=" + mt2 +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                ", gerente='" + gerente + '\'' +
                '}';
    }
}
