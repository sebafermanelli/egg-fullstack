package dev.seba.libreria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.seba.libreria.entities.Cliente;
import dev.seba.libreria.exceptions.MyException;
import dev.seba.libreria.services.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

  @Autowired
  private ClienteService clienteService;

  @GetMapping("")
  public String clientes(Model m) {
    List<Cliente> clientes = clienteService.listarClientes();

    m.addAttribute("clientes", clientes);

    return "clientes";
  }

  @GetMapping("/crear")
  public String crearCliente() {
    return "create/crearCliente";
  }

  @PostMapping("/registrar")
  public String register(Model m, @RequestParam(required = true) String dni,
      @RequestParam(required = true) String nombre, @RequestParam(required = true) String telefono) {
    try {
      clienteService.crearCliente(dni, nombre, telefono);
      m.addAttribute("exito", "El cliente se creo con exito");
    } catch (MyException e) {
      m.addAttribute("error", e.getMessage());
      return this.clientes(m);
    }
    return this.clientes(m);
  }

  @GetMapping("/actualizar/{uuid}")
  public String update(Model m, @PathVariable String uuid) {
    Cliente cliente = clienteService.obtenerClientePorId(uuid);

    m.addAttribute("cliente", cliente);

    return "edit/editarCliente";
  }

  @PutMapping("/guardar/{uuid}")
  public String update(Model m, @PathVariable String uuid, @RequestParam String dni, @RequestParam String nombre,
      @RequestParam String telefono) {
    try {
      clienteService.modificarCliente(uuid, dni, nombre, telefono);
      m.addAttribute("exito", "El cliente se edito con exito");
    } catch (MyException e) {
      m.addAttribute("error", e.getMessage());
      return this.clientes(m);
    }

    return this.clientes(m);
  }

  @DeleteMapping("/eliminar/{uuid}")
  public String delete(Model m, @PathVariable String uuid) {
    clienteService.eliminarCliente(uuid);
    m.addAttribute("exito", "El cliente se elimino con exito");

    return this.clientes(m);
  }

}
