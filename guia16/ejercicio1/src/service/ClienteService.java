package service;

import dao.ClienteDAO;
import dao.PrestamoDAO;
import entity.Cliente;

import java.util.Scanner;

public class ClienteService {
    private Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private ClienteDAO clienteDAO;
    private PrestamoDAO prestamoDAO;

    public ClienteService(ClienteDAO clienteDAO, PrestamoDAO prestamoDAO) {
        this.clienteDAO = clienteDAO;
        this.prestamoDAO = prestamoDAO;
    }

    public void listadoClientes() {
        if (clienteDAO.getAll().size() == 0) {
            System.out.println("No hay clientes");
        } else {
            System.out.println("   DNI   - Nombre y apellido");
            for (Cliente cliente : clienteDAO.getAll()) {
                System.out.println(cliente.getId() + " - " + cliente.getNombre() + " " + cliente.getApellido());
            }
        }
    }

    public void agregarCliente() {
        System.out.print("Ingrese el DNI del cliente: ");
        long dni = scanner.nextLong();
        if (String.valueOf(dni).length() != 8) {
            System.out.println("El DNI debe tener una longitud de 8 digitos");
        } else if (clienteDAO.getOne(dni) != null) {
            System.out.println("El DNI ya esta registrado");
        } else {
            System.out.print("Ingrese el nombre: ");
            String nombre = scanner.next();
            if (nombre.length() == 0) {
                System.out.println("El nombre no puede ser vacio");
            } else {
                System.out.print("Ingrese el apellido: ");
                String apellido = scanner.next();
                if (apellido.length() == 0) {
                    System.out.println("El apellido no puede ser vacio");
                } else {
                    System.out.println("Ingrese el telefono:");
                    String telefono = scanner.next();
                    if (telefono.length() == 0) {
                        System.out.println("El telefono no puede ser vacio");
                    } else {
                        Cliente cliente = new Cliente();
                        cliente.setId(dni);
                        cliente.setNombre(nombre);
                        cliente.setApellido(apellido);
                        cliente.setTelefono(telefono);

                        clienteDAO.create(cliente);
                        System.out.println("Cliente creado con exito");
                    }
                }
            }

        }
    }

    public void eliminarCliente() {
        System.out.print("Ingrese el DNI del cliente: ");
        long dni = scanner.nextLong();
        if (String.valueOf(dni).length() != 8) {
            System.out.println("El DNI debe tener una longitud de 8 digitos");
        } else if (clienteDAO.getOne(dni) == null) {
            System.out.println("El DNI no esta registrado");
        } else if (prestamoDAO.obtenerPrestamosActivosCliente(clienteDAO.getOne(dni)).size() != 0) {
            System.out.println("El cliente tiene prestamos sin devolver");
        } else {
            Cliente cliente = clienteDAO.getOne(dni);
            clienteDAO.delete(cliente);
            System.out.println("Cliente eliminado con exito");
        }
    }
}
