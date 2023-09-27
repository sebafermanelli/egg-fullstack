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
import dev.seba.libreria.entities.Usuario;
import dev.seba.libreria.exceptions.MyException;
import dev.seba.libreria.services.ClienteService;
import dev.seba.libreria.services.LibroService;
import dev.seba.libreria.services.PrestamoService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/prestamo")
public class PrestamoController {

  @Autowired
  private PrestamoService prestamoService;
  @Autowired
  ClienteService clienteService;
  @Autowired
  LibroService libroService;

  @GetMapping("")
  public String prestamos(Model m, HttpSession session) {
    List<Prestamo> prestamos = prestamoService.listarPrestamosDevueltos();
    Usuario logueado = (Usuario) session.getAttribute("usuariosession");

    m.addAttribute("usuario", logueado);
    m.addAttribute("prestamos", prestamos);

    return "prestamos";
  }

  @GetMapping("/activos")
  public String index(Model m, HttpSession session) {
    List<Prestamo> prestamos = prestamoService.listarPrestamosActivos();
    Usuario logueado = (Usuario) session.getAttribute("usuariosession");

    m.addAttribute("usuario", logueado);
    m.addAttribute("prestamos", prestamos);

    return "prestamosActivos";
  }

  @GetMapping("/crear")
  public String crearPrestamo(Model m, HttpSession session) {
    List<Cliente> clientes = clienteService.listarClientes();
    List<Libro> libros = libroService.listarLibros();
    Usuario logueado = (Usuario) session.getAttribute("usuariosession");

    m.addAttribute("usuario", logueado);
    m.addAttribute("clientes", clientes);
    m.addAttribute("libros", libros);

    return "create/crearPrestamo";
  }

  @PostMapping("/registrar")
  public String register(
      Model m, @RequestParam String idCliente, @RequestParam Long idLibro, HttpSession session) {
    Usuario logueado = (Usuario) session.getAttribute("usuariosession");
    m.addAttribute("usuario", logueado);

    try {
      prestamoService.crearPrestamo(idCliente, idLibro);
      m.addAttribute("exito", "El prestamo se creo con exito");
    } catch (MyException e) {
      m.addAttribute("error", e.getMessage());
      return this.index(m, session);
    }
    return this.index(m, session);
  }

  @PutMapping("/devolver/{uuid}")
  public String update(Model m, @PathVariable String uuid, HttpSession session) {
    Usuario logueado = (Usuario) session.getAttribute("usuariosession");
    m.addAttribute("usuario", logueado);

    try {
      prestamoService.modificarPrestamo(uuid);
      m.addAttribute("exito", "El prestamo se devolvio con exito");
    } catch (MyException e) {
      m.addAttribute("error", e.getMessage());
      return this.prestamos(m, session);
    }

    return this.index(m, session);
  }

  @DeleteMapping("/eliminar/{uuid}")
  public String delete(Model m, @PathVariable String uuid, HttpSession session) {
    prestamoService.eliminarPrestamo(uuid);
    Usuario logueado = (Usuario) session.getAttribute("usuariosession");

    m.addAttribute("usuario", logueado);
    m.addAttribute("exito", "El prestamo se elimino con exito");

    return this.prestamos(m, session);
  }
}
