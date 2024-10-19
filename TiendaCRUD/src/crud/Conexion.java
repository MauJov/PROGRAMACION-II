package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/tienda2";
    private static final String USER = "root";  // Cambia esto si tienes otro usuario
    private static final String PASS = "#MySQL2024";  // Cambia la contraseña

    public static Connection getConnection() {
        Connection conexion = null;
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver"); // Verifica que esta línea esté presente
            conexion = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver JDBC");
            e.printStackTrace();
        }
        return conexion;
    }
}
