package dev.seba.libreria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.seba.libreria.exceptions.MyException;
import dev.seba.libreria.services.UsuarioService;

@Controller
@RequestMapping("/")
public class IndexController {

  @Autowired
  private UsuarioService usuarioService;

  @GetMapping("/")
  public String index(Model m) {
    return "index";
  }

  @GetMapping("/register")
  public String register(Model m) {
    return "registro";
  }

  @GetMapping("/login")
  public String login(Model m, @RequestParam(required = false) String error) {
    if (error != null) {
      m.addAttribute("error", "Email o contraseña invalidos");
    }

    return "login";
  }

  @PostMapping("/register")
  public String sendRegister(Model m, @RequestParam String nombre, @RequestParam String email,
      @RequestParam String password, @RequestParam String password2) {
    try {
      usuarioService.crearUsuario(nombre, email, password, password2);
      m.addAttribute("exito", "El usuario se registro con exito");
      return this.index(m);
    } catch (MyException e) {
      m.addAttribute("nombre", nombre);
      m.addAttribute("email", email);
      m.addAttribute("password", password);
      m.addAttribute("password2", password2);
      m.addAttribute("error", e.getMessage());
      return this.register(m);
    }
  }
}
