/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import clases.Administrador;
import clases.Local;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 */
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
}
