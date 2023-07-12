package guia15.ejercicio2.entity;

import java.sql.Date;

public class Estancia {
    private int id;
    private Cliente cliente;
    private Casa casa;
    private String nombre_huesped;
    private Date fecha_desde;
    private Date fecha_hasta;

    public Estancia() {
    }

    public Estancia(Cliente cliente, Casa casa, String nombre_huesped, Date fecha_desde, Date fecha_hasta) {
        this.cliente = cliente;
        this.casa = casa;
        this.nombre_huesped = nombre_huesped;
        this.fecha_desde = fecha_desde;
        this.fecha_hasta = fecha_hasta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public String getNombre_huesped() {
        return nombre_huesped;
    }

    public void setNombre_huesped(String nombre_huesped) {
        this.nombre_huesped = nombre_huesped;
    }

    public Date getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(Date fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public Date getFecha_hasta() {
        return fecha_hasta;
    }

    public void setFecha_hasta(Date fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }

    @Override
    public String toString() {
        return "Estancia{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", casa=" + casa +
                ", huesped='" + nombre_huesped + '\'' +
                ", fecha_desde=" + fecha_desde +
                ", fecha_hasta=" + fecha_hasta +
                '}';
    }
}
