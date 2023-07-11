package guia15.ejercicio1.service;

import guia15.ejercicio1.Main;
import guia15.ejercicio1.dao.FabricanteDAO;
import guia15.ejercicio1.entity.Fabricante;

import java.util.Collection;

public class FabricanteService {

    private final FabricanteDAO fabricanteDAO;

    public FabricanteService() {
        this.fabricanteDAO = new FabricanteDAO();
    }

    public void insert() throws Exception {
        Fabricante fabricante = new Fabricante();
        System.out.print("Ingrese el codigo del fabricante: ");
        fabricante.setCodigo(Main.scanner.nextInt());
        System.out.print("Ingrese el nombre del fabricante: ");
        fabricante.setNombre(Main.scanner.next());

        fabricanteDAO.insert(fabricante);
    }

    public void update() throws Exception {
        System.out.print("Ingrese el codigo del fabricante: ");
        int codigo = Main.scanner.nextInt();

        Fabricante fabricante = fabricanteDAO.getById(codigo);

        System.out.print("Ingrese el nuevo nombre del fabricante: ");
        fabricante.setNombre(Main.scanner.next());

        fabricanteDAO.update(fabricante);
    }

    public void delete() throws Exception {
        System.out.print("Ingrese el codigo del fabricante: ");
        int codigo = Main.scanner.nextInt();

        fabricanteDAO.delete(codigo);
    }

    public Fabricante obtenerPorId() throws Exception {
        System.out.print("Ingrese el codigo del fabricante: ");
        int codigo = Main.scanner.nextInt();

        return fabricanteDAO.getById(codigo);
    }

    public void mostrarPorId() throws Exception {
        System.out.print("Ingrese el codigo del fabricante: ");
        int codigo = Main.scanner.nextInt();

        Fabricante fabricante = fabricanteDAO.getById(codigo);

        System.out.println("Codigo: " + fabricante.getCodigo() + ", Nombre: " + fabricante.getNombre());
    }

    public void listar() throws Exception {
        Collection<Fabricante> fabricantes = fabricanteDAO.getAll();

        for (Fabricante fabricante : fabricantes) {
            System.out.println("Codigo: " + fabricante.getCodigo() + ", Nombre: " + fabricante.getNombre());
        }
    }
}
