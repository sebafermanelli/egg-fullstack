package dev.seba.libreria.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.seba.libreria.entities.Autor;
import dev.seba.libreria.entities.Editorial;
import dev.seba.libreria.entities.Libro;
import dev.seba.libreria.exceptions.MyException;
import dev.seba.libreria.repositories.AutorRepository;
import dev.seba.libreria.repositories.EditorialRepository;
import dev.seba.libreria.repositories.LibroRepository;
import jakarta.transaction.Transactional;

@Service
public class LibroService {

  @Autowired
  private LibroRepository libroRepository;
  @Autowired
  private AutorRepository autorRepository;
  @Autowired
  private EditorialRepository editorialRepository;

  @Transactional
  public void crearLibro(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial)
      throws MyException {
    this.validarLibro(isbn, titulo, ejemplares, idAutor, idEditorial);

    Libro l = new Libro();
    Autor a = autorRepository.findById(idAutor).get();
    Editorial e = editorialRepository.findById(idEditorial).get();

    l.setIsbn(isbn);
    l.setTitulo(titulo);
    l.setEjemplares(ejemplares);
    l.setPrestados(0);
    l.setAlta(new Date());

    l.setAutor(a);
    l.setEditorial(e);

    libroRepository.save(l);
  }

  public List<Libro> listarLibros() {
    return libroRepository.findAll();
  }

  public Libro obtenerLibroPorId(Long isbn) {
    return libroRepository.findById(isbn).get();
  }

  @Transactional
  public void modificarLibro(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial)
      throws MyException {
    this.validarLibro(isbn, titulo, ejemplares, idAutor, idEditorial);

    Optional<Libro> l = libroRepository.findById(isbn);
    Optional<Autor> a = autorRepository.findById(idAutor);
    Optional<Editorial> e = editorialRepository.findById(idEditorial);

    if (l.isPresent() && a.isPresent() && e.isPresent()) {
      Libro libro = l.get();
      Autor autor = a.get();
      Editorial editorial = e.get();

      libro.setTitulo(titulo);
      libro.setEjemplares(ejemplares);
      libro.setAutor(autor);
      libro.setEditorial(editorial);

      libroRepository.save(libro);
    }
  }

  @Transactional
  public void eliminarLibro(Long isbn) {
    Optional<Libro> l = libroRepository.findById(isbn);

    if (l.isPresent()) {
      Libro libro = l.get();

      libroRepository.delete(libro);
    }
  }

  private void validarLibro(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial)
      throws MyException {
    if (isbn == null) {
      throw new MyException("isbn must not be null");
    }
    if (titulo.isEmpty() || titulo == null) {
      throw new MyException("titulo must not be empty or null");
    }
    if (ejemplares == null) {
      throw new MyException("ejemplares must not be null");
    }
    if (idAutor.isEmpty() || idAutor == null) {
      throw new MyException("idAutor must not be empty or null");
    }
    if (idEditorial.isEmpty() || idEditorial == null) {
      throw new MyException("idEditorial must not be empty or null");
    }
  }
}
