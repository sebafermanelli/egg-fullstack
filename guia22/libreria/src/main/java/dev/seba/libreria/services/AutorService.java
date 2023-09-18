package dev.seba.libreria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.seba.libreria.entities.Autor;
import dev.seba.libreria.exceptions.MyException;
import dev.seba.libreria.repositories.AutorRepository;
import jakarta.transaction.Transactional;

@Service
public class AutorService {

  @Autowired
  private AutorRepository autorRepository;

  @Transactional
  public void crearAutor(String nombre) throws MyException {
    this.validarAutor(nombre);

    Autor a = new Autor();

    a.setNombre(nombre);

    autorRepository.save(a);
  }

  public List<Autor> listarAutores() {
    return autorRepository.findAll();
  }

  public Autor obtenerAutorPorId(String uuid) {
    return autorRepository.findById(uuid).get();
  }

  @Transactional
  public void modificarAutor(String uuid, String nombre) throws MyException {
    this.validarAutor(nombre);

    Optional<Autor> a = autorRepository.findById(uuid);

    if (a.isPresent()) {
      Autor autor = a.get();

      autor.setNombre(nombre);

      autorRepository.save(autor);
    }
  }

  @Transactional
  public void eliminarAutor(String uuid) {
    Optional<Autor> a = autorRepository.findById(uuid);

    if (a.isPresent()) {
      Autor autor = a.get();

      autorRepository.delete(autor);
    }
  }

  public Autor buscarAutorPorNombre(String nombre) {
    return autorRepository.buscarPorNombre(nombre);
  }

  private void validarAutor(String nombre) throws MyException {
    if (nombre.isEmpty() || nombre == null) {
      throw new MyException("nombre must not be empty or null");
    }
  }
}
