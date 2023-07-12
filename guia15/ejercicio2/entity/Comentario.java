package guia15.ejercicio2.entity;

public class Comentario {
    private int id;
    private Casa casa;
    private String comentario;

    public Comentario() {
    }

    public Comentario(int id, Casa casa, String comentario) {
        this.id = id;
        this.casa = casa;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", casa=" + casa +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
