/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import clases.Inventario;
import clases.Local;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.LogicaLocal;
import clases.Producto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.LogicaBodeguero;

/**
 *
 * @author diegomerino
 */
public class GUI_Bodeguero_V2 extends javax.swing.JFrame {

    /**
     * Creates new form GUI_Bodeguero_V2
     */
    static LogicaLocal ObjLogLoc = new LogicaLocal();

    ArrayList<Local> ArrayLocales = new ArrayList<>();
    static ArrayList ArrayInventario = new ArrayList<Inventario>();
    static boolean HayLocales;

    LogicaLocal objLogLoc = new LogicaLocal();
    LogicaBodeguero objLogBod = new LogicaBodeguero();

    public GUI_Bodeguero_V2() {
        initComponents();
        try {
            LogicaLocal.LeerLocalesDAT(ArrayLocales);
        } catch (IOException ex) {
            Logger.getLogger(GUI_Bodeguero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_Bodeguero.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jButtonAgregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextCedula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtonIngresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jTextCod = new javax.swing.JTextField();
        jTextNombreLocal = new javax.swing.JTextField();
        jTextNom = new javax.swing.JTextField();
        jButtonAtras = new javax.swing.JButton();
        jTextPrec = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextVenc = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextCanti = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInventario = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("INTRODUCIR DATOS DEL PRODUCTO");

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.setEnabled(false);
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jLabel3.setText("Código");

        jLabel8.setText("Cedula");

        jLabel4.setText("Nombre");

        jLabel5.setText("Precio");

        jButtonIngresar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButtonIngresar.setText("Ingresar");
        jButtonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresarActionPerformed(evt);
            }
        });

        jLabel6.setText("Vencimiento");

        jTextCod.setEnabled(false);

        jTextNombreLocal.setEnabled(false);

        jTextNom.setEnabled(false);

        jButtonAtras.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButtonAtras.setText("Atras");
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        jTextPrec.setEnabled(false);

        jLabel9.setText("Local");

        jTextVenc.setEnabled(false);

        jLabel10.setText("clave");

        jLabel7.setText("Cantidad");

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel11.setText("Bodeguero:");

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("Agregar productos a Inventario/Local");

        jTextCanti.setEnabled(false);

        jTableInventario.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableInventario.setEnabled(false);
        jScrollPane1.setViewportView(jTableInventario);

        jButton1.setText("Guardar Inventario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel10)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addGap(46, 46, 46)
                                            .addComponent(jLabel8)))
                                    .addGap(28, 28, 28)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextCedula)
                                        .addComponent(jPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                                    .addGap(87, 87, 87)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextNombreLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextCod, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextNom, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextVenc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextCanti, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextPrec, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAgregar)
                                    .addGap(63, 63, 63))
                                .addComponent(jScrollPane1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jButton1)))
                .addGap(0, 33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jButtonIngresar))
                    .addComponent(jLabel11))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButtonAtras)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNombreLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextPrec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jTextVenc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextCanti, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAgregar)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButton1)
                .addContainerGap(189, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        Local ObjLocal = ObjLogLoc.BuscarConBodeguero(ArrayLocales, jTextCedula.getText());
        int indexLocal = ArrayLocales.indexOf(ObjLocal);
        Producto ObjProd = new Producto(this.jTextCod.getText(), this.jTextNom.getText(), Double.parseDouble(this.jTextPrec.getText()), this.jTextVenc.getText());
        //Inventario objInv = new Inventario(Integer.parseInt(this.jTextCanti.getText()), ObjProd);
        ObjLocal.AgregarInventario(Integer.parseInt(this.jTextCanti.getText()), ObjProd);
        ArrayLocales.add(indexLocal, ObjLocal);
        try {
            LogicaLocal.EscribirLocalesDAT(ArrayLocales);
        } catch (IOException ex) {
            Logger.getLogger(GUI_Bodeguero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed
        // TODO add your handling code here:
        if (objLogBod.validarBodeguero(ArrayLocales, this.jTextCedula.getText(), String.valueOf(this.jPassword.getPassword()))) {
            Local ObjLocal = ObjLogLoc.BuscarConBodeguero(ArrayLocales, jTextCedula.getText());
            this.jTextNombreLocal.setText(ObjLocal.getNombre());
            this.jTextCanti.setEnabled(true);
            this.jTextCod.setEnabled(true);
            this.jTextNom.setEnabled(true);
            this.jTextPrec.setEnabled(true);
            this.jTextVenc.setEnabled(true);
            this.jButtonAgregar.setEnabled(true);
            this.jTextCedula.setEnabled(false);
            this.jPassword.setEnabled(false);
            CargarInventario();
        } else {
            JOptionPane.showMessageDialog(null, "No existe", "Erroe", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jButtonIngresarActionPerformed

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        new Inicio().setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAtrasActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Bodeguero_V2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Bodeguero_V2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Bodeguero_V2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Bodeguero_V2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Bodeguero_V2().setVisible(true);
            }
        });
    }

    void CargarInventario() {
        
        Object columnas[] = {
            "Codigo", "Nombre", "Cantidad", "Precio", "Vencimiento"
        };
        DefaultTableModel model = new DefaultTableModel(null, columnas);
        Local objLocal = ObjLogLoc.BuscarConBodeguero(ArrayLocales, jTextCedula.getText());
        this.jTableInventario.setModel(model);
        for (Inventario objInv : objLocal.getInventarioGeneral()) {
            String NewValor[] = {
                objInv.getProducto().getCodigo(),
                objInv.getProducto().getNombre(),
                String.valueOf(objInv.getCantidad()),
                String.valueOf(objInv.getProducto().getPrecio()),
                objInv.getProducto().getVencimiento()
            };
            model.addRow(NewValor);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableInventario;
    private javax.swing.JTextField jTextCanti;
    private javax.swing.JTextField jTextCedula;
    private javax.swing.JTextField jTextCod;
    private javax.swing.JTextField jTextNom;
    private javax.swing.JTextField jTextNombreLocal;
    private javax.swing.JTextField jTextPrec;
    private javax.swing.JTextField jTextVenc;
    // End of variables declaration//GEN-END:variables
}
