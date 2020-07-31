/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import archivos.DATInventario;
import clases.Cliente;
import clases.Inventario;
import clases.Local;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author diegomerino
 */
public class LogicaInventario {

    DATInventario objDatInv = new DATInventario();
    LogicaLocal objLogLoc = new LogicaLocal();

    public static Inventario BuscarProducto(ArrayList<Inventario> Inventario, String codigo) {
        Inventario objInv = new Inventario();
        for (Inventario objAux : Inventario) {
            if (objAux.producto.getCodigo().equals(codigo)) {
                objAux = objInv;
            }
        }
        return objInv;
    }

    public static double valor(ArrayList<Inventario> listaInventario) {
        double total = 0.0;
        for (Inventario objInv : listaInventario) {
            total += objInv.getProducto().getPrecio();
        }
        return total;
    }

    public static Inventario buscarPro(ArrayList<Local> ArrayLocales, String codigo) {
        Inventario objInv = new Inventario();
        for (Local objLoc : ArrayLocales) {
            for (int i = 0; i < objLoc.getInventarioGeneral().size(); i++) {
                if (objLoc.getInventarioGeneral().get(i).getProducto().getCodigo().equals(codigo)) {
                    objInv = objLoc.getInventarioGeneral().get(i);
                }
            }
        }
        return objInv;
    }

    public ArrayList<Inventario> LeerInventario(ArrayList<Inventario> ArrayInventario, int idLoc) throws ClassNotFoundException, SQLException {
        ResultSet rs = objDatInv.ConsultarInventarioDeLocal(idLoc);
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
            Inventario objInven = new Inventario();
            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("cantidad")) {
                    objInven.setCantidad(Integer.parseInt(value));
                }
                if (columnName.equals("codigo")) {
                    objInven.setCodigo(value);
                }
                if (columnName.equals("nombre")) {
                    objInven.setNombre(value);
                }
                if (columnName.equals("precio")) {
                    objInven.setPrecio(Double.parseDouble(value));
                }
            }
            ArrayInventario.add(objInven);
        }
        return ArrayInventario;
    }

    public void InsertarInventario(Inventario inventario) throws ClassNotFoundException, SQLException {
        int idLoc = objLogLoc.ConsultarIDLocal(inventario.getLocal().getCodigo());
        objDatInv.InsertarInventario(inventario, idLoc);
    }

    public Inventario BuscarInventarioConCodigo(String codigo) throws ClassNotFoundException, SQLException {
        Inventario objInv = new Inventario();
        ResultSet rs = objDatInv.BuscarProducto(codigo);
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
                if (columnName.equals("codigo")) {
                    objInv.setCodigo(value);
                }
                if (columnName.equals("nombre")) {
                    objInv.setNombre(value);
                }
                if (columnName.equals("precio")) {
                    objInv.setPrecio(Double.parseDouble(value));
                }
            }
        }
        return objInv;
    }

    public Inventario BuscarInventarioDelLocal(String codigo, int idLoc) throws ClassNotFoundException, SQLException {
        Inventario objInv = new Inventario();
        ResultSet rs = objDatInv.BuscarProducto(codigo);
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
                if (columnName.equals("codigo")) {
                    objInv.setCodigo(value);
                }
                if (columnName.equals("nombre")) {
                    objInv.setNombre(value);
                }
                if (columnName.equals("precio")) {
                    objInv.setPrecio(Double.parseDouble(value));
                }
                if (columnName.equals("cantidad")) {
                    objInv.setCantidad(Integer.parseInt(value));
                }
            }
        }
        return objInv;
    }

    public int BuscarCantidadDeInventario(String codigo) throws ClassNotFoundException, SQLException {
        int cantidad = 0;
        ResultSet rs = objDatInv.BuscarProducto(codigo);
        ResultSetMetaData rm = rs.getMetaData();
        int columnCount = rm.getColumnCount();
        ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        while (rs.next()) {
            for (String colunmName : columnas) {
                String value = rs.getString(colunmName);
                if (colunmName.equals("cantidad")) {
                    cantidad = Integer.valueOf(value);
                }
            }
        }
        return cantidad;
    }

    public void actulizarInventarioMediantePedido(Inventario objInv) throws ClassNotFoundException, SQLException {
        System.out.println(objInv.getLocal().getCodigo());
        int idLocal = objLogLoc.ConsultarIDLocal(objInv.getLocal().getCodigo());
        int cantidadActual = BuscarCantidadDeInventario(objInv.getCodigo());
        System.out.println("Actual " + cantidadActual);
        System.out.println("Objeto " + objInv.getCantidad());
        int cantidadNueva = cantidadActual - objInv.getCantidad();
        objDatInv.ActualizarInventarioPedido(objInv, idLocal, cantidadNueva);
    }
    
    public boolean ActulizarInventarioBodeguero(Inventario objInv) throws ClassNotFoundException, SQLException{
        int idLocal = objLogLoc.ConsultarIDLocal(objInv.getLocal().getCodigo());
        return objDatInv.ActualizarInvetarioBodeguero(objInv, idLocal);
    }
}
