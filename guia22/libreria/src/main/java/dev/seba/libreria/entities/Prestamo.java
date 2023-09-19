package dev.seba.libreria.entities;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Prestamo {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String uuid;

  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaPrestamo;

  @Temporal(TemporalType.TIMESTAMP)
  @Nullable
  private Date fechaDevolucion;

  @ManyToOne
  private Libro libro;
  @ManyToOne
  private Cliente cliente;

  public Cliente getCliente() {
    return cliente;
  }

  public Date getFechaDevolucion() {
    return fechaDevolucion;
  }

  public Date getFechaPrestamo() {
    return fechaPrestamo;
  }

  public Libro getLibro() {
    return libro;
  }

  public String getUuid() {
    return uuid;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public void setFechaDevolucion(Date fechaDevolucion) {
    this.fechaDevolucion = fechaDevolucion;
  }

  public void setFechaPrestamo(Date fechaPrestamo) {
    this.fechaPrestamo = fechaPrestamo;
  }

  public void setLibro(Libro libro) {
    this.libro = libro;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

}
