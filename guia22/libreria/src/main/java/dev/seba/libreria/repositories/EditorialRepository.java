package dev.seba.libreria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.seba.libreria.entities.Editorial;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, String> {

  @Query("SELECT e FROM Editorial e WHERE e.nombre = :nombre")
  public Editorial buscarPorNombre(@Param("nombre") String nombre);
}
