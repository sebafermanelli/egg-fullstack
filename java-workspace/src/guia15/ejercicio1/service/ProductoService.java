package guia15.ejercicio1.service;

import guia15.ejercicio1.Main;
import guia15.ejercicio1.dao.ProductoDAO;
import guia15.ejercicio1.entity.Fabricante;
import guia15.ejercicio1.entity.Producto;

import java.util.Collection;

public class ProductoService {
    private final ProductoDAO productoDAO;
    private final FabricanteService fabricanteService;

    public ProductoService() {
        this.productoDAO = new ProductoDAO();
        this.fabricanteService = new FabricanteService();
    }

    public void insert() throws Exception {
        Producto producto = new Producto();
        System.out.print("Ingrese el codigo del producto: ");
        producto.setCodigo(Main.scanner.nextInt());
        System.out.print("Ingrese el nombre del producto: ");
        producto.setNombre(Main.scanner.next());
        System.out.print("Ingrese el precio del producto: ");
        producto.setPrecio(Main.scanner.nextDouble());
        Fabricante fabricante = fabricanteService.obtenerPorId();
        producto.setFabricante(fabricante);

        productoDAO.insert(producto);
    }

    public void update() throws Exception {
        System.out.print("Ingrese el codigo del producto: ");
        int codigo = Main.scanner.nextInt();

        Producto producto = productoDAO.getById(codigo);

        System.out.print("Ingrese el nuevo nombre del producto: ");
        producto.setNombre(Main.scanner.next());
        System.out.print("Ingrese el nuevo precio del producto: ");
        producto.setPrecio(Main.scanner.nextDouble());
        Fabricante fabricante = fabricanteService.obtenerPorId();
        producto.setFabricante(fabricante);

        productoDAO.update(producto);
    }

    public void delete() throws Exception {
        System.out.print("Ingrese el codigo del producto: ");
        int codigo = Main.scanner.nextInt();

        productoDAO.delete(codigo);
    }

    public Producto obtenerPorId() throws Exception {
        System.out.print("Ingrese el codigo del producto: ");
        int codigo = Main.scanner.nextInt();

        return productoDAO.getById(codigo);
    }

    public void mostrarPorId() throws Exception {
        System.out.print("Ingrese el codigo del producto: ");
        int codigo = Main.scanner.nextInt();

        Producto producto = productoDAO.getById(codigo);

        System.out.println("Codigo: " + producto.getCodigo() + ", Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio() + ", Fabricante: [Codigo: " + producto.getFabricante().getCodigo() + ", Nombre: " + producto.getFabricante().getNombre() + "]");
    }

    public void listar() throws Exception {
        Collection<Producto> productos = productoDAO.getAll();

        for (Producto producto : productos) {
            System.out.println("Codigo: " + producto.getCodigo() + ", Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio() + ", Fabricante: [Codigo: " + producto.getFabricante().getCodigo() + ", Nombre: " + producto.getFabricante().getNombre() + "]");
        }
    }
}
