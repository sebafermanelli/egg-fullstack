package service;

import dao.AutorDAO;
import dao.EditorialDAO;
import dao.LibroDAO;
import entity.Libro;

public class LibroService {
    private LibroDAO libroDAO;
    private EditorialDAO editorialDAO;
    private AutorDAO autorDAO;

    public LibroService(LibroDAO libroDAO, EditorialDAO editorialDAO, AutorDAO autorDAO) {
        this.libroDAO = libroDAO;
        this.editorialDAO = editorialDAO;
        this.autorDAO = autorDAO;
    }

    public void librosDisponibles() {
        System.out.println("ID - Titulo");
        for (Libro libro : libroDAO.obtenerLibrosDisponibles()) {
            System.out.println(libro.getIsbm() + " - " + libro.getTitulo());
        }
    }
}
