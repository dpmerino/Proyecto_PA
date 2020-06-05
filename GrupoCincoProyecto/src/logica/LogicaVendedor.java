/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import clases.Vendedor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 */
public class LogicaVendedor {
    
    static String fichero = "archivos/vendedores.dat";
    
    public static void EscribirVendedorDAT (ArrayList ArrayVendedores) throws IOException{
        archivos.ArchivoGeneral.EscribirDAT(ArrayVendedores, fichero);
    }
    
    public static void LeerVendedoresDAT (ArrayList ArrayVendedores) throws IOException, FileNotFoundException, ClassNotFoundException{
        archivos.ArchivoGeneral.LeerDAT(ArrayVendedores, fichero);
    }
    
    public Boolean ValidarVendedor (ArrayList<Vendedor> ArrayVendedores, String cedula, String clave){
        for (Vendedor objVen : ArrayVendedores){
            if(objVen.getCedula().equals(cedula) && objVen.clave.equals(clave))
                return true;
        }
        return false;
    }
}
