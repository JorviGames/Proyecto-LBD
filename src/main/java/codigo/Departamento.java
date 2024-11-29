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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yorvi
 */
public class Departamento {
    
    private Connection conn;
    
    public Departamento(Connection conn){
        this.conn = conn;
    }
    
    public DefaultTableModel obtenerDepartamentos() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Código", "Nombre", "Descripción"}, 0);
        String sql = "SELECT cod_departamento, nombre_departamento, descrip_departamento FROM Departamentos";
        System.out.println("Consulta ejecutada: " + sql);

        try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int codigo = rs.getInt("cod_departamento");
                String nombre = rs.getString("nombre_departamento");
                String descripcion = rs.getString("descrip_departamento");
                model.addRow(new Object[]{codigo, nombre, descripcion});
            }
            System.out.println("Datos obtenidos: " + model.getRowCount() + " filas.");
        } catch (SQLException e) {
            System.out.println("Error obteniendo los datos de Departamentos");
            e.printStackTrace();
        }
        return model;
    }
    
    public boolean agregarDepartamento(int codDepartamento, String nombre, String descripcion) {
    String query = "BEGIN insertar_departamento(?, ?, ?); END;";
    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, codDepartamento);
        stmt.setString(2, nombre);
        stmt.setString(3, descripcion);

        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null,"Departamento agregado exitosamente.");
        return true;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al insertar el departamento: " + e.getMessage());
        return false;
    }
}
    public void llenar(javax.swing.JTable tabla) {
    String query = "SELECT cod_departamento, nombre_departamento, descrip_departamento FROM Departamentos";

    try (PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);

        while (rs.next()) {
            Object[] row = {
                rs.getInt("cod_departamento"),
                rs.getString("nombre_departamento"),
                rs.getString("descrip_departamento")
            };
            model.addRow(row);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + e.getMessage());
    }
}
    
    public void actualizarDepartamento(int codDepartamento, String nombre, String descripcion) {
    String sql = "{CALL actualizar_departamento(?, ?, ?)}";
    try (CallableStatement stmt = conn.prepareCall(sql)) {
        stmt.setInt(1, codDepartamento);
        stmt.setString(2, nombre);
        stmt.setString(3, descripcion);
        stmt.executeUpdate();
        System.out.println("Departamento actualizado");
    } catch (SQLException e) {
        System.out.println("Error al actualizar el departamento");
        e.printStackTrace();
    }
}
    
    public void eliminarDepartamento(int codDepartamento) {
    String sql = "{CALL eliminar_departamento(?)}";
    try (CallableStatement stmt = conn.prepareCall(sql)) {
        stmt.setInt(1, codDepartamento);
        stmt.executeUpdate();
        System.out.println("Departamento eliminado");
    } catch (SQLException e) {
        System.out.println("Error eliminando el departamento");
        e.printStackTrace();
    }
}



    
    
}
