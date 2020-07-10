/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import archivos.DATCLiente;
import clases.Bodeguero;
import clases.Cliente;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 */
public class LogicaCliente {

    static String fichero = "archivos/clientes.dat";
    DATCLiente objDATCliente = new DATCLiente();

    public static void EscribirClientesDAT(ArrayList ArrayObjetos) throws IOException {
        archivos.ArchivoGeneral.EscribirDAT(ArrayObjetos, fichero);
    }

    public static void LeerClientesDAT(ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException {
        archivos.ArchivoGeneral.LeerDAT(ArrayObjetos, fichero);
    }

    public Boolean validarCliente(ArrayList<Cliente> ArrayClientes, String cedula, String clave) {
        for (Cliente objCli : ArrayClientes) {
            if (objCli.getCedula().equals(cedula) && objCli.getClave().equals(clave)) {
                return true;
            }
        }
        return false;
    }

    public static Cliente cargarCliente(ArrayList<Cliente> ArrayClientes, String cedula) {
        Cliente objCliente = new Cliente();
        for (Cliente objAux : ArrayClientes) {
            if (objAux.getCedula().equals(cedula)) {
                objCliente = objAux;
            }
        }
        return objCliente;
    }

    public static Boolean ExistenciaCliente(ArrayList<Cliente> ArrayCliente, String cedula) {
        boolean flag = false;
        for (Cliente objCliente : ArrayCliente) {
            if (objCliente.getCedula().equals(cedula)) {
                flag = true;
            }
        }
        return flag;
    }

    public void InsertarCliente(Cliente objeto) throws SQLException, ClassNotFoundException {
        objDATCliente.InsertarExterno(objeto);
    }

    public Cliente ConsultarClienteConCedula(String Cedula) throws ClassNotFoundException, SQLException {
        Cliente objCli = new Cliente();
        ResultSet rs = objDATCliente.ConsultarClienteConCedula(Cedula);
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
                    objCli.setCedula(value);
                }
                if (columnName.equals("nombre")) {
                    objCli.setNombre(value);
                }
                if (columnName.equals("apellido")) {
                    objCli.setApellido(value);
                }
                if (columnName.equals("mail")) {
                    objCli.setMail(value);
                }
                if (columnName.equals("clave")) {
                    objCli.setClave(value);
                }
                if (columnName.equals("direccion")) {
                    objCli.setDireccion(value);
                }
            }
        }
        return objCli;
    }

    public Cliente ConsultarClienteConID(int idCli) throws ClassNotFoundException, SQLException {
        Cliente objCli = new Cliente();
        ResultSet rs = objDATCliente.ConsultarClienteConID(idCli);
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
                    objCli.setCedula(value);
                }
                if (columnName.equals("nombre")) {
                    objCli.setNombre(value);
                }
                if (columnName.equals("apellido")) {
                    objCli.setApellido(value);
                }
                if (columnName.equals("mail")) {
                    objCli.setMail(value);
                }
                if (columnName.equals("clave")) {
                    objCli.setClave(value);
                }
                if (columnName.equals("direccion")) {
                    objCli.setDireccion(value);
                }
            }

        }
        return objCli;
    }

    public int ConsultarIDCliente(String cedula) throws ClassNotFoundException, SQLException {
        ResultSet rs = objDATCliente.ConsultarClienteConCedula(cedula);
        ResultSetMetaData rm = rs.getMetaData();
        //Recupera los campos de la tabla
        int columnCount = rm.getColumnCount();
        ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        //Envia los datos a la Clase
        int idCli = 0;
        while (rs.next()) {
            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("idCliente")) {
                    idCli = Integer.parseInt(value);
                }
            }
        }
        return idCli;
    }
}
