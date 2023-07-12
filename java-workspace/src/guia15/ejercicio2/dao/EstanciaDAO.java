package guia15.ejercicio2.dao;

import guia15.ejercicio2.DatabaseConnection;
import guia15.ejercicio2.entity.Casa;
import guia15.ejercicio2.entity.Cliente;
import guia15.ejercicio2.entity.Estancia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class EstanciaDAO {

    ClienteDAO clienteDao = new ClienteDAO();
    CasaDAO casaDao = new CasaDAO();

    public void insertEstancia(Estancia estancia) {
        String sql = "INSERT INTO estancias (id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta) VALUES " +
                "(?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, estancia.getCliente().getId());
            statement.setInt(2, estancia.getCasa().getId());
            statement.setString(3, estancia.getNombre_huesped());
            statement.setDate(4, estancia.getFecha_desde());
            statement.setDate(5, estancia.getFecha_hasta());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    estancia.setId(generatedId);
                    System.out.println("Estancia insertada con ID: " + generatedId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEstancia(Estancia estancia) {
        String sql = "UPDATE estancias SET id_cliente = ?, id_casa = ?, nombre_huesped = ?, fecha_desde = ?, " +
                "fecha_hasta = ? WHERE id_estancia = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, estancia.getCliente().getId());
            statement.setInt(2, estancia.getCasa().getId());
            statement.setString(3, estancia.getNombre_huesped());
            statement.setDate(4, estancia.getFecha_desde());
            statement.setDate(5, estancia.getFecha_hasta());
            statement.setInt(6, estancia.getId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                System.out.println("Estancia actualizada correctamente");
            } else {
                System.out.println("No se encontro la estancia con ID: " + estancia.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEstancia(Estancia estancia) {
        String sql = "DELETE FROM estancias WHERE id_estancia = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, estancia.getId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                System.out.println("Estancia eliminada correctamente");
            } else {
                System.out.println("No se encontro la estancia con ID: " + estancia.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Estancia obtenerEstanciaPorId(int idEstancia) {
        String sql = "SELECT * FROM estancias WHERE id_estancia = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idEstancia);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Estancia estancia = new Estancia();

                    estancia.setId(resultSet.getInt("id_estancia"));
                    Cliente cliente = clienteDao.obtenerClientePorId(resultSet.getInt("id_cliente"));
                    estancia.setCliente(cliente);
                    Casa casa = casaDao.obtenerCasaPorId(resultSet.getInt("id_casa"));
                    estancia.setCasa(casa);
                    estancia.setNombre_huesped(resultSet.getString("nombre_huesped"));
                    estancia.setFecha_desde(resultSet.getDate("fecha_desde"));
                    estancia.setFecha_hasta(resultSet.getDate("fecha_hasta"));

                    return estancia;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Collection<Estancia> obtenerTodasLasEstancias() {
        String sql = "SELECT * FROM estancias";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            Collection<Estancia> estancias = new ArrayList<>();

            while (resultSet.next()) {
                Estancia estancia = new Estancia();

                estancia.setId(resultSet.getInt("id_estancia"));
                Cliente cliente = clienteDao.obtenerClientePorId(resultSet.getInt("id_cliente"));
                estancia.setCliente(cliente);
                Casa casa = casaDao.obtenerCasaPorId(resultSet.getInt("id_casa"));
                estancia.setCasa(casa);
                estancia.setNombre_huesped(resultSet.getString("nombre_huesped"));
                estancia.setFecha_desde(resultSet.getDate("fecha_desde"));
                estancia.setFecha_hasta(resultSet.getDate("fecha_hasta"));

                estancias.add(estancia);
            }
            return estancias;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Collection<Estancia> enunciadoE() {
        String sql = "SELECT * FROM estancias e INNER JOIN clientes c ON e.id_cliente = c.id_cliente";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            Collection<Estancia> estancias = new ArrayList<>();

            while (resultSet.next()) {
                Estancia estancia = new Estancia();

                estancia.setId(resultSet.getInt("id_estancia"));
                Cliente cliente = clienteDao.obtenerClientePorId(resultSet.getInt("id_cliente"));
                estancia.setCliente(cliente);
                Casa casa = casaDao.obtenerCasaPorId(resultSet.getInt("id_casa"));
                estancia.setCasa(casa);
                estancia.setNombre_huesped(resultSet.getString("nombre_huesped"));
                estancia.setFecha_desde(resultSet.getDate("fecha_desde"));
                estancia.setFecha_hasta(resultSet.getDate("fecha_hasta"));

                estancias.add(estancia);
            }
            return estancias;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Collection<Estancia> enunciadoF(Cliente cliente) {
        String sql = "SELECT * FROM estancias e INNER JOIN clientes c ON e.id_cliente = c.id_cliente WHERE e" +
                ".id_cliente = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, cliente.getId());

            try (ResultSet resultSet = statement.executeQuery()) {

                Collection<Estancia> estancias = new ArrayList<>();

                while (resultSet.next()) {
                    Estancia estancia = new Estancia();

                    estancia.setId(resultSet.getInt("id_estancia"));
                    estancia.setCliente(cliente);
                    Casa casa = casaDao.obtenerCasaPorId(resultSet.getInt("id_casa"));
                    estancia.setCasa(casa);
                    estancia.setNombre_huesped(resultSet.getString("nombre_huesped"));
                    estancia.setFecha_desde(resultSet.getDate("fecha_desde"));
                    estancia.setFecha_hasta(resultSet.getDate("fecha_hasta"));

                    estancias.add(estancia);
                }
                return estancias;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
