package dev.seba.libreria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.seba.libreria.entities.Cliente;
import dev.seba.libreria.exceptions.MyException;
import dev.seba.libreria.repositories.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {

  @Autowired
  private ClienteRepository clienteRepository;

  @Transactional
  public void crearCliente(String dni, String nombre, String telefono) throws MyException {
    this.validarCliente(dni, nombre, telefono);

    Cliente c = new Cliente();

    c.setDni(dni);
    c.setNombre(nombre);
    c.setTelefono(telefono);

    clienteRepository.save(c);
  }

  public List<Cliente> listarClientes() {
    return clienteRepository.findAll();
  }

  public Cliente obtenerClientePorId(String uuid) {
    return clienteRepository.findById(uuid).get();
  }

  @Transactional
  public void modificarCliente(String uuid, String dni, String nombre, String telefono) throws MyException {
    this.validarCliente(dni, nombre, telefono);

    Optional<Cliente> c = clienteRepository.findById(uuid);

    if (c.isPresent()) {
      Cliente cliente = c.get();

      cliente.setDni(dni);
      cliente.setNombre(nombre);
      cliente.setTelefono(telefono);

      clienteRepository.save(cliente);
    }
  }

  @Transactional
  public void eliminarCliente(String uuid) {
    Optional<Cliente> c = clienteRepository.findById(uuid);

    if (c.isPresent()) {
      Cliente cliente = c.get();

      clienteRepository.delete(cliente);
    }
  }

  private void validarCliente(String dni, String nombre, String telefono) throws MyException {
    if (dni.isEmpty() || dni == null) {
      throw new MyException("dni must not be empty or null");
    }
    if (nombre.isEmpty() || nombre == null) {
      throw new MyException("nombre must not be empty or null");
    }
    if (telefono.isEmpty() || telefono == null) {
      throw new MyException("telefono must not be empty or null");
    }
  }
}
