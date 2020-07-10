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
public class DATBodeguero {

    DATConexion con = new DATConexion();
    ResultSet rs;
    PreparedStatement ps = null;

    public ResultSet ConsultarBodeguero() throws ClassNotFoundException, SQLException {
        Statement st = con.AbirConexion().createStatement();
        String sentencia = "SELCT * FROM Bodeguero";
        rs = st.executeQuery(sentencia);
        return rs;
    }
}
