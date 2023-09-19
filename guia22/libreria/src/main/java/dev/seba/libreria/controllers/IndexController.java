package dev.seba.libreria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.seba.libreria.entities.Prestamo;
import dev.seba.libreria.services.PrestamoService;

@Controller
@RequestMapping("/")
public class IndexController {

  @Autowired
  private PrestamoService prestamoService;

  @GetMapping("/")
  public String index(Model m) {
    List<Prestamo> prestamos = prestamoService.listarPrestamosActivos();

    m.addAttribute("prestamos", prestamos);

    return "index";
  }
}
