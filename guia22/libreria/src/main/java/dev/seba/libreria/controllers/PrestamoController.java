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
import dev.seba.libreria.entities.Libro;
import dev.seba.libreria.entities.Prestamo;
import dev.seba.libreria.exceptions.MyException;
import dev.seba.libreria.services.ClienteService;
import dev.seba.libreria.services.LibroService;
import dev.seba.libreria.services.PrestamoService;

@Controller
@RequestMapping("/prestamo")
public class PrestamoController {

  @Autowired
  private PrestamoService prestamoService;
  @Autowired
  ClienteService clienteService;
  @Autowired
  LibroService libroService;
  @Autowired
  IndexController indexController;

  @GetMapping("")
  public String prestamos(Model m) {
    List<Prestamo> prestamos = prestamoService.listarPrestamosDevueltos();

    m.addAttribute("prestamos", prestamos);

    return "prestamos";
  }

  @GetMapping("/crear")
  public String crearPrestamo(Model m) {
    List<Cliente> clientes = clienteService.listarClientes();
    List<Libro> libros = libroService.listarLibros();

    m.addAttribute("clientes", clientes);
    m.addAttribute("libros", libros);

    return "create/crearPrestamo";
  }

  @PostMapping("/registrar")
  public String register(
      Model m,
      @RequestParam String idCliente,
      @RequestParam Long idLibro) {
    try {
      prestamoService.crearPrestamo(idCliente, idLibro);
      m.addAttribute("exito", "El prestamo se creo con exito");
    } catch (MyException e) {
      m.addAttribute("error", e.getMessage());
      return indexController.index(m);
    }
    return indexController.index(m);
  }

  @PutMapping("/devolver/{uuid}")
  public String update(Model m, @PathVariable String uuid) {
    try {
      prestamoService.modificarPrestamo(uuid);
      m.addAttribute("exito", "El prestamo se devolvio con exito");
    } catch (MyException e) {
      m.addAttribute("error", e.getMessage());
      return this.prestamos(m);
    }

    return indexController.index(m);
  }

  @DeleteMapping("/eliminar/{uuid}")
  public String delete(Model m, @PathVariable String uuid) {
    prestamoService.eliminarPrestamo(uuid);
    m.addAttribute("exito", "El prestamo se elimino con exito");

    return this.prestamos(m);
  }
}
