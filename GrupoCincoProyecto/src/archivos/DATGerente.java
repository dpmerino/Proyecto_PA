/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import clases.Gerente;
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
public class DATGerente {

    DATConexion con = new DATConexion();
    ResultSet rs;
    PreparedStatement ps = null;

    public ResultSet ConsultarGerente() throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM gerente";
        rs = st.executeQuery(sentencia);
        return rs;
    }

    public ResultSet ConsultarGerenteConCedula(String cedula) throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM gerente WHERE cedula = " + cedula;
        rs = st.executeQuery(sentencia);
        return rs;
    }

    public ResultSet ConsultarGerenteId(int idGer)
            throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM gerente where idGerente = " + idGer;
        rs = st.executeQuery(Sentencia);
        return rs;
    }

    public boolean InsertarGerente(Gerente gerente) {
        String sql = "INSERT INTO gerente (cedula, nombre, apellido, mail, clave, turno, sueldo) "
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            ps = con.AbrirConexion().prepareStatement(sql);
            ps.setString(1, gerente.getCedula());
            ps.setString(2, gerente.getNombre());
            ps.setString(3, gerente.getApellido());
            ps.setString(4, gerente.getMail());
            ps.setString(5, gerente.getClave());
            ps.setInt(6, gerente.getTurno());
            ps.setDouble(7, gerente.getSueldo());
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
