package guia12.extras.ejercicio3.model;

public class Hotel4 extends Hotel {
    protected String gimnasio;
    protected String nombreRestaurante;
    protected Integer capacidadRestaurante;

    public Hotel4() {
    }

    public Hotel4(String nombre, String direccion, String localidad, String gerente, Integer cantHabitacionesPiso, Integer nroCamasHabitacion, Integer cantPisos, Double precioHabitacion, String gimnasio, String nombreRestaurante, Integer capacidadRestaurante) {
        super(nombre, direccion, localidad, gerente, cantHabitacionesPiso, nroCamasHabitacion, cantPisos, precioHabitacion);
        this.gimnasio = gimnasio;
        this.nombreRestaurante = nombreRestaurante;
        this.capacidadRestaurante = capacidadRestaurante;
        this.precioHabitacion = actualizarPrecioHabitacion(precioHabitacion);
    }

    public String getGimnasio() {
        return gimnasio;
    }

    public void setGimnasio(String gimnasio) {
        this.gimnasio = gimnasio;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public Integer getCapacidadRestaurante() {
        return capacidadRestaurante;
    }

    public void setCapacidadRestaurante(Integer capacidadRestaurante) {
        this.capacidadRestaurante = capacidadRestaurante;
    }

    @Override
    public String toString() {
        return "Hotel4{" +
                "gimnasio='" + gimnasio + '\'' +
                ", nombreRestaurante='" + nombreRestaurante + '\'' +
                ", capacidadRestaurante=" + capacidadRestaurante +
                ", cantHabitacionesPiso=" + cantHabitacionesPiso +
                ", nroCamasHabitacion=" + nroCamasHabitacion +
                ", cantPisos=" + cantPisos +
                ", precioHabitacion=" + precioHabitacion +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                ", gerente='" + gerente + '\'' +
                '}';
    }

    protected Integer valorAgregadoRestaurante() {
        if (capacidadRestaurante < 30) {
            return 10;
        } else if (capacidadRestaurante <= 50) {
            return 30;
        } else {
            return 50;
        }
    }

    protected Integer valorAgregadoGimnasio() {
        if (gimnasio.equals("A")) {
            return 50;
        } else {
            return 30;
        }
    }

    @Override
    protected Double actualizarPrecioHabitacion(Double precioHabitacion) {
        return precioHabitacion + (cantHabitacionesPiso * nroCamasHabitacion * cantPisos) + (valorAgregadoRestaurante()) + (valorAgregadoGimnasio());
    }
}
