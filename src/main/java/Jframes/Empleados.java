/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframes;

import baseDatos.DatabaseConnection;
import codigo.Empleado;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorge Alfaro
 */
public class Empleados extends javax.swing.JFrame {

    /**
     * Creates new form Empleados
     */
    public Empleados() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnVolverMenu1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        T_empleados = new javax.swing.JTable();
        B_agregarEmpleado = new javax.swing.JButton();
        B_editarEmpleado = new javax.swing.JButton();
        B_eliminarEmpleado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Gestión de Empleados");

        btnVolverMenu1.setText("Volver Al Menu");
        btnVolverMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverMenu1ActionPerformed(evt);
            }
        });

        T_empleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod.Empleado", "Nombre", "Primer Apellido", "Segundo Apellido", "Correo", "Numero", "Departamento"
            }
        ));
        jScrollPane2.setViewportView(T_empleados);

        B_agregarEmpleado.setText("Agregar Empleado");
        B_agregarEmpleado.setToolTipText("");
        B_agregarEmpleado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B_agregarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B_agregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_agregarEmpleadoActionPerformed(evt);
            }
        });

        B_editarEmpleado.setText("Editar Empleado");
        B_editarEmpleado.setToolTipText("");
        B_editarEmpleado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B_editarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B_editarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_editarEmpleadoActionPerformed(evt);
            }
        });

        B_eliminarEmpleado.setText("Eliminar Empleado");
        B_eliminarEmpleado.setToolTipText("");
        B_eliminarEmpleado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B_eliminarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B_eliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_eliminarEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVolverMenu1)
                        .addGap(286, 286, 286)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(B_editarEmpleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B_eliminarEmpleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B_agregarEmpleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnVolverMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(B_agregarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(B_editarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(B_eliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(155, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverMenu1ActionPerformed
        // TODO add your handling code here:
        Menu_Clientes_envio LO = new Menu_Clientes_envio();
        LO.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnVolverMenu1ActionPerformed

    private void B_agregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_agregarEmpleadoActionPerformed
        // TODO add your handling code here:
        agregarEmpleado();

    }//GEN-LAST:event_B_agregarEmpleadoActionPerformed

    private void B_editarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_editarEmpleadoActionPerformed
        // TODO add your handling code here:
        actualizarEmpleado();

    }//GEN-LAST:event_B_editarEmpleadoActionPerformed

    private void B_eliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_eliminarEmpleadoActionPerformed
        // TODO add your handling code here:
        eliminarEmpleado();
    }//GEN-LAST:event_B_eliminarEmpleadoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleados().setVisible(true);
            }
        });
    }

private void llenarTabla() {
    DatabaseConnection conexion = new DatabaseConnection();
    conexion.conectarJ();

    Empleado empleado = new Empleado(conexion.getConnection());
    DefaultTableModel model = empleado.obtenerEmpleados();

    if (model.getRowCount() > 0) {
        T_empleados.setModel(model);
        System.out.println("Datos añadidos a la tabla.");
    } else {
        System.out.println("No se encontraron datos para mostrar.");
    }
}

public void agregarEmpleado() {
    try {
        int codEmpleado = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el código del empleado:"));
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre:");
        String primerApellido = JOptionPane.showInputDialog(this, "Ingrese el primer apellido:");
        String segundoApellido = JOptionPane.showInputDialog(this, "Ingrese el segundo apellido:");
        String correo = JOptionPane.showInputDialog(this, "Ingrese el correo:");
        String numero = JOptionPane.showInputDialog(this, "Ingrese el número:");

        DatabaseConnection conexion = new DatabaseConnection();
        conexion.conectarJ();
        
        Empleado departamento = new Empleado(conexion.getConnection());
        ArrayList<String> departamentosDisponibles = departamento.obtenerDepartamentos();

        if (departamentosDisponibles.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay departamentos disponibles para seleccionar.");
            return;
        }

        String selectedDepartamento = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione el departamento:",
                "Seleccionar Departamento",
                JOptionPane.PLAIN_MESSAGE,
                null,
                departamentosDisponibles.toArray(),
                departamentosDisponibles.get(0)
        );

        if (selectedDepartamento == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un departamento.");
            return;
        }

        int codDepartamento = departamento.obtenerCodigoDepartamento(selectedDepartamento);

        Empleado empleado = new Empleado(conexion.getConnection());
        boolean success = empleado.insertarEmpleado(codEmpleado, nombre, primerApellido, segundoApellido, correo, numero, codDepartamento);

        if (success) {
            JOptionPane.showMessageDialog(this, "Empleado agregado exitosamente.");
            llenarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar el empleado.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error al convertir los valores: " + e.getMessage());
    }
}

public void actualizarEmpleado() {
    int selectedRow = T_empleados.getSelectedRow();
    if (selectedRow >= 0) {
        DefaultTableModel model = (DefaultTableModel) T_empleados.getModel();
        int codEmpleado = (int) model.getValueAt(selectedRow, 0);
        String nombre = (String) model.getValueAt(selectedRow, 1);
        String primerApellido = (String) model.getValueAt(selectedRow, 2);
        String segundoApellido = (String) model.getValueAt(selectedRow, 3);
        String correo = (String) model.getValueAt(selectedRow, 4);
        String numero = (String) model.getValueAt(selectedRow, 5);
        int departamento = (int) model.getValueAt(selectedRow, 6);

        boolean continuar = true;
        while (continuar) {
            String[] opciones = {"Nombre", "Primer Apellido", "Segundo Apellido", "Correo", "Número", "Departamento", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(this,
                "¿Qué campo desea actualizar?",
                "Seleccionar Campo",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]);

            switch (eleccion) {
                case 0:
                    nombre = JOptionPane.showInputDialog(this, "Nombre del empleado:", nombre);
                    break;
                case 1:
                    primerApellido = JOptionPane.showInputDialog(this, "Primer apellido del empleado:", primerApellido);
                    break;
                case 2:
                    segundoApellido = JOptionPane.showInputDialog(this, "Segundo apellido del empleado:", segundoApellido);
                    break;
                case 3:
                    correo = JOptionPane.showInputDialog(this, "Correo del empleado:", correo);
                    break;
                case 4:
                    numero = JOptionPane.showInputDialog(this, "Número del empleado:", numero);
                    break;
                case 5:
                    DatabaseConnection conexion = new DatabaseConnection();
                    conexion.conectarJ();
                    Empleado departamentoDAO = new Empleado(conexion.getConnection());
                    ArrayList<String> departamentosDisponibles = departamentoDAO.obtenerDepartamentos();

                    if (departamentosDisponibles.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "No hay departamentos disponibles para seleccionar.");
                        return;
                    }

                    String selectedDepartamento = (String) JOptionPane.showInputDialog(
                            this,
                            "Seleccione el departamento:",
                            "Seleccionar Departamento",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            departamentosDisponibles.toArray(),
                            departamentosDisponibles.get(0)
                    );

                    if (selectedDepartamento == null) {
                        JOptionPane.showMessageDialog(this, "Debe seleccionar un departamento.");
                        return;
                    }

                    departamento = departamentoDAO.obtenerCodigoDepartamento(selectedDepartamento);
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    continuar = false;
                    break;
            }

            if (eleccion != 6 && eleccion != JOptionPane.CLOSED_OPTION) {
                int mas = JOptionPane.showConfirmDialog(this, "¿Desea actualizar otro campo?", "Continuar", JOptionPane.YES_NO_OPTION);
                continuar = (mas == JOptionPane.YES_OPTION);
            } else {
                continuar = false;
            }
        }

        DatabaseConnection conexion = new DatabaseConnection();
        conexion.conectarJ();
        Empleado empleadoDAO = new Empleado(conexion.getConnection());
        boolean success = empleadoDAO.actualizarEmpleado(codEmpleado, nombre, primerApellido, segundoApellido, correo, numero, departamento);
        conexion.desconectar();

        if (success) {
            JOptionPane.showMessageDialog(this, "Empleado actualizado exitosamente.");
            // Actualizar la tabla de empleados
            llenarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar el empleado.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un empleado para editar.");
    }
    
}

public void eliminarEmpleado() {
    int selectedRow = T_empleados.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un empleado de la tabla para eliminar.");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este empleado?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            int codEmpleado = Integer.parseInt(T_empleados.getValueAt(selectedRow, 0).toString());

            DatabaseConnection conexion = new DatabaseConnection();
            conexion.conectarJ();
            Empleado empleadoDAO = new Empleado(conexion.getConnection());
            boolean success = empleadoDAO.eliminarEmpleado(codEmpleado);
            conexion.desconectar();

            if (success) {
                JOptionPane.showMessageDialog(this, "Empleado eliminado exitosamente.");
                llenarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar el empleado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error al convertir los valores seleccionados: " + e.getMessage());
        }
    }
}






    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_agregarEmpleado;
    private javax.swing.JButton B_editarEmpleado;
    private javax.swing.JButton B_eliminarEmpleado;
    private javax.swing.JTable T_empleados;
    private javax.swing.JButton btnVolverMenu;
    private javax.swing.JButton btnVolverMenu1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
