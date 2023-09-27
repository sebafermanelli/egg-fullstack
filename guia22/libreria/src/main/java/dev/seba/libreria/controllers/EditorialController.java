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

import dev.seba.libreria.entities.Editorial;
import dev.seba.libreria.entities.Usuario;
import dev.seba.libreria.exceptions.MyException;
import dev.seba.libreria.services.EditorialService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/editorial")
public class EditorialController {

  @Autowired
  private EditorialService editorialService;

  @GetMapping("")
  public String editoriales(Model m, HttpSession session) {
    List<Editorial> editoriales = editorialService.listarEditoriales();
    Usuario logueado = (Usuario) session.getAttribute("usuariosession");

    m.addAttribute("usuario", logueado);
    m.addAttribute("editoriales", editoriales);

    return "editoriales";
  }

  @GetMapping("/crear")
  public String crearEditorial(Model m, HttpSession session) {
    Usuario logueado = (Usuario) session.getAttribute("usuariosession");

    m.addAttribute("usuario", logueado);
    return "create/crearEditorial";
  }

  @PostMapping("/registrar")
  public String register(Model m, HttpSession session, @RequestParam(required = true) String nombre) {
    Usuario logueado = (Usuario) session.getAttribute("usuariosession");
    m.addAttribute("usuario", logueado);

    try {
      editorialService.crearEditorial(nombre);
      m.addAttribute("exito", "La editorial se creo con exito");
    } catch (MyException e) {
      m.addAttribute("error", e.getMessage());
      return this.editoriales(m, session);
    }
    return this.editoriales(m, session);
  }

  @GetMapping("/actualizar/{uuid}")
  public String update(Model m, HttpSession session, @PathVariable String uuid) {
    Editorial editorial = editorialService.obtenerEditorialPorId(uuid);
    Usuario logueado = (Usuario) session.getAttribute("usuariosession");

    m.addAttribute("usuario", logueado);
    m.addAttribute("editorial", editorial);

    return "edit/editarEditorial";
  }

  @PutMapping("/guardar/{uuid}")
  public String update(Model m, HttpSession session, @PathVariable String uuid, @RequestParam String nombre) {
    Usuario logueado = (Usuario) session.getAttribute("usuariosession");
    m.addAttribute("usuario", logueado);

    try {
      editorialService.modificarEditorial(uuid, nombre);
      m.addAttribute("exito", "La editorial se edito con exito");
    } catch (MyException e) {
      m.addAttribute("error", e.getMessage());
      return this.editoriales(m, session);
    }

    return this.editoriales(m, session);
  }

  @DeleteMapping("/eliminar/{uuid}")
  public String delete(Model m, HttpSession session, @PathVariable String uuid) {
    editorialService.eliminarEditoial(uuid);
    Usuario logueado = (Usuario) session.getAttribute("usuariosession");

    m.addAttribute("usuario", logueado);
    m.addAttribute("exito", "La editorial se elimino con exito");

    return this.editoriales(m, session);
  }
}
