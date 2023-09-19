package dev.seba.libreria.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Libro {
  @Id
  private long isbn;

  private String titulo;

  private Integer ejemplares;

  private Integer prestados;

  @ManyToOne
  private Autor autor;
  @ManyToOne
  private Editorial editorial;

  public Libro() {

  }

  public Autor getAutor() {
    return autor;
  }

  public Editorial getEditorial() {
    return editorial;
  }

  public Integer getEjemplares() {
    return ejemplares;
  }

  public long getIsbn() {
    return isbn;
  }

  public Integer getPrestados() {
    return prestados;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setAutor(Autor autor) {
    this.autor = autor;
  }

  public void setEditorial(Editorial editorial) {
    this.editorial = editorial;
  }

  public void setEjemplares(Integer ejemplares) {
    this.ejemplares = ejemplares;
  }

  public void setIsbn(long isbn) {
    this.isbn = isbn;
  }

  public void setPrestados(Integer prestados) {
    this.prestados = prestados;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
}
