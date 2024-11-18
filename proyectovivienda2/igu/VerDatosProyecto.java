/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectovivienda2.igu;

import com.mycompany.proyectovivienda2.logica.Controlador;
import com.mycompany.proyectovivienda2.logica.Proyecto;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Santiago
 */
public class VerDatosProyecto extends javax.swing.JFrame {
    
    Controlador control = null;

    /**
     * Creates new form VerDatosProyecto
     */
    public VerDatosProyecto() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProyectos = new javax.swing.JTable();
        lblDatosProyectos = new javax.swing.JLabel();
        btnEliminarProyecto = new javax.swing.JButton();
        btnModificarProyecto = new javax.swing.JButton();
        btnMenuAdministrador = new javax.swing.JButton();
        btnDatosTorre = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        TablaProyectos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaProyectos);

        lblDatosProyectos.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblDatosProyectos.setForeground(new java.awt.Color(255, 255, 255));
        lblDatosProyectos.setText("DATOS PROYECTOS ");

        btnEliminarProyecto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEliminarProyecto.setText("ELIMINAR");
        btnEliminarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProyectoActionPerformed(evt);
            }
        });

        btnModificarProyecto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnModificarProyecto.setText("MODIFICAR");
        btnModificarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProyectoActionPerformed(evt);
            }
        });

        btnMenuAdministrador.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMenuAdministrador.setText("MENU");
        btnMenuAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuAdministradorActionPerformed(evt);
            }
        });

        btnDatosTorre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDatosTorre.setText("TORRE");
        btnDatosTorre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosTorreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btnModificarProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnEliminarProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btnMenuAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnDatosTorre, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDatosProyectos)
                        .addGap(211, 211, 211))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(lblDatosProyectos)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenuAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDatosTorre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
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

    private void btnModificarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProyectoActionPerformed
        if(TablaProyectos.getRowCount()>0){
            //para que se seleccione un proyecto
            if(TablaProyectos.getSelectedRow()!=-1){
                int id = Integer.parseInt(String.valueOf(TablaProyectos.getValueAt(TablaProyectos.getSelectedRow(),0)));
                ModificarProyecto mod = new ModificarProyecto(id);   
                mod.setVisible(true);
                mod.setLocationRelativeTo(null);
                dispose();
            }
            else {
                mostrarMensaje("No selecciono ningun Proyecto","Error","Error al eliminar");
            }
        }
        else {
            mostrarMensaje("No hay nada para eliminar en la tabla","Error","Error al eliminar");
        }// TODO add your handling code here:
    }//GEN-LAST:event_btnModificarProyectoActionPerformed

    private void btnEliminarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProyectoActionPerformed
        
        //control de que la tabla no este vacia
        if(TablaProyectos.getRowCount()>0){
            //para que se seleccione un proyecto
            if(TablaProyectos.getSelectedRow()!=-1){
                int id = Integer.parseInt(String.valueOf(TablaProyectos.getValueAt(TablaProyectos.getSelectedRow(),0)));
                //para llamr el metodo eliminar
                control.eliminarProyecto(id);   
                
                mostrarMensaje("Proyecto eliminado correctamente","Info","Se elimino");
                cargarDatos();
            }
            else {
                mostrarMensaje("No selecciono ningun Proyecto","Error","Error al eliminar");
            }
        }
        else {
            mostrarMensaje("No hay nada para eliminar en la tabla","Error","Error al eliminar");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarProyectoActionPerformed
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
    private void btnMenuAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuAdministradorActionPerformed
        PanelAdministrador irMenu = new PanelAdministrador();
        irMenu.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnMenuAdministradorActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarDatos();// TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void btnDatosTorreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosTorreActionPerformed
        VerDatosTorre ver = new VerDatosTorre();
        ver.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnDatosTorreActionPerformed

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
            java.util.logging.Logger.getLogger(VerDatosProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerDatosProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerDatosProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerDatosProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerDatosProyecto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaProyectos;
    private javax.swing.JButton btnDatosTorre;
    private javax.swing.JButton btnEliminarProyecto;
    private javax.swing.JButton btnMenuAdministrador;
    private javax.swing.JButton btnModificarProyecto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDatosProyectos;
    // End of variables declaration//GEN-END:variables

    private void cargarDatos() {
        
        DefaultTableModel modeloTabla = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        //nombre de las columnas para la tabla clientes
        String titulos[] = {"ID","NOMBRE","DESCRIPCION"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        //carga de los datos desde la base de datos 
        List <Proyecto> listaProyectos = control.traerProyectos();
        
        if(listaProyectos!=null){
            for(Proyecto pro: listaProyectos){
                Object[] objeto = {pro.getId(),pro.getNombre(),pro.getDescripcion()};
                modeloTabla.addRow(objeto);
            }
        }
        
        TablaProyectos.setModel(modeloTabla);
    }
}