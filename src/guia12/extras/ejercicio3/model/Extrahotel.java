package guia12.extras.ejercicio3.model;

public abstract class Extrahotel extends Alojamiento {
    protected boolean privado;
    protected Integer mt2;

    public Extrahotel() {
    }

    public Extrahotel(String nombre, String direccion, String localidad, String gerente, boolean privado, Integer mt2) {
        super(nombre, direccion, localidad, gerente);
        this.privado = privado;
        this.mt2 = mt2;
    }

    public boolean isPrivado() {
        return privado;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

    public Integer getMt2() {
        return mt2;
    }

    public void setMt2(Integer mt2) {
        this.mt2 = mt2;
    }
}
