/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import archivos.DATBodeguero;
import clases.Administrador;
import clases.Bodeguero;
import clases.Local;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 *
 */
public class LogicaBodeguero {

    static String fichero = "archivos/bodegueros.dat";
    DATBodeguero objDatBod = new DATBodeguero();

    public static void EscribirBodeguerosDAT(ArrayList ArrayObjetos) throws IOException {
        archivos.ArchivoGeneral.EscribirDAT(ArrayObjetos, fichero);
    }

    public static void LeerBodegueroDAT(ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException {
        archivos.ArchivoGeneral.LeerDAT(ArrayObjetos, fichero);
    }

    public Boolean validarBodeguero(ArrayList<Local> Farmacias, String cedula, String clave) {
        for (Local objLoc : Farmacias) {
            if (objLoc.getBodeguero().getCedula().equals(cedula) && objLoc.getBodeguero().getClave().equals(clave)) {
                return true;
            }
        }
        return false;
    }

    public boolean mailValido(String email) {
        Pattern pat
                = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = pat.matcher(email);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }
    
    public void InsertarBodeguero (Bodeguero objBod){
        objDatBod.InsertarBodeguero(objBod);
    }
    
    public Bodeguero ConsultarAdminConCedula(String Cedula) throws ClassNotFoundException, SQLException{
        Bodeguero objBodeguero= new Bodeguero();
        ResultSet rs = objDatBod.ConsultarBodegueroConCedula(Cedula);
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
                    objBodeguero.setCedula(value);
                if (columnName.equals("nombre"))
                    objBodeguero.setNombre(value);
                if (columnName.equals("apellido"))
                    objBodeguero.setApellido(value);
                if (columnName.equals("mail"))
                    objBodeguero.setMail(value);
                if (columnName.equals("clave"))
                    objBodeguero.setClave(value);                
            }
        }
        return objBodeguero;
    }
}
