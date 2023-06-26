package guia12.extras.ejercicio4.model;

public class Empleado extends Persona {
    protected Integer anioIncorporacion;
    protected Integer nroDespacho;

    public Empleado() {
    }

    public Empleado(Integer id, String nombreApellido, String estadoCivil, Integer anioIncorporacion, Integer nroDespacho) {
        super(id, nombreApellido, estadoCivil);
        this.anioIncorporacion = anioIncorporacion;
        this.nroDespacho = nroDespacho;
    }

    public Integer getAnioIncorporacion() {
        return anioIncorporacion;
    }

    public void setAnioIncorporacion(Integer anioIncorporacion) {
        this.anioIncorporacion = anioIncorporacion;
    }

    public Integer getNroDespacho() {
        return nroDespacho;
    }

    public void setNroDespacho(Integer nroDespacho) {
        this.nroDespacho = nroDespacho;
    }
}
