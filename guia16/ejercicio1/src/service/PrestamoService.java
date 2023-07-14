package service;

import dao.ClienteDAO;
import dao.LibroDAO;
import dao.PrestamoDAO;
import entity.Cliente;
import entity.Libro;
import entity.Prestamo;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Scanner;

public class PrestamoService {
    private Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private PrestamoDAO prestamoDAO;
    private ClienteDAO clienteDAO;
    private LibroDAO libroDAO;

    public PrestamoService(PrestamoDAO prestamoDAO, ClienteDAO clienteDAO, LibroDAO libroDAO) {
        this.prestamoDAO = prestamoDAO;
        this.clienteDAO = clienteDAO;
        this.libroDAO = libroDAO;
    }

    public void generarPrestamo(Cliente cliente) {
        System.out.print("Ingrese el ISBM del Libro: ");
        long idLibro = scanner.nextLong();
        Libro libro = libroDAO.getOne(idLibro);
        if (libro == null) {
            System.out.println("ISBM incorrecto");
        } else if (!libro.getAlta()) {
            System.out.println("El libro esta dado de baja");
        } else if (libro.getEjemplares_restantes() == 0) {
            System.out.println("No quedan mas libros con el ISBM: " + libro.getIsbm());
        } else {
            Prestamo prestamo = new Prestamo();
            prestamo.setCliente(cliente);
            prestamo.setLibro(libro);
            libro.setEjemplares_restantes(libro.getEjemplares_restantes() - 1);
            libro.setEjemplares_prestados(libro.getEjemplares_prestados() + 1);
            int anio = LocalDateTime.now().getYear();
            int mes = LocalDateTime.now().getMonthValue();
            int dia = LocalDateTime.now().getDayOfMonth();
            prestamo.setFecha_prestamo(Date.valueOf(anio + "-" + mes + "-" + dia));
            prestamoDAO.create(prestamo);
            libroDAO.update(libro);
            System.out.println("Se genero un prestamo correctamente");
        }
    }

    public void devolverPrestamo(Cliente cliente) {
        if (prestamoDAO.obtenerPrestamosActivosCliente(cliente).size() == 0) {
            System.out.println("No tiene prestamos activos");
        } else {
            System.out.print("Ingrese el ID del prestamo a devolver: ");
            long idPrestamo = scanner.nextLong();
            Prestamo prestamo = prestamoDAO.getOne(idPrestamo);
            if (prestamo == null) {
                System.out.println("ID de prestamo incorrecto");
            } else if (prestamo.getFecha_devolucion() != null) {
                System.out.println("Ese prestamo ya fue devuelto");
            } else if (prestamo.getCliente() != cliente) {
                System.out.println("Ese prestamo no te pertenece");
            } else {
                int anio = LocalDateTime.now().getYear();
                int mes = LocalDateTime.now().getMonthValue();
                int dia = LocalDateTime.now().getDayOfMonth();
                prestamo.setFecha_devolucion(Date.valueOf(anio + "-" + mes + "-" + dia));
                prestamo.getLibro().setEjemplares_prestados(prestamo.getLibro().getEjemplares_prestados() - 1);
                prestamo.getLibro().setEjemplares_restantes(prestamo.getLibro().getEjemplares_restantes() + 1);
                prestamoDAO.update(prestamo);
                libroDAO.update(prestamo.getLibro());
                System.out.println("Prestamo devuelto correctamente");
            }
        }
    }

    public void prestamosActivos(Cliente cliente) {
        if (prestamoDAO.obtenerPrestamosActivosCliente(cliente).size() == 0) {
            System.out.println("No tiene prestamos activos");
        } else {
            System.out.println(cliente.getNombre() + " " + cliente.getApellido() + "(" + cliente.getId() + ")");
            System.out.println("ID - Fecha retiro - Titulo del libro");
            for (Prestamo prestamo : prestamoDAO.obtenerPrestamosActivosCliente(cliente)) {
                System.out.println(prestamo.getId() + " - " + prestamo.getFecha_prestamo() + " - " + prestamo.getLibro().getTitulo());
            }
        }
    }

    public void prestamosActivosTotales() {
        if (prestamoDAO.obtenerPrestamosActivos().size() == 0) {
            System.out.println("No hay prestamos activos");
        } else {
            System.out.println("ID - Fecha retiro - Titulo del libro");
            for (Prestamo prestamo : prestamoDAO.obtenerPrestamosActivos()) {
                System.out.println(prestamo.getId() + " - " + prestamo.getFecha_prestamo() + " - " + prestamo.getLibro().getTitulo());
            }
        }
    }
}
