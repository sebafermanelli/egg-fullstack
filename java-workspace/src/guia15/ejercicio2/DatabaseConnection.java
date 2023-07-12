package guia15.ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DatabaseConnection {
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE = "estancias";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexión a la base de datos cerrada correctamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
