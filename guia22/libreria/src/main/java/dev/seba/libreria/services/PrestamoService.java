package dev.seba.libreria.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.seba.libreria.entities.Cliente;
import dev.seba.libreria.entities.Libro;
import dev.seba.libreria.entities.Prestamo;
import dev.seba.libreria.exceptions.MyException;
import dev.seba.libreria.repositories.PrestamoRepository;
import jakarta.transaction.Transactional;

@Service
public class PrestamoService {

  @Autowired
  private PrestamoRepository prestamoRepository;
  @Autowired
  private ClienteService clienteService;
  @Autowired
  private LibroService libroService;

  @Transactional
  public void crearPrestamo(String idCliente, Long idLibro) throws MyException {
    this.validarPrestamo(idCliente, idLibro);

    Cliente c = clienteService.obtenerClientePorId(idCliente);
    Libro l = libroService.obtenerLibroPorId(idLibro);

    if (libroService.prestarLibro(idLibro)) {
      Prestamo p = new Prestamo();

      p.setFechaPrestamo(new Date());
      p.setCliente(c);
      p.setLibro(l);

      prestamoRepository.save(p);
    } else {
      throw new MyException("libro out of stock");
    }
  }

  public List<Prestamo> listarPrestamos() {
    return prestamoRepository.findAll();
  }

  public Prestamo obtenerPrestamoPorId(String uuid) {
    return prestamoRepository.findById(uuid).get();
  }

  @Transactional
  public void modificarPrestamo(String uuid) throws MyException {

    Optional<Prestamo> p = prestamoRepository.findById(uuid);

    if (p.isPresent()) {
      Prestamo prestamo = p.get();

      prestamo.setFechaDevolucion(new Date());

      libroService.devolverLibro(prestamo.getLibro().getIsbn());

      prestamoRepository.save(prestamo);
    }
  }

  @Transactional
  public void eliminarPrestamo(String uuid) {
    Optional<Prestamo> p = prestamoRepository.findById(uuid);

    if (p.isPresent()) {
      Prestamo prestamo = p.get();

      prestamoRepository.delete(prestamo);
    }
  }

  public List<Prestamo> listarPrestamosActivos() {
    return prestamoRepository.buscarPorPrestamosActivos();
  }

  public List<Prestamo> listarPrestamosDevueltos() {
    return prestamoRepository.buscarPorPrestamosDevueltos();
  }

  private void validarPrestamo(String idCliente, Long idLibro) throws MyException {
    if (idCliente.isEmpty() || idCliente == null) {
      throw new MyException("cliente must not be empty or null");
    }
    if (idLibro == null) {
      throw new MyException("libro must not be empty or null");
    }
  }
}
