package dev.seba.libreria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.seba.libreria.entities.Prestamo;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, String> {

  @Query("select p from Prestamo p where p.fechaDevolucion = null")
  public List<Prestamo> buscarPorPrestamosActivos();

    @Query("select p from Prestamo p where p.fechaDevolucion != null")
  public List<Prestamo> buscarPorPrestamosDevueltos();
}
