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
import dev.seba.libreria.exceptions.MyException;
import dev.seba.libreria.services.EditorialService;

@Controller
@RequestMapping("/editorial")
public class EditorialController {

  @Autowired
  private EditorialService editorialService;

  @GetMapping("")
  public String editoriales(Model m) {
    List<Editorial> editoriales = editorialService.listarEditoriales();

    m.addAttribute("editoriales", editoriales);

    return "editoriales";
  }

  @GetMapping("/crear")
  public String crearEditorial() {
    return "crearEditorial";
  }

  @PostMapping("/registrar")
  public String register(@RequestParam(required = true) String nombre) {
    try {
      editorialService.crearEditorial(nombre);
    } catch (MyException e) {
      e.printStackTrace();
      return "redirect:/editorial";
    }
    return "redirect:/editorial";
  }

  @GetMapping("/actualizar/{uuid}")
  public String update(Model m, @PathVariable String uuid) {
    Editorial editorial = editorialService.obtenerEditorialPorId(uuid);

    m.addAttribute("editorial", editorial);

    return "editarEditorial";
  }

  @PutMapping("/guardar/{uuid}")
  public String update(Model m, @PathVariable String uuid, @RequestParam String nombre) {
    try {
      editorialService.modificarEditorial(uuid, nombre);
    } catch (MyException e) {
      e.printStackTrace();
    }

    return "redirect:/editorial";
  }

  @DeleteMapping("/eliminar/{uuid}")
  public String delete(Model m, @PathVariable String uuid) {
    editorialService.eliminarEditoial(uuid);

    return "redirect:/editorial";
  }
}
