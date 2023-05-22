package guia11.ejercicio2.model;

public class Jugador {
    private Integer id;
    private String nombre;
    private boolean muerto = false;

    public Jugador() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isMuerto() {
        return muerto;
    }

    public void setMuerto(boolean muerto) {
        this.muerto = muerto;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", muerto=" + muerto +
                '}';
    }

    public boolean disparo(Revolver r) {
        if (!r.disparar()) {
            r.siguieteDisparo();
        }
        else {
            setMuerto(true);
        }

        return this.isMuerto();
    }
}
