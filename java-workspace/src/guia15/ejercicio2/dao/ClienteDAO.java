package guia15.ejercicio2.dao;

import guia15.ejercicio2.DatabaseConnection;
import guia15.ejercicio2.entity.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ClienteDAO {

    public void insertCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (nombre, calle, numero, codigo_postal, ciudad, pais, email) VALUES (?, ?, " +
                "?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getCalle());
            statement.setInt(3, cliente.getNumero());
            statement.setString(4, cliente.getCodigo_postal());
            statement.setString(5, cliente.getCiudad());
            statement.setString(6, cliente.getPais());
            statement.setString(7, cliente.getEmail());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    cliente.setId(generatedId);
                    System.out.println("Cliente insertado con ID: " + generatedId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET nombre = ?, calle = ?, numero = ?, codigo_postal = ?, ciudad = ?, pais = ?," +
                " email = ? WHERE id_cliente = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getCalle());
            statement.setInt(3, cliente.getNumero());
            statement.setString(4, cliente.getCodigo_postal());
            statement.setString(5, cliente.getCiudad());
            statement.setString(6, cliente.getPais());
            statement.setString(7, cliente.getEmail());
            statement.setInt(8, cliente.getId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                System.out.println("Cliente actualizado correctamente");
            } else {
                System.out.println("No se encontro el cliente con ID: " + cliente.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCliente(Cliente cliente) {
        String sql = "DELETE FROM clientes WHERE id_cliente = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, cliente.getId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                System.out.println("Cliente eliminado correctamente");
            } else {
                System.out.println("No se encontro el cliente con ID: " + cliente.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente obtenerClientePorId(int idCliente) {
        String sql = "SELECT * FROM clientes WHERE id_cliente = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idCliente);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Cliente cliente = new Cliente();

                    cliente.setId(resultSet.getInt("id_cliente"));
                    cliente.setNombre(resultSet.getString("nombre"));
                    cliente.setCalle(resultSet.getString("calle"));
                    cliente.setNumero(resultSet.getInt("numero"));
                    cliente.setCodigo_postal(resultSet.getString("codigo_postal"));
                    cliente.setCiudad(resultSet.getString("ciudad"));
                    cliente.setPais(resultSet.getString("pais"));
                    cliente.setEmail(resultSet.getString("email"));

                    return cliente;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Collection<Cliente> obtenerTodosLosClientes() {
        String sql = "SELECT * FROM clientes";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            Collection<Cliente> clientes = new ArrayList<>();

            while (resultSet.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(resultSet.getInt("id_cliente"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setCalle(resultSet.getString("calle"));
                cliente.setNumero(resultSet.getInt("numero"));
                cliente.setCodigo_postal(resultSet.getString("codigo_postal"));
                cliente.setCiudad(resultSet.getString("ciudad"));
                cliente.setPais(resultSet.getString("pais"));
                cliente.setEmail(resultSet.getString("email"));

                clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
