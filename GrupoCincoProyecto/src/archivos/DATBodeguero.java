/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import clases.Bodeguero;
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
public class DATBodeguero {

    DATConexion con = new DATConexion();
    ResultSet rs;
    PreparedStatement ps = null;

    public ResultSet ConsultarBodeguero() throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELCT * FROM Bodeguero";
        rs = st.executeQuery(sentencia);
        return rs;
    }

    public ResultSet ConsultarBodegueroConCedula(String cedula) throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM admin WHERE cedula = " + cedula;
        rs = st.executeQuery(sentencia);
        return rs;
    }

    public boolean InsertarBodeguero(Bodeguero bodeguero) {
        String sql = "INSERT INTO bodeguero (cedula, nombre, apellido, mail, clave, turno, sueldo) "
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            ps = con.AbrirConexion().prepareStatement(sql);
            ps.setString(1, bodeguero.getCedula());
            ps.setString(2, bodeguero.getNombre());
            ps.setString(3, bodeguero.getApellido());
            ps.setString(4, bodeguero.getMail());
            ps.setString(5, bodeguero.getClave());
            ps.setInt(6, bodeguero.getTurno());
            ps.setDouble(7, bodeguero.getSueldo());
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
