/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import archivos.ArchivoGeneral;
import clases.Inventario;
import clases.Producto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *

 */
public class LogicaProducto {
    static String fichero = "productos.dat";
    
    public static void EscribirProductos(ArrayList ArrayObjetos) throws IOException {
        // elimina todo lo del archivo y escribe
        ArchivoGeneral.EscribirDAT(ArrayObjetos, fichero);
    }

    public static void LeerProductos(ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArchivoGeneral.LeerDAT(ArrayObjetos,fichero);
    }
    public static void InsertarProductos(ArrayList ArrayObjetos) throws IOException {
        // agregar objetos sobre lo que toene el archivo
        ArchivoGeneral.anhadeFichero(ArrayObjetos,fichero);
    }
    
    public static Producto BuscarProducto(ArrayList<Inventario> Inventario, String codigo){
        Producto objPro = new Producto();
        for (Inventario objAux : Inventario){
            if(objAux.getProducto().getCodigo().equals(codigo))
                objPro = objAux.getProducto();
        }
        return objPro;
    }
    
}
