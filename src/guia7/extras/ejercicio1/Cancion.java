package guia7.extras.ejercicio1;

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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
}
