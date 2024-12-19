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
        String query = "{ CALL AgregarFactura(?, ?) }";  // Llamada al procedimiento almacenado

        try (CallableStatement stmt = conn.prepareCall(query)) {
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
        String query = "{ CALL EliminarFactura(?) }";  // Llamada al procedimiento almacenado

        try (CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, numeroFactura);

            // Ejecuta la llamada al procedimiento almacenado
            stmt.executeUpdate();
            System.out.println("Factura eliminada exitosamente.");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar la factura: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}
