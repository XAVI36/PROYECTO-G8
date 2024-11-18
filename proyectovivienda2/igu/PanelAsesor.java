/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectovivienda2.igu;

/**
 *
 * @author Santiago
 */
public class PanelAsesor extends javax.swing.JFrame {

    /**
     * Creates new form PanelAsesor
     */
    public PanelAsesor() {
        initComponents();
        setLocationRelativeTo(null);
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
        lblPanelAsesor = new javax.swing.JLabel();
        btnRegistraCliente = new javax.swing.JButton();
        btnGestionarVenta = new javax.swing.JButton();
        btnRegistrarPago = new javax.swing.JButton();
        lblObrasVanguard = new javax.swing.JLabel();
        btnDATOSpAGO = new javax.swing.JButton();
        btnDATOSVENTA = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblPanelAsesor.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblPanelAsesor.setForeground(new java.awt.Color(255, 255, 255));
        lblPanelAsesor.setText("PANEL ASESOR");

        btnRegistraCliente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegistraCliente.setText("REGISTRAR CLIENTE");
        btnRegistraCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistraClienteActionPerformed(evt);
            }
        });

        btnGestionarVenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGestionarVenta.setText("GESTIONAR VENTA ");
        btnGestionarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarVentaActionPerformed(evt);
            }
        });

        btnRegistrarPago.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegistrarPago.setText("REGISTRAR PAGO");
        btnRegistrarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPagoActionPerformed(evt);
            }
        });

        lblObrasVanguard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblObrasVanguard.setForeground(new java.awt.Color(255, 255, 255));
        lblObrasVanguard.setText("Obras Vanguard");

        btnDATOSpAGO.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDATOSpAGO.setText("DATOS PAGO");
        btnDATOSpAGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDATOSpAGOActionPerformed(evt);
            }
        });

        btnDATOSVENTA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDATOSVENTA.setText("DATOS VENTA");
        btnDATOSVENTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDATOSVENTAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(360, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegistraCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGestionarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDATOSpAGO, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(331, 331, 331))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblObrasVanguard)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(lblPanelAsesor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(361, Short.MAX_VALUE)
                    .addComponent(btnDATOSVENTA, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(333, 333, 333)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(lblPanelAsesor)
                .addGap(63, 63, 63)
                .addComponent(btnGestionarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(btnRegistrarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(btnRegistraCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addComponent(btnDATOSpAGO, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(lblObrasVanguard)
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(534, Short.MAX_VALUE)
                    .addComponent(btnDATOSVENTA, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(189, 189, 189)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestionarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarVentaActionPerformed
        Ventas irVenta = new Ventas();
        irVenta.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnGestionarVentaActionPerformed

    private void btnRegistrarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPagoActionPerformed
        Pagos irPago = new Pagos();
        irPago.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarPagoActionPerformed

    private void btnRegistraClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistraClienteActionPerformed
        Clientes irCliente = new Clientes();
        irCliente.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnRegistraClienteActionPerformed

    private void btnDATOSpAGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDATOSpAGOActionPerformed
        VerDatosPago ver = new VerDatosPago();
        ver.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnDATOSpAGOActionPerformed

    private void btnDATOSVENTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDATOSVENTAActionPerformed
        VerDatosVenta ver = new VerDatosVenta();
        ver.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnDATOSVENTAActionPerformed

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
            java.util.logging.Logger.getLogger(PanelAsesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelAsesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelAsesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelAsesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelAsesor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDATOSVENTA;
    private javax.swing.JButton btnDATOSpAGO;
    private javax.swing.JButton btnGestionarVenta;
    private javax.swing.JButton btnRegistraCliente;
    private javax.swing.JButton btnRegistrarPago;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblObrasVanguard;
    private javax.swing.JLabel lblPanelAsesor;
    // End of variables declaration//GEN-END:variables
}