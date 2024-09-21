import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/poodesafio";
    private static final String USER = "root"; // Cambia al usuario correcto
    private static final String PASSWORD = ""; // Cambia a la contraseña correcta

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
