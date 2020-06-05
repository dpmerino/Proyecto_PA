/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import clases.Pedido;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author diegomerino
 */
public class LogicaPedidos {
    
    static String fichero = "archivos/pedidos.dat";
    
    public static void EscribirPedidosDAT (ArrayList ArrayObjetos) throws IOException{
        archivos.ArchivoGeneral.EscribirDAT(ArrayObjetos, fichero);
    }
    
    public static void LeerPedidosDAT (ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException{
        archivos.ArchivoGeneral.LeerDAT(ArrayObjetos, fichero);
    }
    
    public static ArrayList<Pedido> BuscarPedidosLocal(ArrayList<Pedido> ArrayPedidos, String codigoLocal){
        ArrayList<Pedido> pedidosLocales = new ArrayList<>();
        for (Pedido objPed : ArrayPedidos){
            if(objPed.getFarmacia().getCodigo().equals(codigoLocal))
                pedidosLocales.add(objPed);
        }
        return pedidosLocales;
    }
}
