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

/**
 *
 * @author diegomerino
 */
public class DATGerente {

    DATConexion con = new DATConexion();
    ResultSet rs;
    PreparedStatement ps = null;
    
    public ResultSet ConsultarGerente() throws ClassNotFoundException, SQLException{
        Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM Gerente";
        rs = st.executeQuery(sentencia);
        return rs;
    }
    
    public boolean InsertarGerente (Gerente gerente){
        String sql = "INSERT INTO gerente (cedula, nombre, apellido, mail, clave, turno, sueldo) "
                + "VALUES (?,?,?,?,?,?,?)";
    }
}
