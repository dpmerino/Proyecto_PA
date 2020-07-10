/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import archivos.DATLocal;
import clases.Bodeguero;
import clases.Inventario;
import clases.Local;
import clases.Producto;
import clases.Vendedor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class LogicaLocal {
    
    static String fichero = "archivos/locales.dat";
    DATLocal objDatLoc = new DATLocal();
    LogicaGerente objLogGer = new LogicaGerente();
    LogicaBodeguero objLogBod = new LogicaBodeguero();
    LogicaVendedor objLogVen = new LogicaVendedor();
    
    public static void EscribirLocalesDAT(ArrayList ArrayObjetos) throws IOException {
        archivos.ArchivoGeneral.EscribirDAT(ArrayObjetos, fichero);
    }
    
    public static void LeerLocalesDAT(ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException {
        archivos.ArchivoGeneral.LeerDAT(ArrayObjetos, fichero);
    }
    
    public static Local BuscarLocal(ArrayList<Local> ArrayFarmacias, String codigo) {
        Local objLocAux = new Local();
        for (Local objLoc : ArrayFarmacias) {
            if (objLoc.getNombre().equals(codigo)) {
                objLocAux = objLoc;
            }
        }
        return objLocAux;
    }
    
    public static boolean AgregarIventario(Local ObjLocal,
            int cantidad, Producto producto) {
        if (1 == 0 && 2 == 1) {
            for (Inventario objInv : ObjLocal.getInventarioGeneral()) {
                if (String.valueOf(objInv.cantidad).equals(cantidad)
                        && objInv.producto.equals(producto)) {
                    return false;
                } else {
                    ObjLocal.AgregarInventario(cantidad, producto);
                }
            }
        }
        
        ObjLocal.inventarioGeneral.add(new Inventario(cantidad, producto));
        return true;
    }
    
    public static Local AddInventario(Local objLocal, int cantidad, Producto producto) {
        objLocal.inventarioGeneral.add(new Inventario(cantidad, producto));
        return objLocal;
    }
    
    public static Boolean ExistenciaLocal(ArrayList<Local> ArrayFarmacias, String codigo) {
        boolean flag = false;
        for (Local objLocal : ArrayFarmacias) {
            if (objLocal.getCodigo().equals(codigo)) {
                flag = true;
            }
        }
        return flag;
    }
    
     public static Local BuscarConBodeguero(ArrayList<Local> ArrayFarmacias, String cedula) {
        Local objLocal = new Local();
        for (Local objAuxLoc : ArrayFarmacias) {
            if (objAuxLoc.getBodeguero().getCedula().equals(cedula)) {
                objLocal = objAuxLoc;
            }
        }
        return objLocal;
    }
     public  ArrayList<Local> LeerLocales(ArrayList<Local> ArrayLocales) throws ClassNotFoundException, SQLException{
        ResultSet rs = objDatLoc.ConsultarLocal();
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
            Local objLocal= new Local();
            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("nombre"))
                    objLocal.setNombre(value);
                if (columnName.equals("codigo"))
                    objLocal.setCodigo(value);
                if (columnName.equals("direccion"))
                    objLocal.setDireccion(value);               
            }
            ArrayLocales.add(objLocal);
        }
        return ArrayLocales;
    }
    
    public Local ConsultarLocalConCodigo(String codigo) throws ClassNotFoundException, SQLException {
        Local objLocal = new Local();
        ResultSet rs = objDatLoc.ConsultarLocalCodigo(codigo);
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
                if (columnName.equals("nombre")) {
                    objLocal.setNombre(value);
                }
                if (columnName.equals("codigo")) {
                    objLocal.setCodigo(value);
                }
                if (columnName.equals("direccion")) {
                    objLocal.setDireccion(value);
                }
            }
        }
        return objLocal;
    }
    
    public Local ConsultarLocalId(int idLoc) throws ClassNotFoundException, SQLException {
        Local objLoc = new Local();
        ResultSet rs = objDatLoc.ConsultarLocalID(idLoc);
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
                if (columnName.equals("nombre")) {
                    objLoc.setNombre(value);
                }
                if (columnName.equals("codigo")) {
                    objLoc.setCodigo(value);
                }
                if (columnName.equals("direccion")) {
                    objLoc.setDireccion(value);
                }
            }
        }
        return objLoc;
    }

    public int ConsultarIDLocalConNombre(String nombre) throws ClassNotFoundException, SQLException {
        ResultSet rs = objDatLoc.ConsultarLocalNombre(nombre);
        ResultSetMetaData rm = rs.getMetaData();
        //Recupera los campos de la tabla
        int columnCount = rm.getColumnCount();
        ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        //Envia los datos a la Clase
        int idLoc = 0;
        while (rs.next()) {
            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("idLocal")) {
                    idLoc = Integer.parseInt(value);
                }
            }
        }
        return idLoc;
    }
    
    public int ConsultarIDLocal(String codigo) throws ClassNotFoundException, SQLException {
        ResultSet rs = objDatLoc.ConsultarLocalCodigo(codigo);
        ResultSetMetaData rm = rs.getMetaData();
        //Recupera los campos de la tabla
        int columnCount = rm.getColumnCount();
        ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        //Envia los datos a la Clase
        int idLoc = 0;
        while (rs.next()) {
            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("idLocal")) {
                    idLoc = Integer.parseInt(value);
                }
            }
        }
        return idLoc;
    }
    
    public void InsertarLocal(Local local, Vendedor vendedor) throws ClassNotFoundException, SQLException {
        //Se insertan los objetos
        objLogGer.InsertarGerente(local.getGerente());
        objLogBod.InsertarBodeguero(local.getBodeguero());
        //Se obtienen los ID
        int idGer = objLogGer.ConsultarIDGerente(local.getGerente().getCedula());
        int idBod = objLogBod.ConsultarIDBodeguero(local.getBodeguero().getCedula());
        //Se inserta el local con los gerentes y bodegueros
        objDatLoc.InsertarLocal(local, idGer, idBod);
        
        int idLoc = ConsultarIDLocal(local.getCodigo());
        
        objLogVen.InsertarVendedor(vendedor, idLoc);
    }
}
