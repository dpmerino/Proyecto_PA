/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import clases.Administrador;
import clases.Inventario;
import clases.Local;
import clases.Producto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class LogicaLocal {
    
    static String fichero = "archivos/locales.dat";
    
    public static void EscribriLocalesDAT (ArrayList ArrayObjetos) throws IOException{
        archivos.ArchivoGeneral.EscribirDAT(ArrayObjetos, fichero);
    }
    
    public static void LeerLocalesDAT (ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException{
        archivos.ArchivoGeneral.LeerDAT(ArrayObjetos, fichero);
    }
    
    public static Local BuscarLocal (ArrayList<Local> ArrayFarmacias, String codigo){
        Local objLocAux = new Local();
        for (Local objLoc : ArrayFarmacias){
            if(objLoc.getCodigo().equals(codigo))
                objLocAux = objLoc;
        } 
        return objLocAux;
    }
     public static boolean AgregarIventario(Local ObjLocal,
            int cantidad , Producto producto){   
        if (1==0 && 2==1)
        for (Inventario objInv : ObjLocal.getInventarioGeneral())
            if ( String.valueOf(objInv.cantidad).equals(cantidad)
                    && objInv.producto.equals(producto))
                return false;
            else
                ObjLocal.AgregarInventario(cantidad, producto);
        return true;
    }
     public static Boolean ExistenciaLocal (ArrayList<Local> ArrayFarmacias, String codigo){
        boolean flag = false;
        for (Local objLocal : ArrayFarmacias){
            if (objLocal.getCodigo().equals(codigo))
                flag = true;
        }
        return flag;
    }
}
