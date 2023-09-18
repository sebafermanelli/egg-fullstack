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
import dev.seba.libreria.exceptions.MyException;
import dev.seba.libreria.services.AutorService;

@Controller
@RequestMapping("/autor")
public class AutorController {

  @Autowired
  private AutorService autorService;

  @GetMapping("")
  public String autores(Model m) {
    List<Autor> autores = autorService.listarAutores();

    m.addAttribute("autores", autores);

    return "autores";
  }

  @GetMapping("/crear")
  public String crearAutor() {
    return "crearAutor";
  }

  @PostMapping("/registrar")
  public String register(@RequestParam(required = true) String nombre) {
    try {
      autorService.crearAutor(nombre);
    } catch (MyException e) {
      e.printStackTrace();
      return "redirect:/autor";
    }
    return "redirect:/autor";
  }

  @GetMapping("/actualizar/{uuid}")
  public String update(Model m, @PathVariable String uuid) {
    Autor autor = autorService.obtenerAutorPorId(uuid);

    m.addAttribute("autor", autor);

    return "editarAutor";
  }

  @PutMapping("/guardar/{uuid}")
  public String update(Model m, @PathVariable String uuid, @RequestParam String nombre) {
    try {
      autorService.modificarAutor(uuid, nombre);
    } catch (MyException e) {
      e.printStackTrace();
    }

    return "redirect:/autor";
  }

  @DeleteMapping("/eliminar/{uuid}")
  public String delete(Model m, @PathVariable String uuid) {
    autorService.eliminarAutor(uuid);

    return "redirect:/autor";
  }

}
