/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import clases.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 */
public class DATCLiente {

    DATConexion con = new DATConexion();
    ResultSet rs;
    PreparedStatement ps = null;

    public ResultSet ConsultarCliente() throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM cliente";
        rs = st.executeQuery(sentencia);
        return rs;
    }
    
    public ResultSet ConsultarClienteConCedula(String cedula) throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM cliente WHERE cedula = " + cedula;
        rs = st.executeQuery(sentencia);
        return rs;
    }

    public ResultSet ConsultarClienteConID(int idCli)
            throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM cliente where idCliente = " + idCli;
        rs = st.executeQuery(Sentencia);
        return rs;
    }

    public boolean InsertarExterno(Cliente ObjExterno) throws SQLException,
            ClassNotFoundException {
        String sql = "INSERT INTO cliente (cedula, nombre, apellido, mail, clave, direccion) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            ps = con.AbrirConexion().prepareStatement(sql);
            ps.setString(1, ObjExterno.getCedula());
            ps.setString(2, ObjExterno.getNombre());
            ps.setString(3, ObjExterno.getApellido());
            ps.setString(4, ObjExterno.getMail());
            ps.setString(5, ObjExterno.getClave());
            ps.setString(6, ObjExterno.getDireccion());
            ps.execute();
            System.out.println("Cliente insertado");
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
