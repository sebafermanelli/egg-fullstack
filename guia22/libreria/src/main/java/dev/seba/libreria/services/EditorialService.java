package dev.seba.libreria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.seba.libreria.entities.Editorial;
import dev.seba.libreria.exceptions.MyException;
import dev.seba.libreria.repositories.EditorialRepository;
import jakarta.transaction.Transactional;

@Service
public class EditorialService {

  @Autowired
  private EditorialRepository editorialRepository;

  @Transactional
  public void crearEditorial(String nombre) throws MyException {
    this.validarEditorial(nombre);

    Editorial e = new Editorial();

    e.setNombre(nombre);

    editorialRepository.save(e);
  }

  public List<Editorial> listarEditoriales() {
    return editorialRepository.findAll();
  }

  public Editorial obtenerEditorialPorId(String uuid) {
    return editorialRepository.findById(uuid).get();
  }

  @Transactional
  public void modificarEditorial(String uuid, String nombre) throws MyException {
    this.validarEditorial(nombre);

    Optional<Editorial> e = editorialRepository.findById(uuid);

    if (e.isPresent()) {
      Editorial editorial = e.get();

      editorial.setNombre(nombre);

      editorialRepository.save(editorial);
    }
  }

  public Editorial buscarEditorialPorNombre(String nombre) {
    return editorialRepository.buscarPorNombre(nombre);
  }

  @Transactional
  public void eliminarEditoial(String uuid) {
    Optional<Editorial> e = editorialRepository.findById(uuid);

    if (e.isPresent()) {
      Editorial editorial = e.get();

      editorialRepository.delete(editorial);
    }
  }

  private void validarEditorial(String nombre) throws MyException {
    if (nombre.isEmpty() || nombre == null) {
      throw new MyException("nombre must not be empty or null");
    }
  }
}
