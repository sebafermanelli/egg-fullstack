package guia15.ejercicio1.dao;

import guia15.ejercicio1.entity.Fabricante;

import java.util.ArrayList;
import java.util.Collection;

public final class FabricanteDAO extends DAO {

    public void insert(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe ingresar un fabricante");
            }
            String sql = "INSERT INTO fabricante (codigo, nombre) VALUES (" + fabricante.getCodigo() + ", '" + fabricante.getNombre() + "')";
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

    public void update(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe ingresar un fabricante");
            }
            String sql = "UPDATE fabricante SET nombre='" + fabricante.getNombre() + "' WHERE codigo=" + fabricante.getCodigo();
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
            String sql = "DELETE FROM fabricante WHERE codigo=" + codigo;
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

    public Fabricante getById(int codigo) throws Exception {
        try {
            String sql = "SELECT * FROM fabricante WHERE codigo = " + codigo;
            consultarBase(sql);

            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
            }
            desconectarBase();

            return fabricante;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }

    public Collection<Fabricante> getAll() throws Exception {
        try {
            String sql = "SELECT * FROM fabricante";
            consultarBase(sql);

            Collection<Fabricante> fabricantes = new ArrayList<Fabricante>();
            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));

                fabricantes.add(fabricante);
            }
            desconectarBase();

            return fabricantes;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }
}
