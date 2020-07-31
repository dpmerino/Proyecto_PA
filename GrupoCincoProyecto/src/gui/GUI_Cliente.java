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
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
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
    ArrayList<Inventario> InventarioLocal = new ArrayList<>();
    ArrayList<Inventario> PedidoCliente = new ArrayList<>();
    ArrayList<Pedido> PedidosDelCliente = new ArrayList<>();

    LogicaLocal objLogLoc = new LogicaLocal();
    LogicaProducto objLogPro = new LogicaProducto();
    LogicaInventario objLogInv = new LogicaInventario();
    LogicaPedidos objLogPed = new LogicaPedidos();

    String fecha;
    Cliente objCli;
    Local objLocal;
    Inventario objInv;
    Pedido objPed;
    int idLocal = 0;
    int idCliente = 0;

    double total = 0.0;

    /**
     * Creates new form GUI_Cliente
     */
    public GUI_Cliente() {
        initComponents();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        fecha = sdf.format(new Date());
        this.jTextFecha.setText(fecha);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        try {
            try {
                objLogLoc.LeerLocales(ArrayFarmacias);
            } catch (SQLException ex) {
                Logger.getLogger(GUI_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePedidos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTextTotal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePedidosCliente = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButtonListarPedidos = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextNombreCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jTextCedula.setText("Cedula");
        jTextCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCedulaKeyTyped(evt);
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
        jTextCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCantidadKeyTyped(evt);
            }
        });

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

        jTablePedidos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablePedidos);

        jLabel5.setText("Total");

        jTextTotal.setEnabled(false);

        jTablePedidosCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTablePedidosCliente);

        jLabel6.setText("Lista de Pedidos");

        jButtonListarPedidos.setText("Listar");
        jButtonListarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarPedidosActionPerformed(evt);
            }
        });

        jLabel7.setText("Bienvenido");

        jTextNombreCliente.setEnabled(false);

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
                                .addComponent(jScrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButtonAgregar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonGuardar)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonListarPedidos)
                                        .addGap(155, 155, 155))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jTextCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jPasswordClave, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jButtonIngresar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonNuevoCliente)
                                        .addGap(0, 0, 0)
                                        .addComponent(jButton1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboFarmacias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonListar)
                                        .addGap(19, 19, 19)
                                        .addComponent(jTextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addGap(28, 28, 28)
                                        .addComponent(jTextNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(222, 222, 222))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabel4)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIngresar)
                    .addComponent(jButtonNuevoCliente)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboFarmacias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonListar)
                    .addComponent(jTextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jTextNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jButtonAgregar)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jTextTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(78, 78, 78)
                                .addComponent(jButtonGuardar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonListarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed
        try {
            // TODO add your handling code here:
            objCli = objLogCli.ConsultarClienteConCedula(this.jTextCedula.getText());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GUI_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (objCli.getCedula().equals(this.jTextCedula.getText()) && objCli.getClave().equals(String.valueOf(this.jPasswordClave.getPassword()))) {
            try {
                idCliente = objLogCli.ConsultarIDCliente(objCli.getCedula());
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(GUI_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            CargarCombo();
            this.jTextNombreCliente.setText(objCli.getNombre());
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
        // TODO add your handling code here:
        ArrayFarmacias.removeAll(ArrayFarmacias);
        idLocal = 0;
        try {
            idLocal = objLogLoc.ConsultarIDLocalConNombre(this.jComboFarmacias.getModel().getSelectedItem().toString());
            objLogInv.LeerInventario(InventarioLocal, idLocal);
            objLocal = objLogLoc.ConsultarLocalId(idLocal);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GUI_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        Object columnas[] = {
            "Nombre", "Codigo", "Precio", "Cantidad"
        };
        DefaultTableModel model = new DefaultTableModel(null, columnas);
        this.jTable1.setModel(model);
        for (Inventario objInv : InventarioLocal) {
            String NewValor[] = {
                objInv.getNombre(),
                objInv.getCodigo(),
                String.valueOf(objInv.getPrecio()),
                String.valueOf(objInv.getCantidad())
            };
            model.addRow(NewValor);
        }
    }//GEN-LAST:event_jButtonListarActionPerformed

    private void jComboFarmaciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboFarmaciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboFarmaciasActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        objInv = new Inventario();
        try {
            objInv = objLogInv.BuscarInventarioDelLocal(this.jTextCodigo.getText(), idLocal);
            objInv.setCantidad(Integer.parseInt(this.jTextCantidad.getText()));
            objInv.setLocal(objLocal);
            total = total + (objInv.getCantidad() * objInv.getPrecio());
            System.out.println(total);
            PedidoCliente.add(objInv);
            objLogInv.actulizarInventarioMediantePedido(objInv);
            CargarInventario();
            CargarPedidos();
            this.jTextTotal.setText(String.valueOf(total));
            this.jTextCantidad.setText("");
            this.jTextCodigo.setText("");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GUI_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        objPed = new Pedido();
        objPed.setCliente(objCli);
        objPed.setEstado(1);
        objPed.setFecha(sqlDate);
        objPed.setValor(total);
        objPed.setFarmacia(objLocal);
        objPed.setProductosPedidos(PedidoCliente);
        try {
            objLogPed.InsetarPedido(objPed);
            int idPedido = objLogPed.ConsultarIDPedido(objCli.getCedula());
            for (Inventario objAuxInv : PedidoCliente) {
                objLogInv.InsertarDetalle(objAuxInv, idPedido);
            }
            JOptionPane.showMessageDialog(null, "Pedido Ingresado en la farmacia " + objLocal.getNombre());
        } catch (ClassNotFoundException | SQLException ex) {
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

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

// TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void jTextCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCantidadKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese solo numeros");
        }
    }//GEN-LAST:event_jTextCantidadKeyTyped

    private void jButtonListarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarPedidosActionPerformed
        try {
            PedidosDelCliente.removeAll(PedidosDelCliente);
            // TODO add your handling code here:
            objLogPed.LeerPedidosCliente(PedidosDelCliente, idCliente);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GUI_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        this.jTablePedidosCliente.setModel(tb);
        Object columnas[] = {
            "estado", "total", "nombre", "direccion"
        };
        DefaultTableModel model = new DefaultTableModel(null, columnas);
        this.jTablePedidosCliente.setModel(model);
        for (Pedido objAuxPed : PedidosDelCliente) {
            String NewValor[] = {
                String.valueOf(objAuxPed.getEstado()),
                String.valueOf(objAuxPed.getValor()),
                objAuxPed.getFarmacia().getNombre(),
                objAuxPed.getFarmacia().getDireccion()
            };
            model.addRow(NewValor);
        }
    }//GEN-LAST:event_jButtonListarPedidosActionPerformed

    private void jTextCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCedulaKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese solo numeros");
        }
    }//GEN-LAST:event_jTextCedulaKeyTyped

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

    public void CargarPedidos() {
        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        this.jTablePedidos.setModel(tb);
        Object columnas[] = {
            "Nombre", "Codigo", "Precio", "Cantidad"
        };
        DefaultTableModel model = new DefaultTableModel(null, columnas);
        this.jTablePedidos.setModel(model);
        for (Inventario objInv : PedidoCliente) {
            String NewValor[] = {
                objInv.getNombre(),
                objInv.getCodigo(),
                String.valueOf(objInv.getPrecio()),
                String.valueOf(objInv.getCantidad())
            };
            model.addRow(NewValor);
        }
    }

    public void CargarInventario() {
        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        this.jTable1.setModel(tb);
        InventarioLocal.removeAll(InventarioLocal);
        try {
            idLocal = objLogLoc.ConsultarIDLocalConNombre(this.jComboFarmacias.getModel().getSelectedItem().toString());
            objLogInv.LeerInventario(InventarioLocal, idLocal);
            objLocal = objLogLoc.ConsultarLocalId(idLocal);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GUI_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        Object columnas[] = {
            "Nombre", "Codigo", "Precio", "Cantidad"
        };
        DefaultTableModel model = new DefaultTableModel(null, columnas);
        this.jTable1.setModel(model);
        for (Inventario objInv : InventarioLocal) {
            String NewValor[] = {
                objInv.getNombre(),
                objInv.getCodigo(),
                String.valueOf(objInv.getPrecio()),
                String.valueOf(objInv.getCantidad())
            };
            model.addRow(NewValor);
        }
    }

    public void CargarCombo() {
        logica.ValorCombo objCargar = new ValorCombo();
        this.jComboFarmacias.setModel(new DefaultComboBoxModel(objCargar.cargarLocal(ArrayFarmacias).toArray()));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonIngresar;
    private javax.swing.JButton jButtonListar;
    private javax.swing.JButton jButtonListarPedidos;
    private javax.swing.JButton jButtonNuevoCliente;
    private javax.swing.JComboBox<String> jComboFarmacias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPasswordClave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollTabla;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTablePedidos;
    private javax.swing.JTable jTablePedidosCliente;
    private javax.swing.JTextField jTextCantidad;
    private javax.swing.JTextField jTextCedula;
    private javax.swing.JTextField jTextCodigo;
    private javax.swing.JTextField jTextFecha;
    private javax.swing.JTextField jTextNombreCliente;
    private javax.swing.JTextField jTextTotal;
    // End of variables declaration//GEN-END:variables
}
