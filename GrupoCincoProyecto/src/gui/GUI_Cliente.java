/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import clases.Cliente;
import clases.Inventario;
import clases.Local;
import clases.Pedido;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.LogicaCliente;
import logica.LogicaLocal;
import logica.ValorCombo;
import logica.LogicaProducto;
import logica.LogicaInventario;
import logica.LogicaPedidos;

/**
 *
 */
public class GUI_Cliente extends javax.swing.JFrame {

    ArrayList<Cliente> ArrayClientes = new ArrayList<>();
    LogicaCliente objLogCli = new LogicaCliente();
    ArrayList<Local> ArrayFarmacias = new ArrayList<>();
    ArrayList<Pedido> ArrayPedidos = new ArrayList<>();
    ArrayList<Inventario> productosPedidos = new ArrayList<>();
    
    LogicaLocal objLogLoc = new LogicaLocal();
    LogicaProducto objLogPro = new LogicaProducto();
    LogicaInventario objLogInv = new LogicaInventario();
    LogicaPedidos objLogPed = new LogicaPedidos();
    
    String fecha;
    /**
     * Creates new form GUI_Cliente
     */
    public GUI_Cliente() {
        initComponents();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        fecha = sdf.format(new Date());
        this.jTextFecha.setText(fecha);
         
        try {
            LogicaLocal.LeerLocalesDAT(ArrayFarmacias);
            // this.jLabel1.setVisible(false);
            //this.jComboFarmacias.setVisible(false);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(GUI_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        CargarCombo();
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
        jLabel3 = new javax.swing.JLabel();
        jTextCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextCantidad = new javax.swing.JTextField();
        jButtonAgregar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jTextFecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonNuevoCliente = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextCedula.setText("Cedula");

        jPasswordClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordClaveActionPerformed(evt);
            }
        });

        jButtonIngresar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButtonIngresar.setText("Ingresar");
        jButtonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresarActionPerformed(evt);
            }
        });

        jLabel1.setText("Farmacias:");

        jComboFarmacias.setEnabled(false);
        jComboFarmacias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboFarmaciasActionPerformed(evt);
            }
        });

        jButtonListar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButtonListar.setText("Listar Productos");
        jButtonListar.setEnabled(false);
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
        jTable1.setEnabled(false);
        jScrollTabla.setViewportView(jTable1);

        jLabel3.setText("Codigo:");

        jTextCodigo.setEnabled(false);

        jLabel2.setText("Cantidad:");

        jTextCantidad.setEnabled(false);

        jButtonAgregar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButtonAgregar.setText("Agregar");
        jButtonAgregar.setEnabled(false);
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonGuardar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButtonGuardar.setText("Guardar Pedido");
        jButtonGuardar.setEnabled(false);
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jTextFecha.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel4.setText("AGREGAR PEDIDO");

        jButtonNuevoCliente.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButtonNuevoCliente.setText("Nuevo Cliente");
        jButtonNuevoCliente.setActionCommand("");
        jButtonNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoClienteActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAgregar)
                                    .addComponent(jButtonGuardar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboFarmacias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonListar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jTextCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jPasswordClave, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jButtonIngresar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonNuevoCliente)))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabel4)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIngresar)
                    .addComponent(jButtonNuevoCliente)
                    .addComponent(jButton1))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboFarmacias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonListar)
                    .addComponent(jTextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButtonAgregar)
                .addGap(34, 34, 34)
                .addComponent(jButtonGuardar)
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed
        try {
            // TODO add your handling code here:
            LogicaCliente.LeerClientesDAT(ArrayClientes);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(GUI_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (objLogCli.validarCliente(ArrayClientes, this.jTextCedula.getText(), String.valueOf(this.jPasswordClave.getPassword()))) {
            CargarCombo();
            this.jComboFarmacias.setEnabled(true);
            this.jButtonListar.setEnabled(true);
            this.jTable1.setEnabled(true);
            this.jTextCodigo.setEnabled(true);
            this.jTextCantidad.setEditable(true);
            this.jButtonAgregar.setEnabled(true);
            this.jButtonGuardar.setEnabled(true);
            this.jTextCantidad.setEnabled(true);
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
        Local objLocal = LogicaLocal.BuscarLocal(ArrayFarmacias, this.jComboFarmacias.getSelectedItem().toString());
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

    private void jComboFarmaciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboFarmaciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboFarmaciasActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        try {
            // TODO add your handling code here:
            LogicaLocal.LeerLocalesDAT(ArrayFarmacias);
        } catch (IOException ex) {
            Logger.getLogger(GUI_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        Local objLocal = objLogLoc.BuscarLocal(ArrayFarmacias, this.jComboFarmacias.getSelectedItem().toString());
        System.out.println(objLocal.inventarioGeneral);
        Inventario objInv = objLogInv.buscarPro(ArrayFarmacias, this.jTextCodigo.getText());
        System.out.println(objInv);
        if(Integer.parseInt(this.jTextCantidad.getText()) > objInv.cantidad){
            JOptionPane.showMessageDialog(null, "No hay cantidad suficiente", "Error", JOptionPane.PLAIN_MESSAGE);
        } else{
            productosPedidos.add(new Inventario(Integer.parseInt(this.jTextCantidad.getText()), objInv.getProducto()));
            this.jTextCodigo.setText("");
            this.jTextCantidad.setText("");
        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
        double total = objLogInv.valor(productosPedidos);
        Cliente objCli = objLogCli.cargarCliente(ArrayClientes, this.jTextCedula.getText());
        Local objLocal = objLogLoc.BuscarLocal(ArrayFarmacias, this.jComboFarmacias.getSelectedItem().toString());
        Pedido objPedido = new Pedido(fecha,0,total,objCli, productosPedidos,objLocal);
        ArrayPedidos.add(objPedido);
        try {
            LogicaPedidos.EscribirPedidosDAT(ArrayPedidos);
        } catch (IOException ex) {
            Logger.getLogger(GUI_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoClienteActionPerformed
        new CrearCliente().setVisible(true);
        this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jButtonNuevoClienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Inicio().setVisible(true);
        this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonIngresar;
    private javax.swing.JButton jButtonListar;
    private javax.swing.JButton jButtonNuevoCliente;
    private javax.swing.JComboBox<String> jComboFarmacias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordClave;
    private javax.swing.JScrollPane jScrollTabla;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextCantidad;
    private javax.swing.JTextField jTextCedula;
    private javax.swing.JTextField jTextCodigo;
    private javax.swing.JTextField jTextFecha;
    // End of variables declaration//GEN-END:variables
}
