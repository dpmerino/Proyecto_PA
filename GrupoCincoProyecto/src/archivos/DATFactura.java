/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author diegomerino
 */
public class DATFactura {

    DATConexion con = new DATConexion();
    ResultSet rs;
    PreparedStatement ps = null;
    
    public ResultSet ConsultarFactura() throws ClassNotFoundException, SQLException{
        Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM Factura";
        rs = st.executeQuery(sentencia);
        return rs;
    }
}
