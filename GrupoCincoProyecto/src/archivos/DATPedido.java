/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import clases.Bodeguero;
import clases.Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diegomerino
 */
public class DATPedido {
    
    DATConexion con = new DATConexion();
    ResultSet rs;
    PreparedStatement ps = null;

    public ResultSet ConsultarPedidos() throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM pedido";
        rs = st.executeQuery(sentencia);
        return rs;
    }

    public ResultSet ConsultarPedidosConCedula(String cedula) throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT fecha, estado, total FROM pedido, cliente WHERE cliente.cedula = '"+ cedula +"' and cliente.idCliente = pedido.idCli";
        rs = st.executeQuery(sentencia);
        return rs;
    }

       public boolean InsertarPedido(Pedido pedido, int idCli, int idLoc, int idVen) {
        String sql = "INSERT INTO pedido (fecha, estado, total, idCli, idLoc, idVen) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            ps = con.AbrirConexion().prepareStatement(sql);
            ps.setString(1, pedido.getFecha());
            ps.setInt(2, pedido.getEstado());
            ps.setDouble(3, pedido.getValor());
            ps.setInt(4, idCli);
            ps.setInt(5, idLoc);
            ps.setInt(6, idVen);
            ps.execute();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DATGerente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                con.CerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(DATGerente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
