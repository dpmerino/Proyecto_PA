/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import clases.Cliente;
import clases.Inventario;
import clases.Local;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.LogicaCliente;
import logica.LogicaLocal;
import logica.ValorCombo;

/**
 *
 * @author diegomerino
 */
public class GUI_Cliente extends javax.swing.JFrame {

    ArrayList<Cliente> ArrayClientes = new ArrayList<>();
    LogicaCliente objLogCli = new LogicaCliente();
    ArrayList<Local> ArrayFarmacias = new ArrayList<>();

    LogicaLocal objLogLoc = new LogicaLocal();

    /**
     * Creates new form GUI_Cliente
     */
    public GUI_Cliente() {
        initComponents();
        this.jLabel1.setVisible(false);
        this.jComboFarmacias.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextCedula = new javax.swing.JTextField();
        jPasswordClave = new javax.swing.JPasswordField();
        jButtonIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboFarmacias = new javax.swing.JComboBox<>();
        jButtonListar = new javax.swing.JButton();
        jScrollTabla = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextCodigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextCedula.setText("Cedula");

        jPasswordClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordClaveActionPerformed(evt);
            }
        });

        jButtonIngresar.setText("Ingresar");
        jButtonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresarActionPerformed(evt);
            }
        });

        jLabel1.setText("Farmacias:");

        jComboFarmacias.setEnabled(false);

        jButtonListar.setText("Listar Productos");
        jButtonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollTabla.setViewportView(jTable1);

        jLabel2.setText("Codigo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jComboFarmacias, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jButtonListar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jPasswordClave, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jButtonIngresar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIngresar))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboFarmacias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonListar))
                .addGap(33, 33, 33)
                .addComponent(jScrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed
        try {
            // TODO add your handling code here:
            LogicaCliente.LeerClientesDAT(ArrayClientes);
        } catch (IOException ex) {
            Logger.getLogger(GUI_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (objLogCli.validarCliente(ArrayClientes, this.jTextCedula.getText(), String.valueOf(this.jPasswordClave.getPassword()))) {
            CargarCombo();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no existe o incorrecto", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jButtonIngresarActionPerformed

    private void jButtonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarActionPerformed
        try {
            // TODO add your handling code here:
            ArrayFarmacias.removeAll(ArrayFarmacias);
            logica.LogicaLocal.LeerLocalesDAT(ArrayFarmacias);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(GUI_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        Object columnas[] = {
            "Nombre", "Codigo", "Precio", "Cantidad"
        };
        DefaultTableModel model = new DefaultTableModel(null, columnas);
        this.jTable1.setModel(model);
        Local objLocal = objLogLoc.BuscarLocal(ArrayFarmacias, this.jComboFarmacias.getSelectedItem().toString());
        for (Inventario objInv : objLocal.getInventarioGeneral()) {
            String NewValor[] = {
                objInv.getProducto().getNombre(),
                String.valueOf(objInv.getProducto().getCodigo()),
                String.valueOf(objInv.getProducto().getPrecio()),
                String.valueOf(objInv.cantidad)
            };
            model.addRow(NewValor);
        }
    }//GEN-LAST:event_jButtonListarActionPerformed

    private void jPasswordClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordClaveActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Cliente().setVisible(true);
            }
        });
    }

    public void CargarCombo() {
        logica.ValorCombo objCargar = new ValorCombo();
        this.jComboFarmacias.setModel(new DefaultComboBoxModel(objCargar.CargarFarmacias(ArrayFarmacias).toArray()));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIngresar;
    private javax.swing.JButton jButtonListar;
    private javax.swing.JComboBox<String> jComboFarmacias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordClave;
    private javax.swing.JScrollPane jScrollTabla;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextCedula;
    private javax.swing.JTextField jTextCodigo;
    // End of variables declaration//GEN-END:variables
}
