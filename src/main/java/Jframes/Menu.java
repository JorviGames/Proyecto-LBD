/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframes;

/**
 *
 * @author yorvi
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setTitle("Menu");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        G_SUC = new javax.swing.JButton();
        G_DEP = new javax.swing.JButton();
        G_FACT = new javax.swing.JButton();
        G_PRO = new javax.swing.JButton();
        G_INV = new javax.swing.JButton();
        G_CLIYENV = new javax.swing.JButton();
        G_PROVE = new javax.swing.JButton();
        G_EMPL = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        G_SUC.setText("Gestion de Sucursales");
        G_SUC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G_SUC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G_SUC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G_SUCActionPerformed(evt);
            }
        });

        G_DEP.setText("Gestion de Departamentos");
        G_DEP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G_DEP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G_DEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G_DEPActionPerformed(evt);
            }
        });

        G_FACT.setText("Gestion de Facturacion ");
        G_FACT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G_FACT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G_FACT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G_FACTActionPerformed(evt);
            }
        });

        G_PRO.setText("Gestion de Productos");
        G_PRO.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G_PRO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        G_INV.setText("Gestion de Inventarios");
        G_INV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G_INV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        G_CLIYENV.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        G_CLIYENV.setText("Gestion de Clientes y Envios");
        G_CLIYENV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G_CLIYENV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G_CLIYENV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G_CLIYENVActionPerformed(evt);
            }
        });

        G_PROVE.setText("Gestion de Proveedores");
        G_PROVE.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G_PROVE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        G_EMPL.setText("Gestion de Empleados");
        G_EMPL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G_EMPL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G_EMPL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G_EMPLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(G_EMPL, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(G_INV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(G_PRO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(G_FACT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(G_DEP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(G_SUC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(G_CLIYENV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(G_PROVE, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(231, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(G_SUC, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(G_DEP, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(G_PRO, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(G_FACT, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(G_INV, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(G_CLIYENV, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(G_PROVE, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(G_EMPL, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void G_SUCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G_SUCActionPerformed
        // TODO add your handling code here:
        Sucursales LOL = new Sucursales();
       
       LOL.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_G_SUCActionPerformed

    private void G_DEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G_DEPActionPerformed
        // TODO add your handling code here:
        Departamentos DEP = new Departamentos();
        DEP.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_G_DEPActionPerformed

    private void G_CLIYENVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G_CLIYENVActionPerformed
        // TODO add your handling code here:
       Menu_Clientes_envio LO = new Menu_Clientes_envio();
       
       LO.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_G_CLIYENVActionPerformed

    private void G_FACTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G_FACTActionPerformed
        // TODO add your handling code here:
        Facturas LO = new Facturas();
       
       LO.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_G_FACTActionPerformed

    private void G_EMPLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G_EMPLActionPerformed
        // TODO add your handling code here:
        Empleados LO = new Empleados();
       
       LO.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_G_EMPLActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton G_CLIYENV;
    private javax.swing.JButton G_DEP;
    private javax.swing.JButton G_EMPL;
    private javax.swing.JButton G_FACT;
    private javax.swing.JButton G_INV;
    private javax.swing.JButton G_PRO;
    private javax.swing.JButton G_PROVE;
    private javax.swing.JButton G_SUC;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
