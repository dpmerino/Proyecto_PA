/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import clases.Inventario;
import clases.Producto;
import java.util.ArrayList;

/**
 *
 * @author diegomerino
 */
public class LogicaInventario {

    public static Inventario BuscarProducto(ArrayList<Inventario> Inventario, String codigo) {
        Inventario objInv = new Inventario();
        for (Inventario objAux : Inventario){
            if(objAux.producto.getCodigo().equals(codigo))
                objAux = objInv;
        }
        return objInv;
    }
    public static double valor (ArrayList<Inventario> listaInventario){
        double total = 0.0;
        for (Inventario objInv : listaInventario){
            total += objInv.getProducto().getPrecio();
        }
        return total;
    }
}
