/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import archivos.DATVendedor;
import clases.Gerente;
import clases.Local;
import clases.Vendedor;
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
 */
public class LogicaVendedor {

    static String fichero = "archivos/vendedores.dat";
    DATVendedor objDatVen = new DATVendedor();

    public static void EscribirVendedorDAT(ArrayList ArrayVendedores) throws IOException {
        archivos.ArchivoGeneral.EscribirDAT(ArrayVendedores, fichero);
    }

    public static void LeerVendedoresDAT(ArrayList ArrayVendedores) throws IOException, FileNotFoundException, ClassNotFoundException {
        archivos.ArchivoGeneral.LeerDAT(ArrayVendedores, fichero);
    }

    public Boolean ValidarVendedor(ArrayList<Local> Farmacias, String cedula, String clave) {
        for (Local objVen : Farmacias) {
            if (objVen.getVendedor().getCedula().equals(cedula) && objVen.getVendedor().getClave().equals(clave)) {
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
    
    public void InsertarVendedor (Vendedor vendedor, int idLoc){
        objDatVen.InsertarVendedor(vendedor, idLoc);
    }
    
    public Vendedor ConsultarVendedorConCedula(String Cedula) throws ClassNotFoundException, SQLException {
        Vendedor objVendedor = new Vendedor();
        ResultSet rs = objDatVen.ConsultarVendedorCedula(Cedula);
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
                if (columnName.equals("cedula")) {
                    objVendedor.setCedula(value);
                }
                if (columnName.equals("nombre")) {
                    objVendedor.setNombre(value);
                }
                if (columnName.equals("apellido")) {
                    objVendedor.setApellido(value);
                }
                if (columnName.equals("mail")) {
                    objVendedor.setMail(value);
                }
                if (columnName.equals("clave")) {
                    objVendedor.setClave(value);
                }
                if (columnName.equals("turno")) {
                    objVendedor.setTurno(Integer.parseInt(value));
                }
                if (columnName.equals("sueldo")) {
                    objVendedor.setSueldo(Integer.parseInt(value));
                }
            }
        }
        return objVendedor;
    }

    public Vendedor ConsultarVendedorConID(int idVen) throws ClassNotFoundException, SQLException {
        Vendedor objVendedor = new Vendedor();
        ResultSet rs = objDatVen.ConsultarVendedorId(idVen);
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
                if (columnName.equals("cedula")) {
                    objVendedor.setCedula(value);
                }
                if (columnName.equals("nombre")) {
                    objVendedor.setNombre(value);
                }
                if (columnName.equals("apellido")) {
                    objVendedor.setApellido(value);
                }
                if (columnName.equals("mail")) {
                    objVendedor.setMail(value);
                }
                if (columnName.equals("clave")) {
                    objVendedor.setClave(value);
                }
                if (columnName.equals("turno")) {
                    objVendedor.setTurno(Integer.parseInt(value));
                }
                if (columnName.equals("sueldo")) {
                    objVendedor.setSueldo(Integer.parseInt(value));
                }
            }

        }
        return objVendedor;
    }

    public int ConsultarIDVendedor(String cedula) throws ClassNotFoundException, SQLException {
        ResultSet rs = objDatVen.ConsultarVendedorCedula(cedula);
        ResultSetMetaData rm = rs.getMetaData();
        //Recupera los campos de la tabla
        int columnCount = rm.getColumnCount();
        ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        //Envia los datos a la Clase
        int idVen = 0;
        while (rs.next()) {
            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("idGerente")) {
                    idVen = Integer.parseInt(value);
                }
            }
        }
        return idVen;
    }
}
