package guia12.extras.ejercicio4.model;

public class PersonalServicio extends Empleado {
    protected String sector;

    public PersonalServicio() {
    }

    public PersonalServicio(Integer id, String nombreApellido, String estadoCivil, Integer anioIncorporacion, Integer nroDespacho, String sector) {
        super(id, nombreApellido, estadoCivil, anioIncorporacion, nroDespacho);
        this.sector = sector;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}
