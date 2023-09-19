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
  public String crearLibro(Model m) {
    List<Autor> autores = autorService.listarAutores();
    List<Editorial> editoriales = editorialService.listarEditoriales();

    m.addAttribute("autores", autores);
    m.addAttribute("editoriales", editoriales);

    return "create/crearLibro";
  }

  @PostMapping("/registrar")
  public String register(
      Model m,
      @RequestParam(required = false) Long isbn,
      @RequestParam String titulo,
      @RequestParam String idAutor,
      @RequestParam String idEditorial,
      @RequestParam(required = false) Integer ejemplares) {
    try {
      libroService.crearLibro(isbn, titulo, ejemplares, idAutor, idEditorial);
      m.addAttribute("exito", "El libro se creo con exito");
    } catch (MyException e) {
      m.addAttribute("error", e.getMessage());
      return this.libros(m);
    }
    return this.libros(m);
  }

  @GetMapping("/actualizar/{isbn}")
  public String update(Model m, @PathVariable Long isbn) {
    Libro libro = libroService.obtenerLibroPorId(isbn);
    List<Autor> autores = autorService.listarAutores();
    List<Editorial> editoriales = editorialService.listarEditoriales();

    m.addAttribute("libro", libro);
    m.addAttribute("autores", autores);
    m.addAttribute("editoriales", editoriales);

    return "edit/editarLibro";
  }

  @PutMapping("/guardar/{isbn}")
  public String update(Model m, @PathVariable Long isbn, @RequestParam String titulo, @RequestParam Integer ejemplares,
      @RequestParam String idAutor, @RequestParam String idEditorial) {
    try {
      libroService.modificarLibro(isbn, titulo, ejemplares, idAutor, idEditorial);
      m.addAttribute("exito", "El libro se edito con exito");
    } catch (MyException e) {
      m.addAttribute("error", e.getMessage());
      return this.libros(m);
    }

    return this.libros(m);
  }

  @DeleteMapping("/eliminar/{isbn}")
  public String delete(Model m, @PathVariable Long isbn) {
    libroService.eliminarLibro(isbn);
    m.addAttribute("exito", "El libro se elimino con exito");

    return this.libros(m);
  }
}
