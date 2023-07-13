package service;

import dao.LibroDAO;

public class LibroService {

    private LibroDAO libroDAO;

    public LibroService(LibroDAO libroDAO) {
        this.libroDAO = libroDAO;
    }
}
