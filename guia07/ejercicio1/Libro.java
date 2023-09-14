package guia07.ejercicio1;

public class Libro {

    private int isbn;
    private String titulo;
    private String autor;
    private int paginas;

    Libro() {
    }

    Libro(int isbn, String titulo, String autor, int paginas) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    public void setLibro(int isbn, String titulo, String autor, int paginas) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    public int getISBN() {
        return this.isbn;
    }

    public void setISBN(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return this.paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String toString() {
        return "Libro{isbn=" + this.isbn + ", titulo=" + this.titulo + ", autor=" + this.autor + ", cantPaginas=" + this.paginas + "}";
    }
}