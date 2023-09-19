package dev.seba.libreria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.seba.libreria.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
