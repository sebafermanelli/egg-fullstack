import dao.*;
import entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import service.*;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    //Establecer conexion a la persistencia "default"
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private static EntityManager entityManager = emf.createEntityManager();
    //DAOs y Servicios
    private static AutorDAO autorDAO = new AutorDAO(entityManager);
    public static AutorService autorService = new AutorService(autorDAO);
    private static EditorialDAO editorialDAO = new EditorialDAO(entityManager);
    public static EditorialService editorialService = new EditorialService(editorialDAO);
    private static LibroDAO libroDAO = new LibroDAO(entityManager);
    public static LibroService libroService = new LibroService(libroDAO, editorialDAO, autorDAO);
    private static ClienteDAO clienteDAO = new ClienteDAO(entityManager);
    private static PrestamoDAO prestamoDAO = new PrestamoDAO(entityManager);
    public static ClienteService clienteService = new ClienteService(clienteDAO, prestamoDAO);
    public static PrestamoService prestamoService = new PrestamoService(prestamoDAO, clienteDAO, libroDAO);

    public static void main(String[] args) {
        //Cargar datos para tener algunos para utilizar en las consultas
        if (!(autorDAO.getAll().size() > 0) && !(editorialDAO.getAll().size() > 0) && !(libroDAO.getAll().size() > 0) &&
                !(clienteDAO.getAll().size() > 0) && !(prestamoDAO.getAll().size() > 0)) {
            cargarDatos();
        }

        //Menu
        int op;
        do {
            System.out.println("################ LIBRERIA ################");
            System.out.println("1 - Opciones de cliente");
            System.out.println("2 - Opciones de administrador");
            System.out.println("0 - Cerrar programa");
            System.out.print("Ingrese la opcion: ");
            do {
                op = scanner.nextInt();
            } while (op < 0 || op > 2);

            switch (op) {
                case 0 -> System.out.println("Cerrando programa...");
                case 1 -> {
                    System.out.println();
                    menuCliente();
                    System.out.println();
                }
                case 2 -> {
                    System.out.println();
                    System.out.print("Ingrese la contraseña: ");
                    String password = scanner.next();
                    if (password.equals("ickkck")) {
                        menuAdmin();
                    } else {
                        System.out.println("Contraseña incorrecta");
                    }
                    System.out.println();
                }
                default -> System.out.println("Ingrese una opcion valida");
            }
        } while (op != 0);

        //Cerrar conexion a la persistencia
        entityManager.close();
        emf.close();
    }

    private static void menuCliente() {
        int op;

        System.out.print("Ingrese su DNI: ");
        long idCliente = scanner.nextLong();
        Cliente cliente = clienteDAO.getOne(idCliente);
        if (cliente == null) {
            System.out.println("DNI de Cliente incorrecto");
        } else {
            do {
                System.out.println("################ " + cliente.getApellido() + " " + cliente.getNombre() + " " +
                        "################");
                System.out.println("1 - Pedir un libro");
                System.out.println("2 - Devolver un libro");
                System.out.println("3 - Consultar libros disponibles");
                System.out.println("4 - Consultar mis prestamos activos");
                System.out.println("0 - Volver al menu principal");
                System.out.print("Ingrese la opcion: ");
                do {
                    op = scanner.nextInt();
                } while (op < 0 || op > 4);

                switch (op) {
                    case 0 -> System.out.println();
                    case 1 -> {
                        System.out.println();
                        prestamoService.generarPrestamo(cliente);
                        System.out.println();
                    }
                    case 2 -> {
                        System.out.println();
                        prestamoService.devolverPrestamo(cliente);
                        System.out.println();
                    }
                    case 3 -> {
                        System.out.println();
                        libroService.librosDisponibles();
                        System.out.println();
                    }
                    case 4 -> {
                        System.out.println();
                        prestamoService.prestamosActivos(cliente);
                        System.out.println();
                    }
                    default -> System.out.println("Ingrese una opcion valida");
                }
            } while (op != 0);
        }
    }

    private static void menuAdmin() {
        int op;
        do {
            System.out.println("################ ADMINISTRADOR ################");
            System.out.println("1 - Listado de prestamos activos totales");
            System.out.println("2 - Listado prestamos activos de un cliente");
            System.out.println("3 - Listado de clientes");
            System.out.println("4 - Agregar un cliente");
            System.out.println("5 - Eliminar un cliente");
            System.out.println("0 - Volver al menu principal");
            System.out.print("Ingrese la opcion: ");
            do {
                op = scanner.nextInt();
            } while (op < 0 || op > 5);

            switch (op) {
                case 0 -> System.out.println();
                case 1 -> {
                    System.out.println();
                    prestamoService.prestamosActivosTotales();
                    System.out.println();
                }
                case 2 -> {
                    System.out.println();
                    System.out.print("Ingrese el DNI del cliente: ");
                    long idCliente = scanner.nextLong();
                    Cliente cliente = clienteDAO.getOne(idCliente);
                    if (cliente == null) {
                        System.out.println("DNI de Cliente incorrecto");
                    } else {
                        prestamoService.prestamosActivos(cliente);
                    }
                    System.out.println();
                }
                case 3 -> {
                    System.out.println();
                    clienteService.listadoClientes();
                    System.out.println();
                }
                case 4 -> {
                    System.out.println();
                    clienteService.agregarCliente();
                    System.out.println();
                }
                case 5 -> {
                    System.out.println();
                    clienteService.eliminarCliente();
                    System.out.println();
                }
                default -> System.out.println("Ingrese una opcion valida");
            }
        } while (op != 0);
    }

    public static void cargarDatos() {
        //Autores
        Autor autor1 = new Autor();
        autor1.setAlta(true);
        autor1.setNombre("J.K. Rowling");

        Autor autor2 = new Autor();
        autor2.setAlta(true);
        autor2.setNombre("Dan Brown");

        Autor autor3 = new Autor();
        autor3.setAlta(true);
        autor3.setNombre("Gabriel García Márquez");

        //Editoriales
        Editorial editorial1 = new Editorial();
        editorial1.setAlta(true);
        editorial1.setNombre("Bloomsbury");

        Editorial editorial2 = new Editorial();
        editorial2.setAlta(true);
        editorial2.setNombre("Doubleday");

        Editorial editorial3 = new Editorial();
        editorial3.setAlta(true);
        editorial3.setNombre("Sudamericana");

        Editorial editorial4 = new Editorial();
        editorial4.setAlta(true);
        editorial4.setNombre("Oveja Negra");

        //Libros
        Libro libro1 = new Libro();
        libro1.setAlta(true);
        libro1.setTitulo("Harry Potter y la piedra filosofal");
        libro1.setAnio(1997);
        libro1.setAutor(autor1);
        libro1.setEditorial(editorial1);
        libro1.setEjemplares(5);
        libro1.setEjemplares_prestados(0);
        libro1.setEjemplares_restantes(libro1.getEjemplares() - libro1.getEjemplares_prestados());

        Libro libro2 = new Libro();
        libro2.setAlta(true);
        libro2.setTitulo("El código Da Vinci");
        libro2.setAnio(2003);
        libro2.setAutor(autor2);
        libro2.setEditorial(editorial2);
        libro2.setEjemplares(8);
        libro2.setEjemplares_prestados(0);
        libro2.setEjemplares_restantes(libro2.getEjemplares() - libro2.getEjemplares_prestados());

        Libro libro3 = new Libro();
        libro3.setAlta(true);
        libro3.setTitulo("Cien años de soledad");
        libro3.setAnio(1967);
        libro3.setAutor(autor3);
        libro3.setEditorial(editorial3);
        libro3.setEjemplares(4);
        libro3.setEjemplares_prestados(0);
        libro3.setEjemplares_restantes(libro3.getEjemplares() - libro3.getEjemplares_prestados());

        Libro libro4 = new Libro();
        libro4.setAlta(true);
        libro4.setTitulo("El amor en los tiempos del cólera");
        libro4.setAnio(1985);
        libro4.setAutor(autor3);
        libro4.setEditorial(editorial4);
        libro4.setEjemplares(1);
        libro4.setEjemplares_prestados(0);
        libro4.setEjemplares_restantes(libro4.getEjemplares() - libro4.getEjemplares_prestados());

        Libro libro5 = new Libro();
        libro5.setAlta(true);
        libro5.setTitulo("Del amor y otros demonios");
        libro5.setAnio(1994);
        libro5.setAutor(autor3);
        libro5.setEditorial(editorial4);
        libro5.setEjemplares(8);
        libro5.setEjemplares_prestados(0);
        libro5.setEjemplares_restantes(libro5.getEjemplares() - libro5.getEjemplares_prestados());

        Libro libro6 = new Libro();
        libro6.setAlta(false);
        libro6.setTitulo("Crónica de una muerte anunciada");
        libro6.setAnio(1981);
        libro6.setAutor(autor3);
        libro6.setEditorial(editorial4);
        libro6.setEjemplares(3);
        libro6.setEjemplares_prestados(0);
        libro6.setEjemplares_restantes(libro6.getEjemplares() - libro6.getEjemplares_prestados());

        //Clientes
        Cliente cliente1 = new Cliente();
        cliente1.setId(43455736L);
        cliente1.setNombre("Sebastian");
        cliente1.setApellido("Fermanelli");
        cliente1.setTelefono("2322-328423");

        Cliente cliente2 = new Cliente();
        cliente2.setId(37902842L);
        cliente2.setNombre("Maria");
        cliente2.setApellido("Garcia");
        cliente2.setTelefono("2474-432357");

        Cliente cliente3 = new Cliente();
        cliente3.setId(22938445L);
        cliente3.setNombre("Juan");
        cliente3.setApellido("Lopez");
        cliente3.setTelefono("341-3892748");

        //Prestamos
        Prestamo prestamo1 = new Prestamo();
        Date fechaPrestamo1 = Date.valueOf("2020-04-03");
        prestamo1.setFecha_prestamo(fechaPrestamo1);
        Date fechaDevolucion1 = Date.valueOf("2020-04-10");
        prestamo1.setFecha_devolucion(fechaDevolucion1);
        prestamo1.setCliente(cliente1);
        prestamo1.setLibro(libro4);

        Prestamo prestamo2 = new Prestamo();
        Date fechaPrestamo2 = Date.valueOf("2023-07-08");
        prestamo2.setFecha_prestamo(fechaPrestamo2);
        Date fechaDevolucion2 = Date.valueOf("2023-07-10");
        prestamo2.setFecha_devolucion(fechaDevolucion2);
        prestamo2.setCliente(cliente3);
        prestamo2.setLibro(libro5);

        //Guardar datos
        autorDAO.create(autor1);
        autorDAO.create(autor2);
        autorDAO.create(autor3);

        editorialDAO.create(editorial1);
        editorialDAO.create(editorial2);
        editorialDAO.create(editorial3);
        editorialDAO.create(editorial4);

        libroDAO.create(libro1);
        libroDAO.create(libro2);
        libroDAO.create(libro3);
        libroDAO.create(libro4);
        libroDAO.create(libro5);
        libroDAO.create(libro6);

        clienteDAO.create(cliente1);
        clienteDAO.create(cliente2);
        clienteDAO.create(cliente3);

        prestamoDAO.create(prestamo1);
        prestamoDAO.create(prestamo2);

        System.out.println("El sistema cargo los datos correctamente");
    }
}
