/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 */
public class DATConexion {

    public Connection con;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://den1.mysql1.gear.host:3306/grupo5";
        Class.forName(driver);
        return DriverManager.getConnection(url, "grupo5", "Ue8e6SnY_x-L");
    }

    public Connection AbrirConexion() throws ClassNotFoundException, SQLException {
        con = getConnection();
        return con;
    }

    public void CerrarConexion() throws SQLException {
        con.close();
    }
}
