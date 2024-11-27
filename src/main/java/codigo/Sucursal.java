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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Sucursal {

    private Connection conn;

    public Sucursal(Connection conn) {
        this.conn = conn;
    }

    public DefaultTableModel ObtenerSucursal() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Código", "Correo", "Dirección", "Teléfono"}, 0);
        String sql = "SELECT COD_SUCURSAL, CORREO, DIRECCION, TELEFONO FROM Sucursal";
        System.out.println("Consulta ejecutada: " + sql);

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int codigo = rs.getInt("COD_SUCURSAL");
                String correo = rs.getString("CORREO");
                String direccion = rs.getString("DIRECCION");
                String telefono = rs.getString("TELEFONO");
                model.addRow(new Object[]{codigo, correo, direccion, telefono});
            }
            System.out.println("Datos obtenidos: " + model.getRowCount() + " filas.");
        } catch (SQLException e) {
            System.out.println("Error obteniendo los datos de Sucursal");
            e.printStackTrace();
        }
        return model;
    }

    public boolean AgregarSucursal(int codSucursal, String correo, String direccion, String telefono) {
        String query = "BEGIN insertar_sucursal(?, ?, ?, ?); END;";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, codSucursal);
            stmt.setString(2, correo);
            stmt.setString(3, direccion);
            stmt.setString(4, telefono);

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar la sucursal: " + e.getMessage());
            return false;
        }
    }

    public void llenar(javax.swing.JTable tabla) {
        String query = "SELECT cod_sucursal, correo, direccion, telefono FROM Sucursal";

        try (PreparedStatement stmt = conn.prepareStatement(query); java.sql.ResultSet rs = stmt.executeQuery()) {

            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("cod_sucursal"),
                    rs.getString("correo"),
                    rs.getString("direccion"),
                    rs.getString("telefono")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + e.getMessage());
        }
    }

    public void actualizarSucursal(int cod_sucursal, String correo, String direccion, String telefono) {
        String sql = "{CALL actualizar_sucursal(?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, cod_sucursal);
            stmt.setString(2, correo);
            stmt.setString(3, direccion);
            stmt.setString(4, telefono);
            stmt.executeUpdate();
            System.out.println("Sucursal actualizada");
        } catch (SQLException e) {
            System.out.println("Error actualizando la sucursal");
            e.printStackTrace();
        }
    }
    
    public void eliminarSucursal(int cod_sucursal){
        String sql = "{CALL eliminar_sucursal(?)}";
        try(CallableStatement stmt = conn.prepareCall(sql)){
            stmt.setInt(1, cod_sucursal);
            stmt.executeUpdate();
            System.out.println("Sucursal eliminada");
        } catch(SQLException e){
            System.out.println("Error eliminando la sucursal");
            e.printStackTrace();
        }
    }

}
