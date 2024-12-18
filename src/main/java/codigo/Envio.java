/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

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
 * @author yorvi
 */
public class Envio {
    
    private final Connection conn;
    
    public Envio(Connection conn){
        this.conn = conn;
    }
    public DefaultTableModel obtenerEnvios() {
        String query = "SELECT e.numero_envio, e.direccion, ec.cod_cliente " +
                       "FROM Envios e " +
                       "LEFT JOIN Envios_Clientes ec ON e.numero_envio = ec.numero_envio " +
                       "ORDER BY e.numero_envio ASC";

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{
            "Número de Envío", "Dirección", "Código de Cliente"
        });

        try (PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("numero_envio"),
                    rs.getString("direccion"),
                    rs.getObject("cod_cliente") 
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los envíos: " + e.getMessage());
        }

        return model;
    }
    
    public void llenar(javax.swing.JTable tabla) {
        String query = "SELECT e.numero_envio, e.direccion, ec.cod_cliente " +
                       "FROM Envios e " +
                       "LEFT JOIN Envios_Clientes ec ON e.numero_envio = ec.numero_envio " +
                       "ORDER BY e.numero_envio ASC";
        try (PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("numero_envio"),
                    rs.getString("direccion"),
                    rs.getObject("cod_cliente")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + e.getMessage());
        }
    }
    
public boolean registrarEnvio(int numeroEnvio, String direccion, int cod_cliente) {
    String query = "BEGIN sp_registrar_envio(?, ?, ?); END;";
    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, numeroEnvio);
        stmt.setString(2, direccion);
        stmt.setInt(3, cod_cliente);

        stmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al registrar el envío: " + e.getMessage());
        return false;
    }
}


    public ArrayList<String> obtenerClientesDisponibles() {
        ArrayList<String> clientes = new ArrayList<>();
        String query = "SELECT COD_CLIENTE, NOMBRE FROM Clientes";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String cliente = rs.getInt("COD_CLIENTE") + " - " + rs.getString("NOMBRE");
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener clientes: " + e.getMessage());
        }
        return clientes;
    }

    public int obtenerCodigoCliente(String clienteStr) {
        String[] parts = clienteStr.split(" - ");
        int codCliente = Integer.parseInt(parts[0]);
        return codCliente;
    }
    
public boolean actualizarEnvio(int numeroEnvio, String nuevaDireccion) {
    String query = "BEGIN actualizar_envio(?, ?); END;";
    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, numeroEnvio);
        stmt.setString(2, nuevaDireccion);

        stmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar el envío: " + e.getMessage());
        return false;
    }
}

public boolean eliminarEnvio(int numeroEnvio) {
    String query = "BEGIN eliminar_envio(?); END;";
    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, numeroEnvio);

        stmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar el envío: " + e.getMessage());
        return false;
    }
}






}


