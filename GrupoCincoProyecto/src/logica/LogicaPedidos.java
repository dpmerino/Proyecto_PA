/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import archivos.DATPedido;
import clases.Inventario;
import clases.Pedido;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author diegomerino
 */
public class LogicaPedidos {

    static String fichero = "archivos/pedidos.dat";
    DATPedido objDatPed = new DATPedido();
    LogicaCliente objLogCli = new LogicaCliente();
    LogicaLocal objLogLoc = new LogicaLocal();
    LogicaVendedor objLogicaVendedor = new LogicaVendedor();

    public static void EscribirPedidosDAT(ArrayList ArrayObjetos) throws IOException {
        archivos.ArchivoGeneral.EscribirDAT(ArrayObjetos, fichero);
    }

    public static void LeerPedidosDAT(ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException {
        archivos.ArchivoGeneral.LeerDAT(ArrayObjetos, fichero);
    }

    public static ArrayList<Pedido> BuscarPedidosLocal(ArrayList<Pedido> ArrayPedidos, String codigoLocal) {
        ArrayList<Pedido> pedidosLocales = new ArrayList<>();
        for (Pedido objPed : ArrayPedidos) {
            if (objPed.getFarmacia().getCodigo().equals(codigoLocal)) {
                pedidosLocales.add(objPed);
            }
        }
        return pedidosLocales;
    }

    public void InsetarPedido(Pedido pedido) throws ClassNotFoundException, SQLException {
        int idCli = objLogCli.ConsultarIDCliente(pedido.getCliente().getCedula());
        System.out.println(pedido.getFarmacia().getCodigo());
        int idLoc = objLogLoc.ConsultarIDLocal(pedido.getFarmacia().getCodigo());
        System.out.println(idLoc);
        //int idVen = objLogicaVendedor.ConsultarIDVendedor(pedido.getVendedor().getCedula());
        int idVen = 1;
        objDatPed.InsertarPedido(pedido, idCli, idLoc, idVen);
    }

    public int ConsultarIDPedido(String cedula) throws ClassNotFoundException, SQLException {
        int id = 0;
        ResultSet rs = objDatPed.ConsultarPedidosConCedula(cedula);
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
                if (columnName.equals("idPedido")) {
                    id = Integer.parseInt(value);
                }
            }
        }
        return id;
    }
}
