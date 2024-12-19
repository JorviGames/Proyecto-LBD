/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USER = "pupy";
    private static final String PASSWORD = "12345";
    private Connection conn = null;

    public void conectarJ() {
       ConexionJorvi();
    }

    public Connection getConnection() {
        return conn;
    }

    public void desconectar() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexión cerrada correctamente");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public void ConexionJorvi() {
        try {
            // Cargar el driver JDBC de Oracle
            Class.forName("oracle.jdbc.OracleDriver");

            // Establecer la conexión con la base de datos
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado a la base de datos");

            // Verificar si la base de datos 'LenguajeBSD' está accesible
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT 1 FROM dual");
            if (rs.next()) {
                System.out.println("La base de datos está accesible");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error, el driver JDBC no se encontró");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error, no se pudo conectar");
            e.printStackTrace();
        }
    }
}
