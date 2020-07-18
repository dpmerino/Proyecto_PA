/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import clases.Bodeguero;
import clases.Inventario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class DATInventario {

    DATConexion con = new DATConexion();
    ResultSet rs;
    PreparedStatement ps = null;

    public ResultSet ConsultarInventario() throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM inventario";
        rs = st.executeQuery(sentencia);
        return rs;
    }

    public ResultSet ConsultarInventarioDeLocal(int idLoc) throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM inventario WHERE idLoc = " + idLoc;
        rs = st.executeQuery(sentencia);
        return rs;
    }

    public ResultSet BuscarProducto(String codigo) throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM inventario WHERE codigo =" + codigo;
        rs = st.executeQuery(sentencia);
        return rs;
    }

    public boolean InsertarInventario(Inventario inventario, int idLoc) {
        String sql = "INSERT INTO inventario (cantidad, codigo, nombre, precio, idLoc) "
                + "VALUES (?,?,?,?,?)";
        try {
            ps = con.AbrirConexion().prepareStatement(sql);
            ps.setInt(1, inventario.getCantidad());
            ps.setString(2, inventario.getCodigo());
            ps.setString(3, inventario.getNombre());
            ps.setDouble(4, inventario.getPrecio());
            ps.setInt(5, idLoc);
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

    public boolean ActualizarInventarioPedido(Inventario objInv, int idLocal, int cantidad) {
        String sql = "UPDATE inventario SET cantidad = ? "
                + "WHERE codigo = ? and inventario.idLoc = ?";
        try {
            ps = con.AbrirConexion().prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setString(2, objInv.getCodigo());
            ps.setInt(3, idLocal);
            ps.execute();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.CerrarConexion();
            } catch (SQLException e) {
                System.err.println(3);
            }
        }
    }
}
