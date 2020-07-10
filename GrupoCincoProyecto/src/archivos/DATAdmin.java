/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import clases.Administrador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author diegomerino
 */
public class DATAdmin {

    DATConexion con = new DATConexion();
    ResultSet rs;
    PreparedStatement ps = null;

    public ResultSet ConsultarAdmins() throws ClassNotFoundException, SQLException {
        Statement st = con.AbirConexion().createStatement();
        String sentencia = "SELECT * from admin";
        rs = st.executeQuery(sentencia);
        return rs;
    }

    public boolean InsertarAdmin(Administrador admin) throws SQLException,
            ClassNotFoundException {
        String sql = "INSERT INTO admin (cedula, nombre, apellido, mail, clave) "
                + "VALUES (?,?,?,?,?)";
        try {
            ps = con.AbirConexion().prepareStatement(sql);
            ps.setString(1, admin.getCedula());
            ps.setString(2, admin.getNombre());
            ps.setString(3, admin.getApellido());
            ps.setString(4, admin.getMail());
            ps.setString(5, admin.getClave());
            ps.execute();
            return true;
        } catch (Exception e) {
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
