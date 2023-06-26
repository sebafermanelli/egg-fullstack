package guia12.extras.ejercicio3.model;

public class Camping extends Extrahotel {
    protected Integer cantCarpas;
    protected Integer cantBanios;
    protected boolean restaurante;

    public Camping() {
    }

    public Camping(String nombre, String direccion, String localidad, String gerente, boolean privado, Integer mt2, Integer cantCarpas, Integer cantBanios, boolean restaurante) {
        super(nombre, direccion, localidad, gerente, privado, mt2);
        this.cantCarpas = cantCarpas;
        this.cantBanios = cantBanios;
        this.restaurante = restaurante;
    }

    public Integer getCantCarpas() {
        return cantCarpas;
    }

    public void setCantCarpas(Integer cantCarpas) {
        this.cantCarpas = cantCarpas;
    }

    public Integer getCantBanios() {
        return cantBanios;
    }

    public void setCantBanios(Integer cantBanios) {
        this.cantBanios = cantBanios;
    }

    public boolean isRestaurante() {
        return restaurante;
    }

    public void setRestaurante(boolean restaurante) {
        this.restaurante = restaurante;
    }

    @Override
    public String toString() {
        return "Camping{" +
                "cantCarpas=" + cantCarpas +
                ", cantBanios=" + cantBanios +
                ", restaurante=" + restaurante +
                ", privado=" + privado +
                ", mt2=" + mt2 +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                ", gerente='" + gerente + '\'' +
                '}';
    }
}
