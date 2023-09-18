package dev.seba.libreria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.seba.libreria.entities.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, String> {

  @Query("SELECT a FROM Autor a WHERE a.nombre = :nombre")
  public Autor buscarPorNombre(@Param("nombre") String nombre);
}
