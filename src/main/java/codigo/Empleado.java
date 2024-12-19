package codigo;

import java.sql.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Empleado {

    private Connection conn;

    public Empleado(Connection conn) {
        this.conn = conn;
    }

    public DefaultTableModel obtenerEmpleados() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Código", "Nombre", "Primer Apellido", "Segundo Apellido", "Correo", "Número", "Departamento"}, 0);
        String query = "SELECT COD_EMPLEADO, NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, CORREO, NUMERO, DEPARTAMENTO FROM Empleados";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Object[] empleado = new Object[7];
                empleado[0] = rs.getInt("COD_EMPLEADO");
                empleado[1] = rs.getString("NOMBRE");
                empleado[2] = rs.getString("PRIMER_APELLIDO");
                empleado[3] = rs.getString("SEGUNDO_APELLIDO");
                empleado[4] = rs.getString("CORREO");
                empleado[5] = rs.getString("NUMERO");
                empleado[6] = rs.getInt("DEPARTAMENTO");
                model.addRow(empleado);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener empleados: " + e.getMessage());
        }
        return model;
    }

    public ArrayList<String> obtenerDepartamentos() {
        ArrayList<String> departamentos = new ArrayList<>();
        String query = "SELECT COD_DEPARTAMENTO, NOMBRE_DEPARTAMENTO FROM Departamentos";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String departamento = rs.getInt("COD_DEPARTAMENTO") + " - " + rs.getString("NOMBRE_DEPARTAMENTO");
                departamentos.add(departamento);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener departamentos: " + e.getMessage());
        }
        return departamentos;
    }

    public int obtenerCodigoDepartamento(String departamentoStr) {
        String[] parts = departamentoStr.split(" - ");
        return Integer.parseInt(parts[0]);
    }
    
    public boolean insertarEmpleado(int codEmpleado, String nombre, String primerApellido, String segundoApellido, String correo, String numero, int departamento) {
    String query = "BEGIN Insertar_Empleado(?, ?, ?, ?, ?, ?, ?); END;";
    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, codEmpleado);
        stmt.setString(2, nombre);
        stmt.setString(3, primerApellido);
        stmt.setString(4, segundoApellido);
        stmt.setString(5, correo);
        stmt.setString(6, numero);
        stmt.setInt(7, departamento);

        stmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al insertar empleado: " + e.getMessage());
        return false;
    }
}
    
    public boolean actualizarEmpleado(int codEmpleado, String nombre, String primerApellido, String segundoApellido, String correo, String numero, int departamento) {
    String query = "BEGIN Actualizar_Empleado(?, ?, ?, ?, ?, ?, ?); END;";
    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, codEmpleado);
        stmt.setString(2, nombre);
        stmt.setString(3, primerApellido);
        stmt.setString(4, segundoApellido);
        stmt.setString(5, correo);
        stmt.setString(6, numero);
        stmt.setInt(7, departamento);

        stmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar empleado: " + e.getMessage());
        return false;
    }
}
public boolean eliminarEmpleado(int codEmpleado) {
    String query = "BEGIN eliminar_empleado(?); END;";
    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, codEmpleado);

        stmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar empleado: " + e.getMessage());
        return false;
    }
}


}
