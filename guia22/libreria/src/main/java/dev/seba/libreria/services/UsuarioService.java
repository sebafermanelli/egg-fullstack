package dev.seba.libreria.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import dev.seba.libreria.entities.Usuario;
import dev.seba.libreria.enums.Rol;
import dev.seba.libreria.exceptions.MyException;
import dev.seba.libreria.repositories.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService implements UserDetailsService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Transactional
  public void crearUsuario(String nombre, String email, String password, String password2) throws MyException {
    this.validarUsuario(nombre, email, password, password2);

    Usuario u = new Usuario();
    u.setNombre(nombre);
    u.setEmail(email);
    u.setPassword(new BCryptPasswordEncoder().encode(password));
    u.setRol(Rol.USER);

    usuarioRepository.save(u);
  }

  public Usuario obtenerUsuarioPorId(String uuid) {
    return usuarioRepository.findById(uuid).get();
  }

  public Usuario obtenerUsuarioPorEmail(String email) {
    return usuarioRepository.buscarPorEmail(email);
  }

  private void validarUsuario(String nombre, String email, String password, String password2) throws MyException {
    if (nombre.isEmpty() || nombre == null) {
      throw new MyException("nombre must not be empty or null");
    }
    if (email.isEmpty() || email == null) {
      throw new MyException("email must not be empty or null");
    }
    if (password.isEmpty() || password == null || password.length() < 5) {
      throw new MyException("password must not be empty or null and have at least 5 characters");
    }
    if (!password.equals(password2)) {
      throw new MyException("passwords must be equals");
    }
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Usuario u = usuarioRepository.buscarPorEmail(email);

    if (u != null) {
      List<GrantedAuthority> permissions = new ArrayList<GrantedAuthority>();

      GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + u.getRol().toString());

      permissions.add(p);

      ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
      HttpSession session = attr.getRequest().getSession(true);
      session.setAttribute("usuariosession", u);

      return new User(u.getEmail(), u.getPassword(), permissions);
    } else {
      return null;
    }
  }

}
