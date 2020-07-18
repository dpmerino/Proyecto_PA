/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import clases.Local;
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
public class DATLocal {

    DATConexion con = new DATConexion();
    ResultSet rs;
    PreparedStatement ps = null;

    public ResultSet ConsultarLocal() throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM Local";
        rs = st.executeQuery(sentencia);
        return rs;
    }

    public ResultSet ConsultarLocalCodigo(String codigo)
            throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM local WHERE codigo = '" + codigo + "'";
        rs = st.executeQuery(Sentencia);
        return rs;
    }

    public ResultSet ConsultarLocalNombre(String nombre)
            throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM local WHERE nombre = '" + nombre + "'";
        rs = st.executeQuery(Sentencia);
        return rs;
    }
    public ResultSet ConsultarLocalConBodeguero(String cedula)
            throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String Sentencia = "SELECT nombre,codigo,direccion FROM local, bodeguero WHERE bodeguero.cedula = '" + cedula + "'"+"bodeguero.idBodeguero = local.idBog";
        rs = st.executeQuery(Sentencia);
        return rs;
    }

    public ResultSet ConsultarLocalID(int idLoc)
            throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM local where idLocal = " + idLoc;
        rs = st.executeQuery(Sentencia);
        return rs;
    }

    public boolean InsertarLocal(Local local, int idGer, int idBod) {
        String sql = "INSERT INTO local (nombre, codigo, direccion, idGer, idBod) "
                + "VALUES (?,?,?,?,?)";
        try {
            ps = con.AbrirConexion().prepareStatement(sql);
            ps.setString(1, local.getNombre());
            ps.setString(2, local.getCodigo());
            ps.setString(3, local.getDireccion());
            ps.setInt(4, idGer);
            ps.setInt(5, idBod);
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
