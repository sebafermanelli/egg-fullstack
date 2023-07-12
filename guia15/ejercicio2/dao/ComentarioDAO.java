package guia15.ejercicio2.dao;

import guia15.ejercicio2.DatabaseConnection;
import guia15.ejercicio2.entity.Casa;
import guia15.ejercicio2.entity.Comentario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ComentarioDAO {

    CasaDAO casaDao = new CasaDAO();

    public void insertComentario(Comentario comentario) {
        String sql = "INSERT INTO comentarios (id_casa, comentario) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, comentario.getCasa().getId());
            statement.setString(2, comentario.getComentario());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    comentario.setId(generatedId);
                    System.out.println("Comentario insertado con ID: " + generatedId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateComentario(Comentario comentario) {
        String sql = "UPDATE comentarios SET comentario = ? WHERE id_comentario = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, comentario.getComentario());
            statement.setInt(2, comentario.getId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                System.out.println("Comentario actualizado correctamente");
            } else {
                System.out.println("No se encontro el comentario con ID: " + comentario.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteComentario(Comentario comentario) {
        String sql = "DELETE FROM comentarios WHERE id_comentario = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, comentario.getId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                System.out.println("Comentario eliminado correctamente");
            } else {
                System.out.println("No se encontro el comentario con ID: " + comentario.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Comentario obtenerComentarioPorId(int idComentario) {
        String sql = "SELECT * FROM comentarios WHERE id_comentario = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idComentario);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Comentario comentario = new Comentario();

                    comentario.setId(resultSet.getInt("id_comentario"));
                    Casa casa = casaDao.obtenerCasaPorId(resultSet.getInt("id_casa"));
                    comentario.setCasa(casa);
                    comentario.setComentario(resultSet.getString("comentario"));

                    return comentario;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Collection<Comentario> obtenerTodosLosComentarios() {
        String sql = "SELECT * FROM comentarios";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            Collection<Comentario> comentarios = new ArrayList<>();

            while (resultSet.next()) {
                Comentario comentario = new Comentario();

                comentario.setId(resultSet.getInt("id_comentario"));
                Casa casa = casaDao.obtenerCasaPorId(resultSet.getInt("id_casa"));
                comentario.setCasa(casa);
                comentario.setComentario(resultSet.getString("comentario"));

                comentarios.add(comentario);
            }
            return comentarios;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Collection<Comentario> enunciadoI(String pais) {
        String sql = "SELECT * FROM comentarios c INNER JOIN casas ca ON c.id_casa = ca.id_casa WHERE c.comentario LIKE " +
                "'%limpia%' AND ca" +
                ".pais " +
                "= ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, pais);

            try (ResultSet resultSet = statement.executeQuery()) {
                Collection<Comentario> comentarios = new ArrayList<>();

                while (resultSet.next()) {
                    Comentario comentario = new Comentario();

                    comentario.setId(resultSet.getInt("id_comentario"));
                    Casa casa = casaDao.obtenerCasaPorId(resultSet.getInt("id_casa"));
                    comentario.setCasa(casa);
                    comentario.setComentario(resultSet.getString("comentario"));

                    comentarios.add(comentario);
                }
                return comentarios;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
