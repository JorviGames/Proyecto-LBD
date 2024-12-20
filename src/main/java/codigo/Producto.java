/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

import baseDatos.DatabaseConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class Producto {

    private Connection conn;

    public Producto(Connection conn) {
        this.conn = conn;
    }

    // Método para agregar un producto
    public boolean agregarProducto(int codProducto, String nombre, double precio, int stock) {
    String sql = "{CALL AgregarProducto(?, ?, ?, ?)}"; // Llamada al procedimiento almacenado
    
    try (CallableStatement stmt = conn.prepareCall(sql)) {
        // Establecer los valores de los parámetros del procedimiento
        stmt.setInt(1, codProducto);
        stmt.setString(2, nombre);
        stmt.setDouble(3, precio);
        stmt.setInt(4, stock);

        // Ejecutar el procedimiento almacenado
        int rowsAffected = stmt.executeUpdate(); // Ejecuta el procedimiento
        return rowsAffected > 0; // Si se afectaron filas, la inserción fue exitosa
    } catch (SQLException e) {
        e.printStackTrace();  // Imprimir el error en el log
        return false;
    }
}


    // Método para editar un producto
    public boolean editarProducto(int codProducto, String nombre, String imagen, double precio, int stock) {
        // Llamada al procedimiento almacenado en lugar de la consulta SQL directa
        String sql = "{call sp_actualizar_producto(?, ?, ?, ?, ?)}";

        try (CallableStatement stmt = conn.prepareCall(sql)) {
            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, codProducto);       // ID del producto
            stmt.setString(2, nombre);         // Nombre del producto
            stmt.setString(3, imagen);         // Imagen del producto
            stmt.setDouble(4, precio);         // Precio del producto
            stmt.setInt(5, stock);             // Stock del producto

            // Ejecutar el procedimiento almacenado
            int rowsAffected = stmt.executeUpdate();

            // Si la actualización afecta filas, se considera exitosa
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();  // Imprimir el error en el log
            return false;
        }
    }

    // Método para eliminar un producto
    public boolean eliminarProducto(int codProducto) {
        String sql = "{CALL EliminarProducto(?)}";  // Llamamos al procedimiento almacenado

        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, codProducto);  // Establecer el valor del código del producto
            int rowsAffected = stmt.executeUpdate();  // Ejecutar la llamada al procedimiento
            return rowsAffected > 0;  // Retorna true si se eliminó al menos una fila
        } catch (SQLException e) {
            // No se lanza la excepción, solo se captura y se devuelve false
            System.out.println("Error al eliminar el producto: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener productos y llenar una tabla
    public DefaultTableModel ObtenerProductos() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Código Producto", "Nombre", "Precio", "Stock"}, 0);
        String sql = "SELECT cod_producto, nombre, imagen, precio, stock FROM Productos";
        System.out.println("Consulta ejecutada: " + sql);

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int codProducto = rs.getInt("cod_producto");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");

                model.addRow(new Object[]{codProducto, nombre, precio, stock});
            }
            System.out.println("Datos obtenidos: " + model.getRowCount() + " filas.");
        } catch (SQLException e) {
            System.out.println("Error obteniendo los datos de los productos");
            e.printStackTrace();
        }
        return model;
    }

}
