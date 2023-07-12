package guia15.ejercicio2.dao;

import guia15.ejercicio2.DatabaseConnection;
import guia15.ejercicio2.entity.Casa;
import guia15.ejercicio2.entity.Familia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class FamiliaDAO {

    CasaDAO casaDao = new CasaDAO();

    public void insertFamilia(Familia familia) {
        String sql = "INSERT INTO familias (nombre, edad_minima, edad_maxima, num_hijos, email, id_casa_familia) VALUES " +
                "(?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, familia.getNombre());
            statement.setInt(2, familia.getEdad_minima());
            statement.setInt(3, familia.getEdad_maxima());
            statement.setInt(4, familia.getNum_hijos());
            statement.setString(5, familia.getEmail());
            statement.setInt(6, familia.getCasa().getId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    familia.setId(generatedId);
                    System.out.println("Familia insertada con ID: " + generatedId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFamilia(Familia familia) {
        String sql = "UPDATE familias SET nombre = ?, edad_minima = ?, edad_maxima = ?, num_hijos = ?, " +
                "email = ?, id_casa_familia = ? WHERE id_familia = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, familia.getNombre());
            statement.setInt(2, familia.getEdad_minima());
            statement.setInt(3, familia.getEdad_maxima());
            statement.setInt(4, familia.getNum_hijos());
            statement.setString(5, familia.getEmail());
            statement.setInt(6, familia.getCasa().getId());
            statement.setInt(7, familia.getId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                System.out.println("Familia actualizada correctamente");
            } else {
                System.out.println("No se encontro la familia con ID: " + familia.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFamilia(Familia familia) {
        String sql = "DELETE FROM familias WHERE id_familia = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, familia.getId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                System.out.println("Familia eliminada correctamente");
            } else {
                System.out.println("No se encontro la familia con ID: " + familia.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Familia obtenerFamiliaPorId(int idFamilia) {
        String sql = "SELECT * FROM familias WHERE id_familia = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idFamilia);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Familia familia = new Familia();

                    familia.setId(resultSet.getInt("id_familia"));
                    familia.setNombre(resultSet.getString("nombre"));
                    familia.setEdad_minima(resultSet.getInt("edad_minima"));
                    familia.setEdad_maxima(resultSet.getInt("edad_maxima"));
                    familia.setNum_hijos(resultSet.getInt("num_hijos"));
                    familia.setEmail(resultSet.getString("email"));
                    Casa casa = casaDao.obtenerCasaPorId(resultSet.getInt("id_casa_familia"));
                    familia.setCasa(casa);

                    return familia;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Collection<Familia> obtenerTodasLasEstancias() {
        String sql = "SELECT * FROM familias";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            Collection<Familia> familias = new ArrayList<>();

            while (resultSet.next()) {
                Familia familia = new Familia();

                familia.setId(resultSet.getInt("id_familia"));
                familia.setNombre(resultSet.getString("nombre"));
                familia.setEdad_minima(resultSet.getInt("edad_minima"));
                familia.setEdad_maxima(resultSet.getInt("edad_maxima"));
                familia.setNum_hijos(resultSet.getInt("num_hijos"));
                familia.setEmail(resultSet.getString("email"));
                Casa casa = casaDao.obtenerCasaPorId(resultSet.getInt("id_casa_familia"));
                familia.setCasa(casa);

                familias.add(familia);
            }
            return familias;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Collection<Familia> enunciadoA(int cantHijos, int edadMaxima) {
        String sql = "SELECT * FROM familias WHERE num_hijos >= ? AND edad_maxima < ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, cantHijos);
            statement.setInt(2, edadMaxima);

            try (ResultSet resultSet = statement.executeQuery()) {
                Collection<Familia> familias = new ArrayList<>();

                while (resultSet.next()) {
                    Familia familia = new Familia();

                    familia.setId(resultSet.getInt("id_familia"));
                    familia.setNombre(resultSet.getString("nombre"));
                    familia.setEdad_minima(resultSet.getInt("edad_minima"));
                    familia.setEdad_maxima(resultSet.getInt("edad_maxima"));
                    familia.setNum_hijos(resultSet.getInt("num_hijos"));
                    familia.setEmail(resultSet.getString("email"));
                    Casa casa = casaDao.obtenerCasaPorId(resultSet.getInt("id_casa_familia"));
                    familia.setCasa(casa);

                    familias.add(familia);
                }
                return familias;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Collection<Familia> enunciadoC(String mailContiene) {
        String sql = "SELECT * FROM familias WHERE email LIKE ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "%" + mailContiene + "%");

            try (ResultSet resultSet = statement.executeQuery()) {
                Collection<Familia> familias = new ArrayList<>();

                while (resultSet.next()) {
                    Familia familia = new Familia();

                    familia.setId(resultSet.getInt("id_familia"));
                    familia.setNombre(resultSet.getString("nombre"));
                    familia.setEdad_minima(resultSet.getInt("edad_minima"));
                    familia.setEdad_maxima(resultSet.getInt("edad_maxima"));
                    familia.setNum_hijos(resultSet.getInt("num_hijos"));
                    familia.setEmail(resultSet.getString("email"));
                    Casa casa = casaDao.obtenerCasaPorId(resultSet.getInt("id_casa_familia"));
                    familia.setCasa(casa);

                    familias.add(familia);
                }
                return familias;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
