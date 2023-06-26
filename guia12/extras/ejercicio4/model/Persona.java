package guia12.extras.ejercicio4.model;

public class Persona {
    protected Integer id;
    protected String nombreApellido;
    protected String estadoCivil;

    public Persona() {
    }

    public Persona(Integer id, String nombreApellido, String estadoCivil) {
        this.id = id;
        this.nombreApellido = nombreApellido;
        this.estadoCivil = estadoCivil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
