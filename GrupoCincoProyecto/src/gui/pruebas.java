/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import clases.Bodeguero;
import clases.Cliente;
import clases.Inventario;
import clases.Local;
import clases.Vendedor;
import java.sql.SQLException;
import logica.LogicaBodeguero;
import logica.LogicaCliente;
import logica.LogicaInventario;
import logica.LogicaLocal;
import logica.LogicaVendedor;

/**
 *
 * @author diegomerino
 */
public class pruebas {
    static LogicaVendedor objLogVen = new LogicaVendedor();
    static LogicaLocal objLogLoc = new LogicaLocal();
    static Local local;
    
    static LogicaBodeguero objLogBod = new LogicaBodeguero();
    static LogicaCliente objLogCli = new LogicaCliente();
    static LogicaInventario objLogInv = new LogicaInventario();
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        local = objLogLoc.ConsultarLocalConCodigo("eco1");
//        int idLoc = objLogLoc.ConsultarIDLocal(local.getCodigo());
//        Vendedor objVen = new Vendedor(local, 1, 700, "17888", "juan", "opablo", "asdfa", "jjjjj");
//        objLogVen.InsertarVendedor(objVen, idLoc);
////            Bodeguero bod = objLogBod.ConsultarBodegueroConCedula("2222");
////            System.out.println(bod);
//        Cliente objCli = new Cliente("Azuay y 18 de nov", "097784", "David", "Sanchez", "ds@gmail.com", "dddd");
//        objLogCli.InsertarCliente(objCli);
//    Inventario objInv = new Inventario(33, "005", "Finalin", 0.50, local);
//    objLogInv.InsertarInventario(objInv);
int idLoc = objLogLoc.ConsultarIDLocalConNombre("ahorro");
        System.out.println(idLoc);
    }
}
