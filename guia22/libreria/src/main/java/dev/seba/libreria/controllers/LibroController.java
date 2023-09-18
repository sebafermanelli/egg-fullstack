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

import dev.seba.libreria.entities.Autor;
import dev.seba.libreria.entities.Editorial;
import dev.seba.libreria.entities.Libro;
import dev.seba.libreria.exceptions.MyException;
import dev.seba.libreria.services.AutorService;
import dev.seba.libreria.services.EditorialService;
import dev.seba.libreria.services.LibroService;

@Controller
@RequestMapping("/libro")
public class LibroController {

  @Autowired
  private LibroService libroService;
  @Autowired
  AutorService autorService;
  @Autowired
  EditorialService editorialService;

  @GetMapping("")
  public String libros(Model m) {
    List<Libro> libros = libroService.listarLibros();

    m.addAttribute("libros", libros);

    return "libros";
  }

  @GetMapping("/crear")
  public String crearLibro() {
    return "crearLibro";
  }

  @PostMapping("/registrar")
  public String register(@RequestParam(required = true) Long isbn,
      @RequestParam(required = true) String titulo,
      @RequestParam(required = true) String nombreAutor,
      @RequestParam(required = true) String nombreEditorial,
      @RequestParam(required = true) Integer ejemplares) {
    try {
      Autor a = autorService.buscarAutorPorNombre(nombreAutor);
      String autor = a.getUuid();

      Editorial e = editorialService.buscarEditorialPorNombre(nombreEditorial);
      String editorial = e.getUuid();

      libroService.crearLibro(isbn, titulo, ejemplares, autor, editorial);
    } catch (MyException e) {
      e.printStackTrace();
      return "redirect:/libro";
    }
    return "redirect:/libro";
  }

  @GetMapping("/actualizar/{isbn}")
  public String update(Model m, @PathVariable Long isbn) {
    Libro libro = libroService.obtenerLibroPorId(isbn);

    m.addAttribute("libro", libro);

    return "editarLibro";
  }

  @PutMapping("/guardar/{isbn}")
  public String update(Model m, @PathVariable Long isbn, @RequestParam String titulo, @RequestParam Integer ejemplares,
      @RequestParam String nombreAutor, @RequestParam String nombreEditorial) {
    try {
      Autor a = autorService.buscarAutorPorNombre(nombreAutor);
      String autor = a.getUuid();

      Editorial e = editorialService.buscarEditorialPorNombre(nombreEditorial);
      String editorial = e.getUuid();

      libroService.modificarLibro(isbn, titulo, ejemplares, autor, editorial);
    } catch (MyException e) {
      e.printStackTrace();
    }

    return "redirect:/libro";
  }

  @DeleteMapping("/eliminar/{isbn}")
  public String delete(Model m, @PathVariable Long isbn) {
    libroService.eliminarLibro(isbn);

    return "redirect:/libro";
  }
}
