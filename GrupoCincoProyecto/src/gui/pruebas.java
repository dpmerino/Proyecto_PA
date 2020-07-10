/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import clases.Bodeguero;
import clases.Local;
import clases.Vendedor;
import java.sql.SQLException;
import logica.LogicaBodeguero;
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
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        local = objLogLoc.ConsultarLocalConCodigo("loc1");
        int idLoc = objLogLoc.ConsultarIDLocal(local.getCodigo());
        Vendedor objVen = new Vendedor(local, 700, 1, "17888", "juan", "opablo", "asdfa", "jjjjj");
        objLogVen.InsertarVendedor(objVen, idLoc);
////            Bodeguero bod = objLogBod.ConsultarBodegueroConCedula("2222");
////            System.out.println(bod);
    }
}
