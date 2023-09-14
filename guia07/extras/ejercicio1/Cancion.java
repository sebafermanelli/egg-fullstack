package guia07.extras.ejercicio1;

public class Cancion {

    private String titulo, autor;

    Cancion() {
        this.titulo = "";
        this.autor = "";
    }

    Cancion(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
