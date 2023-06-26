package guia12.extras.ejercicio4.model;

public class Estudiante extends Persona {
    protected String curso;

    public Estudiante() {
    }

    public Estudiante(Integer id, String nombreApellido, String estadoCivil, String curso) {
        super(id, nombreApellido, estadoCivil);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
