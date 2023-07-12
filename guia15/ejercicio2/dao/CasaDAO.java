package guia15.ejercicio2.dao;

import guia15.ejercicio2.DatabaseConnection;
import guia15.ejercicio2.entity.Casa;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CasaDAO {

    public void insertCasa(Casa casa) {
        String sql = "INSERT INTO casas (calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha_hasta, " +
                "tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, casa.getCalle());
            statement.setInt(2, casa.getNumero());
            statement.setString(3, casa.getCodigo_postal());
            statement.setString(4, casa.getCiudad());
            statement.setString(5, casa.getPais());
            statement.setDate(6, casa.getFecha_desde());
            statement.setDate(7, casa.getFecha_hasta());
            statement.setInt(8, casa.getTiempo_minimo());
            statement.setInt(9, casa.getTiempo_maximo());
            statement.setDouble(10, casa.getPrecio_habitacion());
            statement.setString(11, casa.getTipo_vivienda());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    casa.setId(generatedId);
                    System.out.println("Casa insertada con ID: " + generatedId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCasa(Casa casa) {
        String sql = "UPDATE casas SET calle = ?, numero = ?, codigo_postal = ?, ciudad = ?, pais = ?, fecha_desde = " +
                "?, fecha_hasta = ?, tiempo_minimo = ?, tiempo_maximo = ?, precio_habitacion = ?, tipo_vivienda = ? " +
                "WHERE id_casa = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, casa.getCalle());
            statement.setInt(2, casa.getNumero());
            statement.setString(3, casa.getCodigo_postal());
            statement.setString(4, casa.getCiudad());
            statement.setString(5, casa.getPais());
            statement.setDate(6, casa.getFecha_desde());
            statement.setDate(7, casa.getFecha_hasta());
            statement.setInt(8, casa.getTiempo_minimo());
            statement.setInt(9, casa.getTiempo_maximo());
            statement.setDouble(10, casa.getPrecio_habitacion());
            statement.setString(11, casa.getTipo_vivienda());
            statement.setInt(12, casa.getId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                System.out.println("Casa actualizada correctamente");
            } else {
                System.out.println("No se encontro la casa con ID: " + casa.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCasa(Casa casa) {
        String sql = "DELETE FROM casas WHERE id_casa = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, casa.getId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                System.out.println("Casa eliminada correctamente");
            } else {
                System.out.println("No se encontro la casa con ID: " + casa.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Casa obtenerCasaPorId(int idCasa) {
        String sql = "SELECT * FROM casas WHERE id_casa = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idCasa);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Casa casa = new Casa();

                    casa.setId(resultSet.getInt("id_casa"));
                    casa.setCalle(resultSet.getString("calle"));
                    casa.setNumero(resultSet.getInt("numero"));
                    casa.setCodigo_postal(resultSet.getString("codigo_postal"));
                    casa.setCiudad(resultSet.getString("ciudad"));
                    casa.setPais(resultSet.getString("pais"));
                    casa.setFecha_desde(resultSet.getDate("fecha_desde"));
                    casa.setFecha_hasta(resultSet.getDate("fecha_hasta"));
                    casa.setTiempo_minimo(resultSet.getInt("tiempo_minimo"));
                    casa.setTiempo_maximo(resultSet.getInt("tiempo_maximo"));
                    casa.setPrecio_habitacion(resultSet.getDouble("precio_habitacion"));
                    casa.setTipo_vivienda(resultSet.getString("tipo_vivienda"));

                    return casa;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Collection<Casa> obtenerTodasLasCasas() {
        String sql = "SELECT * FROM casas";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            Collection<Casa> casas = new ArrayList<>();

            while (resultSet.next()) {
                Casa casa = new Casa();

                casa.setId(resultSet.getInt("id_casa"));
                casa.setCalle(resultSet.getString("calle"));
                casa.setNumero(resultSet.getInt("numero"));
                casa.setCodigo_postal(resultSet.getString("codigo_postal"));
                casa.setCiudad(resultSet.getString("ciudad"));
                casa.setPais(resultSet.getString("pais"));
                casa.setFecha_desde(resultSet.getDate("fecha_desde"));
                casa.setFecha_hasta(resultSet.getDate("fecha_hasta"));
                casa.setTiempo_minimo(resultSet.getInt("tiempo_minimo"));
                casa.setTiempo_maximo(resultSet.getInt("tiempo_maximo"));
                casa.setPrecio_habitacion(resultSet.getDouble("precio_habitacion"));
                casa.setTipo_vivienda(resultSet.getString("tipo_vivienda"));

                casas.add(casa);
            }
            return casas;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Collection<Casa> enunciadoB(Date fechaDesde, Date fechaHasta, String pais) {
        String sql = "SELECT * FROM casas WHERE (? BETWEEN fecha_desde AND fecha_hasta) AND (? BETWEEN " +
                "fecha_desde AND fecha_hasta) AND pais = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDate(1, fechaDesde);
            statement.setDate(2, fechaHasta);
            statement.setString(3, pais);

            try (ResultSet resultSet = statement.executeQuery()) {

                Collection<Casa> casas = new ArrayList<>();

                while (resultSet.next()) {
                    Casa casa = new Casa();

                    casa.setId(resultSet.getInt("id_casa"));
                    casa.setCalle(resultSet.getString("calle"));
                    casa.setNumero(resultSet.getInt("numero"));
                    casa.setCodigo_postal(resultSet.getString("codigo_postal"));
                    casa.setCiudad(resultSet.getString("ciudad"));
                    casa.setPais(resultSet.getString("pais"));
                    casa.setFecha_desde(resultSet.getDate("fecha_desde"));
                    casa.setFecha_hasta(resultSet.getDate("fecha_hasta"));
                    casa.setTiempo_minimo(resultSet.getInt("tiempo_minimo"));
                    casa.setTiempo_maximo(resultSet.getInt("tiempo_maximo"));
                    casa.setPrecio_habitacion(resultSet.getDouble("precio_habitacion"));
                    casa.setTipo_vivienda(resultSet.getString("tipo_vivienda"));

                    casas.add(casa);
                }
                return casas;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Collection<Casa> enunciadoD(Date fechaDesde, int cantDias) {
        long fechaHasta = fechaDesde.getTime() + (cantDias * 86400000L);
        Date fechaHastaDate = new Date(fechaHasta);
        String sql = "SELECT * FROM casas WHERE (? BETWEEN fecha_desde AND fecha_hasta) AND (? BETWEEN " +
                "fecha_desde AND fecha_hasta)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDate(1, fechaDesde);
            statement.setDate(2, fechaHastaDate);

            try (ResultSet resultSet = statement.executeQuery()) {

                Collection<Casa> casas = new ArrayList<>();

                while (resultSet.next()) {
                    Casa casa = new Casa();

                    casa.setId(resultSet.getInt("id_casa"));
                    casa.setCalle(resultSet.getString("calle"));
                    casa.setNumero(resultSet.getInt("numero"));
                    casa.setCodigo_postal(resultSet.getString("codigo_postal"));
                    casa.setCiudad(resultSet.getString("ciudad"));
                    casa.setPais(resultSet.getString("pais"));
                    casa.setFecha_desde(resultSet.getDate("fecha_desde"));
                    casa.setFecha_hasta(resultSet.getDate("fecha_hasta"));
                    casa.setTiempo_minimo(resultSet.getInt("tiempo_minimo"));
                    casa.setTiempo_maximo(resultSet.getInt("tiempo_maximo"));
                    casa.setPrecio_habitacion(resultSet.getDouble("precio_habitacion"));
                    casa.setTipo_vivienda(resultSet.getString("tipo_vivienda"));

                    casas.add(casa);
                }
                return casas;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void enunciadoG(double porcentaje, String pais) {
        String sql = "UPDATE casas SET precio_habitacion = (precio_habitacion * ?) WHERE pais = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDouble(1, 1 + (porcentaje * 0.01));
            statement.setString(2, pais);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected != 0) {
                System.out.println("Casas actualizadas correctamente");
            } else {
                System.out.println("No se encontraron casas con el pais: " + pais);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> enunciadoH() {
        String sql = "SELECT pais, COUNT(*) FROM casas GROUP BY pais";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            Map<String, Integer> countCasasPorPais = new HashMap<>();

            while (resultSet.next()) {
                countCasasPorPais.put(resultSet.getString(1), resultSet.getInt(2));
            }
            return countCasasPorPais;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean enunciadoJ(Date fechaDesde, Date fechaHasta, Casa casa) {
        String sql = "SELECT * FROM casas WHERE (? BETWEEN fecha_desde AND fecha_hasta) AND (? BETWEEN " +
                "fecha_desde AND fecha_hasta) AND id_casa = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDate(1, fechaDesde);
            statement.setDate(2, fechaHasta);
            statement.setInt(3, casa.getId());

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
