/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import clases.Bodeguero;
import clases.Vendedor;
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
public class DATVendedor {

    DATConexion con = new DATConexion();
    ResultSet rs;
    PreparedStatement ps = null;

    public ResultSet ConsultarVendedor() throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM Vendedor";
        rs = st.executeQuery(sentencia);
        return rs;
    }

    public ResultSet ConsultarVendedorCedula(String Cedula)
            throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM vendedor where cedula = " + Cedula;
        rs = st.executeQuery(Sentencia);
        return rs;
    }

    public ResultSet ConsultarVendedorId(int idVen)
            throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM vendedor where idVendedor = " + idVen;
        rs = st.executeQuery(Sentencia);
        return rs;
    }
    
    public boolean InsertarVendedor(Vendedor vendedor, int idLoc) {
        String sql = "INSERT INTO vendedor (cedula, nombre, apellido, mail, clave, turno, suledo, Local_idLocal) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        try {
            ps = con.AbrirConexion().prepareStatement(sql);
            ps.setString(1, vendedor.getCedula());
            ps.setString(2, vendedor.getNombre());
            ps.setString(3, vendedor.getApellido());
            ps.setString(4, vendedor.getMail());
            ps.setString(5, vendedor.getClave());
            ps.setInt(6, vendedor.getTurno());
            ps.setDouble(7, vendedor.getSueldo());
            ps.setInt(8, idLoc);
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
