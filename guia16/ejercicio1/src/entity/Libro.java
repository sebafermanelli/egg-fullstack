package entity;

import jakarta.persistence.*;

@Entity
public class Libro {
    @GeneratedValue
    @Id
    private Long isbm;

    public Long getIsbm() {
        return isbm;
    }

    public void setIsbm(Long isbm) {
        this.isbm = isbm;
    }

    @Basic
    private String titulo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    private Integer anio;

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    @Basic
    private Integer ejemplares;

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    @Basic
    private Integer ejemplares_prestados;

    public Integer getEjemplares_prestados() {
        return ejemplares_prestados;
    }

    public void setEjemplares_prestados(Integer ejemplares_prestados) {
        this.ejemplares_prestados = ejemplares_prestados;
    }

    @Basic
    private Integer ejemplares_restantes;

    public Integer getEjemplares_restantes() {
        return ejemplares_restantes;
    }

    public void setEjemplares_restantes(Integer ejemplares_restantes) {
        this.ejemplares_restantes = ejemplares_restantes;
    }

    @Basic
    private Boolean alta;

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    @ManyToOne
    private Autor autor;

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @ManyToOne
    private Editorial editorial;

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
}
