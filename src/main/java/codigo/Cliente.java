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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cliente {

    private final Connection conn;

    public Cliente(Connection conn) {
        this.conn = conn;
    }

    public DefaultTableModel ObtenerClientes() {
        String query = "SELECT cod_cliente, Nombre, primerApellido, segundoApellido, Numero, Correo, numero_factura, num_transaccion "
                + "FROM CLIENTES "
                + "ORDER BY cod_cliente ASC"; // Ordenar de menor a mayor por el código de cliente

        System.out.println("Consulta SQL: " + query); // Verifica que la consulta sea la esperada

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{
            "Código de Cliente", "Nombre", "Primer Apellido", "Segundo Apellido", "Número", "Correo", "Número de Factura", "Número de Transacción"
        });

        try (PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("cod_cliente"),
                    rs.getString("Nombre"),
                    rs.getString("primerApellido"),
                    rs.getString("segundoApellido"),
                    rs.getString("Numero"),
                    rs.getString("Correo"),
                    rs.getInt("numero_factura"),
                    rs.getInt("num_transaccion")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + e.getMessage());
        }

        return model;
    }

    public boolean AgregarCliente(int codCliente, String nombre, String primerApellido, String segundoApellido, String numero, String correo, Integer numeroFactura, Integer selectedTransaccion) {
        String query = "BEGIN sp_insertar_cliente(?, ?, ?, ?, ?, ?, ?, ?); END;";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, codCliente);
            stmt.setString(2, nombre);
            stmt.setString(3, primerApellido);
            stmt.setString(4, segundoApellido);
            stmt.setString(5, numero);
            stmt.setString(6, correo);
            stmt.setInt(7, numeroFactura);
            stmt.setInt(8, selectedTransaccion); // Asegúrate de incluir este parámetro

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el cliente: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Integer> obtenerTransaccionesDisponibles() {
        ArrayList<Integer> transacciones = new ArrayList<>();
        String query = "SELECT num_transaccion FROM Pagos";
        try (PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                transacciones.add(rs.getInt("num_transaccion"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener las transacciones: " + e.getMessage());
        }
        return transacciones;
    }

    public void llenar(javax.swing.JTable tabla) {
        String query = "SELECT cod_cliente, Nombre, primerApellido, segundoApellido, Numero, Correo, numero_factura, num_transaccion "
                + "FROM CLIENTES "
                + "ORDER BY cod_cliente ASC"; // Ordenar de menor a mayor por el código de cliente
        try (PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("cod_cliente"),
                    rs.getString("Nombre"),
                    rs.getString("primerApellido"),
                    rs.getString("segundoApellido"),
                    rs.getString("Numero"),
                    rs.getString("Correo"),
                    rs.getInt("numero_factura"),
                    rs.getInt("num_transaccion")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + e.getMessage());
        }
    }

    public ArrayList<Integer> obtenerFacturasDisponibles() {
        ArrayList<Integer> facturas = new ArrayList<>();
        String query = "SELECT numero_factura FROM Facturacion";
        try (PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                facturas.add(rs.getInt("numero_factura"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener las facturas: " + e.getMessage());
        }
        return facturas;
    }
    
    public void actualizarCliente(int codCliente, String nombre, String primerApellido, String segundoApellido, String numero, String correo, int numeroFactura, int numTransaccion) {
    String sql = "{CALL sp_actualizar_cliente(?, ?, ?, ?, ?, ?, ?, ?)}";

    try (CallableStatement stmt = conn.prepareCall(sql)) {
        stmt.setInt(1, codCliente);
        stmt.setString(2, nombre);
        stmt.setString(3, primerApellido);
        stmt.setString(4, segundoApellido);
        stmt.setString(5, numero);
        stmt.setString(6, correo);
        stmt.setInt(7, numeroFactura);
        stmt.setInt(8, numTransaccion);

        stmt.execute();
        System.out.println("Cliente actualizado exitosamente.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar el cliente: " + e.getMessage());
        e.printStackTrace();
    }
}


}
