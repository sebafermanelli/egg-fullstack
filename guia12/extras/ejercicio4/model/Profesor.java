package guia12.extras.ejercicio4.model;

public class Profesor extends Empleado {
    protected String materia;

    public Profesor() {
    }

    public Profesor(Integer id, String nombreApellido, String estadoCivil, Integer anioIncorporacion, Integer nroDespacho, String materia) {
        super(id, nombreApellido, estadoCivil, anioIncorporacion, nroDespacho);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
