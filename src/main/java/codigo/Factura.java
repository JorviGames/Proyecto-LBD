/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC GAMER 2
 */
public class Factura {

    private final Connection conn;

    public Factura(Connection conn) {
        this.conn = conn;
    }

    public DefaultTableModel ObtenerFacturas() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Número de Factura", "Codigo de Producto"}, 0);
        String sql = "SELECT numero_factura, cod_producto FROM Facturacion";
        System.out.println("Consulta ejecutada: " + sql);

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int numero_factura = rs.getInt("numero_factura");
                int cod_producto = rs.getInt("cod_producto");
                model.addRow(new Object[]{numero_factura, cod_producto});
            }
            System.out.println("Datos obtenidos: " + model.getRowCount() + " filas.");
        } catch (SQLException e) {
            System.out.println("Error obteniendo los datos de la Factura");
            e.printStackTrace();
        }
        return model;
    }

    public boolean AgregarFactura(int numeroFactura, int codProducto) {
        String query = "INSERT INTO Facturacion (numero_factura, cod_producto) VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, numeroFactura);
            stmt.setInt(2, codProducto);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Factura agregada correctamente.");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar la factura.");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar la factura: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarFactura(int numeroFactura) {
        String query = "DELETE FROM Facturacion WHERE numero_factura = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, numeroFactura);  // Establecer el valor del número de factura

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Factura eliminada exitosamente.");
                return true;  // La eliminación fue exitosa
            } else {
                System.out.println("No se encontró la factura con el número: " + numeroFactura);
                return false;  // No se encontró la factura para eliminar
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la factura.");
            e.printStackTrace();
            return false;  // Error en la eliminación
        }
    }

}
