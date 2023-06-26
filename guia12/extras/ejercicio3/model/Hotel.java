package guia12.extras.ejercicio3.model;

public abstract class Hotel extends Alojamiento {
    protected Integer cantHabitacionesPiso;
    protected Integer nroCamasHabitacion;
    protected Integer cantPisos;
    protected Double precioHabitacion;

    public Hotel() {
    }

    public Hotel(String nombre, String direccion, String localidad, String gerente, Integer cantHabitacionesPiso, Integer nroCamasHabitacion, Integer cantPisos, Double precioHabitacion) {
        super(nombre, direccion, localidad, gerente);
        this.cantHabitacionesPiso = cantHabitacionesPiso;
        this.nroCamasHabitacion = nroCamasHabitacion;
        this.cantPisos = cantPisos;
        this.precioHabitacion = precioHabitacion;
    }

    public Integer getCantHabitaciones() {
        return cantHabitacionesPiso;
    }

    public void setCantHabitaciones(Integer cantHabitacionesPiso) {
        this.cantHabitacionesPiso = cantHabitacionesPiso;
    }

    public Integer getNroCamas() {
        return nroCamasHabitacion;
    }

    public void setNroCamas(Integer nroCamasHabitacion) {
        this.nroCamasHabitacion = nroCamasHabitacion;
    }

    public Integer getCantPisos() {
        return cantPisos;
    }

    public void setCantPisos(Integer cantPisos) {
        this.cantPisos = cantPisos;
    }

    public Double getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(Double precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    protected abstract Double actualizarPrecioHabitacion(Double precioHabitacion);
}
