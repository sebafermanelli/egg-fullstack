package guia12.extras.ejercicio3.model;

public class Hotel5 extends Hotel {
    protected String gimnasio;
    protected String nombreRestaurante;
    protected Integer capacidadRestaurante;
    protected Integer cantSalonesConferencia;
    protected Integer cantSuites;
    protected Integer cantLimusinas;

    public Hotel5() {
    }

    public Hotel5(String nombre, String direccion, String localidad, String gerente, Integer cantHabitacionesPiso, Integer nroCamasHabitacion, Integer cantPisos, Double precioHabitacion, String gimnasio, String nombreRestaurante, Integer capacidadRestaurante, Integer cantSalonesConferencia, Integer cantSuites, Integer cantLimusinas) {
        super(nombre, direccion, localidad, gerente, cantHabitacionesPiso, nroCamasHabitacion, cantPisos, precioHabitacion);
        this.gimnasio = gimnasio;
        this.nombreRestaurante = nombreRestaurante;
        this.capacidadRestaurante = capacidadRestaurante;
        this.cantSalonesConferencia = cantSalonesConferencia;
        this.cantSuites = cantSuites;
        this.cantLimusinas = cantLimusinas;
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

    public Integer getCantSalonesConferencia() {
        return cantSalonesConferencia;
    }

    public void setCantSalonesConferencia(Integer cantSalonesConferencia) {
        this.cantSalonesConferencia = cantSalonesConferencia;
    }

    public Integer getCantSuites() {
        return cantSuites;
    }

    public void setCantSuites(Integer cantSuites) {
        this.cantSuites = cantSuites;
    }

    public Integer getCantLimusinas() {
        return cantLimusinas;
    }

    public void setCantLimusinas(Integer cantLimusinas) {
        this.cantLimusinas = cantLimusinas;
    }

    @Override
    public String toString() {
        return "Hotel5{" +
                "cantSalonesConferencia=" + cantSalonesConferencia +
                ", cantSuites=" + cantSuites +
                ", cantLimusinas=" + cantLimusinas +
                ", gimnasio='" + gimnasio + '\'' +
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

    protected Integer valorAgregadoLimusina() {
        if (cantLimusinas != 0) {
            return 15 * cantLimusinas;
        } else {
            return 0;
        }
    }

    @Override
    protected Double actualizarPrecioHabitacion(Double precioHabitacion) {
        return precioHabitacion + (cantHabitacionesPiso * nroCamasHabitacion * cantPisos) + (valorAgregadoRestaurante()) + (valorAgregadoGimnasio()) + (valorAgregadoLimusina());
    }
}
