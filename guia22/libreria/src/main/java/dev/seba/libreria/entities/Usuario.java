package dev.seba.libreria.entities;

import org.hibernate.annotations.GenericGenerator;

import dev.seba.libreria.enums.Rol;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Usuario {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String uuid;

  private String nombre;
  private String email;
  private String password;

  @Enumerated(EnumType.STRING)
  private Rol rol;

  public String getEmail() {
    return email;
  }

  public String getNombre() {
    return nombre;
  }

  public String getPassword() {
    return password;
  }

  public Rol getRol() {
    return rol;
  }

  public String getUuid() {
    return uuid;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setRol(Rol rol) {
    this.rol = rol;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }
}
