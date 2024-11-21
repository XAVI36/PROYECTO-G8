/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectovivienda2.igu;

import com.mycompany.proyectovivienda2.logica.Controlador;
import com.mycompany.proyectovivienda2.logica.Torre;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Santiago
 */
public class VerDatosTorre extends javax.swing.JFrame {
    
    Controlador control = null;

    /**
     * Creates new form VerDatosTorre
     */
    public VerDatosTorre() {
        control = new Controlador();
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
        lblDatosTorres = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTorres = new javax.swing.JTable();
        btnModificarTorre = new javax.swing.JButton();
        btnEliminarTorre = new javax.swing.JButton();
        btnMenuAdministrador = new javax.swing.JButton();
        btnDatosInmueble = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblDatosTorres.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblDatosTorres.setForeground(new java.awt.Color(255, 255, 255));
        lblDatosTorres.setText("DATOS TORRES");

        TablaTorres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaTorres);

        btnModificarTorre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnModificarTorre.setText("MODIFICAR");
        btnModificarTorre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarTorreActionPerformed(evt);
            }
        });

        btnEliminarTorre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEliminarTorre.setText("ELIMINAR");
        btnEliminarTorre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTorreActionPerformed(evt);
            }
        });

        btnMenuAdministrador.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMenuAdministrador.setText("MENU");
        btnMenuAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuAdministradorActionPerformed(evt);
            }
        });

        btnDatosInmueble.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDatosInmueble.setText("INMUEBLE");
        btnDatosInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosInmuebleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnModificarTorre, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnEliminarTorre, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(btnMenuAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(btnDatosInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(lblDatosTorres)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblDatosTorres)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarTorre, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarTorre, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenuAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDatosInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuAdministradorActionPerformed
        PanelAdministrador irMenu = new PanelAdministrador();
        irMenu.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnMenuAdministradorActionPerformed

    private void btnModificarTorreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarTorreActionPerformed
        
        if(TablaTorres.getRowCount()>0){
            if(TablaTorres.getSelectedRow()!=-1){
                int id = Integer.parseInt(String.valueOf(TablaTorres.getValueAt(TablaTorres.getSelectedRow(),0)));
                ModificarTorre mod = new ModificarTorre(id);
                mod.setVisible(true);
                mod.setLocationRelativeTo(null);
                this.dispose();
                
            }
            else {
                mostrarMensaje("No selecciono ninguna Torre","Error","Error al eliminar");
            }
        }
        else {
            mostrarMensaje("No hay nada para eliminar en la tabla","Error","Error al eliminar");
        }/// TODO add your handling code here:
    }//GEN-LAST:event_btnModificarTorreActionPerformed

    private void btnEliminarTorreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTorreActionPerformed
        
        if(TablaTorres.getRowCount()>0){
            if(TablaTorres.getSelectedRow()!=-1){
                int id = Integer.parseInt(String.valueOf(TablaTorres.getValueAt(TablaTorres.getSelectedRow(),0)));
                control.eliminarTorre(id);   
                
                mostrarMensaje("Torre eliminada correctamente","Info","Se elimino");
                cargarDatos();
            }
            else {
                mostrarMensaje("No selecciono ninguna Torre","Error","Error al eliminar");
            }
        }
        else {
            mostrarMensaje("No hay nada para eliminar en la tabla","Error","Error al eliminar");
        }// TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarTorreActionPerformed
    public void mostrarMensaje(String mensaje, String tipo, String titulo){
        JOptionPane optionPane = new JOptionPane(mensaje);
        if(tipo.equals("Info")){
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }
        else if (tipo.equals("Error")){
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog  = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    
}
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarDatos();// TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void btnDatosInmuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosInmuebleActionPerformed
        VerDatosInmueble ver = new VerDatosInmueble();
        ver.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnDatosInmuebleActionPerformed

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
            java.util.logging.Logger.getLogger(VerDatosTorre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerDatosTorre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerDatosTorre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerDatosTorre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerDatosTorre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaTorres;
    private javax.swing.JButton btnDatosInmueble;
    private javax.swing.JButton btnEliminarTorre;
    private javax.swing.JButton btnMenuAdministrador;
    private javax.swing.JButton btnModificarTorre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDatosTorres;
    // End of variables declaration//GEN-END:variables

    private void cargarDatos() {
        DefaultTableModel modeloTabla = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        //nombre de las columnas para la tabla clientes
        String titulos[] = {"ID","NOMBRE","NUMEO DE PISOS"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        //carga de los datos desde la base de datos 
        List <Torre> listaTorres = control.listaTorres();
        
        if(listaTorres!=null){
            for(Torre tor: listaTorres){
                Object[] objeto = {tor.getId(),tor.getNombre(),tor.getNumPisos()};
                modeloTabla.addRow(objeto);
            }
        }
        
        TablaTorres.setModel(modeloTabla);
    }
}
