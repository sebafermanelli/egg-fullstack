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
import dev.seba.libreria.entities.Usuario;
import dev.seba.libreria.exceptions.MyException;
import dev.seba.libreria.services.AutorService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/autor")
public class AutorController {

  @Autowired
  private AutorService autorService;

  @GetMapping("")
  public String autores(Model m, HttpSession session) {
    List<Autor> autores = autorService.listarAutores();
    Usuario logueado = (Usuario) session.getAttribute("usuariosession");

    m.addAttribute("usuario", logueado);
    m.addAttribute("autores", autores);

    return "autores";
  }

  @GetMapping("/crear")
  public String crearAutor(Model m, HttpSession session) {
    Usuario logueado = (Usuario) session.getAttribute("usuariosession");

    m.addAttribute("usuario", logueado);
    return "create/crearAutor";
  }

  @PostMapping("/registrar")
  public String register(Model m, HttpSession session, @RequestParam(required = true) String nombre) {
    Usuario logueado = (Usuario) session.getAttribute("usuariosession");
    m.addAttribute("usuario", logueado);

    try {
      autorService.crearAutor(nombre);
      m.addAttribute("exito", "El autor se creo con exito");
    } catch (MyException e) {
      m.addAttribute("error", e.getMessage());
      return this.autores(m, session);
    }
    return this.autores(m, session);
  }

  @GetMapping("/actualizar/{uuid}")
  public String update(Model m, HttpSession session, @PathVariable String uuid) {
    Autor autor = autorService.obtenerAutorPorId(uuid);
    Usuario logueado = (Usuario) session.getAttribute("usuariosession");

    m.addAttribute("usuario", logueado);
    m.addAttribute("autor", autor);

    return "edit/editarAutor";
  }

  @PutMapping("/guardar/{uuid}")
  public String update(Model m, HttpSession session, @PathVariable String uuid, @RequestParam String nombre) {
    Usuario logueado = (Usuario) session.getAttribute("usuariosession");
    m.addAttribute("usuario", logueado);

    try {
      autorService.modificarAutor(uuid, nombre);
      m.addAttribute("exito", "El autor se edito con exito");
    } catch (MyException e) {
      m.addAttribute("error", e.getMessage());
      return this.autores(m, session);
    }

    return this.autores(m, session);
  }

  @DeleteMapping("/eliminar/{uuid}")
  public String delete(Model m, HttpSession session, @PathVariable String uuid) {
    autorService.eliminarAutor(uuid);
    Usuario logueado = (Usuario) session.getAttribute("usuariosession");

    m.addAttribute("usuario", logueado);
    m.addAttribute("exito", "El autor se elimino con exito");

    return this.autores(m, session);
  }

}
