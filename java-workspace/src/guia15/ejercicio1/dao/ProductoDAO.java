package guia15.ejercicio1.dao;

import guia15.ejercicio1.entity.Fabricante;
import guia15.ejercicio1.entity.Producto;

import java.util.ArrayList;
import java.util.Collection;

public final class ProductoDAO extends DAO {

    private final FabricanteDAO fabricanteDAO;

    public ProductoDAO() {
        this.fabricanteDAO = new FabricanteDAO();
    }

    public void insert(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe ingresar un producto");
            }
            String sql = "INSERT INTO producto (codigo, nombre, precio, codigo_fabricante) VALUES (" + producto.getCodigo() + ", '" + producto.getNombre() + "', " + producto.getPrecio() + ", " + producto.getFabricante().getCodigo() + ")";
            insertarModificarEliminar(sql);
            desconectarBase();
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }

    public void update(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe ingresar un producto");
            }
            String sql = "UPDATE producto SET nombre='" + producto.getNombre() + "', precio=" + producto.getPrecio() + ", codigo_fabricante=" + producto.getFabricante().getCodigo() + " WHERE codigo=" + producto.getCodigo();
            insertarModificarEliminar(sql);
            desconectarBase();
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }

    public void delete(int codigo) throws Exception {
        try {
            String sql = "DELETE FROM producto WHERE codigo=" + codigo;
            insertarModificarEliminar(sql);
            desconectarBase();
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }

    public Producto getById(int codigo) throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE codigo = " + codigo;
            consultarBase(sql);

            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                int codigo_fabricante = resultado.getInt(4);
                Fabricante fabricante = fabricanteDAO.getById(codigo_fabricante);
                producto.setFabricante(fabricante);
            }
            desconectarBase();

            return producto;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }

    public Collection<Producto> getAll() throws Exception {
        try {
            String sql = "SELECT * FROM producto";
            consultarBase(sql);

            Collection<Producto> productos = new ArrayList<Producto>();
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                int codigo_fabricante = resultado.getInt(4);
                Fabricante fabricante = fabricanteDAO.getById(codigo_fabricante);
                producto.setFabricante(fabricante);
                productos.add(producto);
            }
            desconectarBase();

            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }
}
