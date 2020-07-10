/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import archivos.DATAdmin;
import clases.Administrador;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 */
public class LogicaAdmin {

    static String fichero = "archivos/admins.dat";
    DATAdmin objDatAdmin = new DATAdmin();

    public static void EscribirAdminDAT(ArrayList ArrayObjetos) throws IOException {
        archivos.ArchivoGeneral.EscribirDAT(ArrayObjetos, fichero);
    }

    public static void LeerAdminDAT(ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException {
        archivos.ArchivoGeneral.LeerDAT(ArrayObjetos, fichero);
    }

    public Boolean validarAdmin(ArrayList<Administrador> ArrayAdmins, String cedula, String clave) {
        for (Administrador objAdm : ArrayAdmins) {
            if (objAdm.getCedula().equals(cedula) && objAdm.getClave().equals(clave)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean ExistenciaAdmin(ArrayList<Administrador> ArrayAdmin, String cedula) {
        boolean flag = false;
        for (Administrador objAdmin : ArrayAdmin) {
            if (objAdmin.getCedula().equals(cedula)) {
                flag = true;
            }
        }
        return flag;
    }

    public void InsertarAdmin(Administrador admin) throws SQLException, ClassNotFoundException {
         objDatAdmin.InsertarAdmin(admin);
    }
    
    public Administrador ConsultarAdminConCedula(String Cedula) throws ClassNotFoundException, SQLException{
        Administrador objAdmin= new Administrador();
        ResultSet rs = objDatAdmin.ConsultarAdminConCedula(Cedula);
        ResultSetMetaData rm = rs.getMetaData();
        //Recupera los campos de la tabla
        int columnCount = rm.getColumnCount();
        ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        //Envia los datos a la Clase
        while (rs.next()) {
            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("cedula"))
                    objAdmin.setCedula(value);
                if (columnName.equals("nombre"))
                    objAdmin.setNombre(value);
                if (columnName.equals("apellido"))
                    objAdmin.setApellido(value);
                if (columnName.equals("mail"))
                    objAdmin.setMail(value);
                if (columnName.equals("clave"))
                    objAdmin.setClave(value);                
            }
        }
        return objAdmin;
    }
}
