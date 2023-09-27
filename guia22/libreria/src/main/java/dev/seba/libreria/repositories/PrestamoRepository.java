package dev.seba.libreria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.seba.libreria.entities.Prestamo;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, String> {

  @Query("SELECT p FROM Prestamo p WHERE p.fechaDevolucion = null")
  public List<Prestamo> buscarPorPrestamosActivos();

    @Query("SELECT p FROM Prestamo p WHERE p.fechaDevolucion != null")
  public List<Prestamo> buscarPorPrestamosDevueltos();
}
