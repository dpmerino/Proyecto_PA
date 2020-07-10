/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import archivos.DATGerente;
import clases.Bodeguero;
import clases.Gerente;
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
public class LogicaGerente {

    static String fichero = "archivos/gerentes.dat";
    DATGerente objDatGer = new DATGerente();

    public static void EscribirGerenteDAT(ArrayList ArrayObjetos) throws IOException {
        archivos.ArchivoGeneral.EscribirDAT(ArrayObjetos, fichero);
    }

    public static void LeerGerenteDAT(ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException {
        archivos.ArchivoGeneral.LeerDAT(ArrayObjetos, fichero);
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

    public void InsertarGerente(Gerente gerente) {
        objDatGer.InsertarGerente(gerente);
    }

    public Gerente ConsultarGerenteConCedula(String Cedula) throws ClassNotFoundException, SQLException {
        Gerente objGerente = new Gerente();
        ResultSet rs = objDatGer.ConsultarGerenteConCedula(Cedula);
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
                    objGerente.setCedula(value);
                }
                if (columnName.equals("nombre")) {
                    objGerente.setNombre(value);
                }
                if (columnName.equals("apellido")) {
                    objGerente.setApellido(value);
                }
                if (columnName.equals("mail")) {
                    objGerente.setMail(value);
                }
                if (columnName.equals("clave")) {
                    objGerente.setClave(value);
                }
                if (columnName.equals("turno")) {
                    objGerente.setTurno(Integer.parseInt(value));
                }
                if (columnName.equals("sueldo")) {
                    objGerente.setSueldo(Integer.parseInt(value));
                }
            }
        }
        return objGerente;
    }

    public Gerente ConsultarGerenteId(int idGer) throws ClassNotFoundException, SQLException {
        Gerente objGerente = new Gerente();
        ResultSet rs = objDatGer.ConsultarGerenteId(idGer);
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
                    objGerente.setCedula(value);
                }
                if (columnName.equals("nombre")) {
                    objGerente.setNombre(value);
                }
                if (columnName.equals("apellido")) {
                    objGerente.setApellido(value);
                }
                if (columnName.equals("mail")) {
                    objGerente.setMail(value);
                }
                if (columnName.equals("clave")) {
                    objGerente.setClave(value);
                }
                if (columnName.equals("turno")) {
                    objGerente.setTurno(Integer.parseInt(value));
                }
                if (columnName.equals("sueldo")) {
                    objGerente.setSueldo(Integer.parseInt(value));
                }
            }

        }
        return objGerente;
    }

    public int ConsultarIDGerente(String cedula) throws ClassNotFoundException, SQLException {
        ResultSet rs = objDatGer.ConsultarGerenteConCedula(cedula);
        ResultSetMetaData rm = rs.getMetaData();
        //Recupera los campos de la tabla
        int columnCount = rm.getColumnCount();
        ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        //Envia los datos a la Clase
        int idGer = 0;
        while (rs.next()) {
            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("idGerente")) {
                    idGer = Integer.parseInt(value);
                }
            }
        }
        return idGer;
    }
}
