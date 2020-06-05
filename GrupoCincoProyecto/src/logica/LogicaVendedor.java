/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import clases.Local;
import clases.Vendedor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    
    public Boolean ValidarVendedor (ArrayList<Local> Farmacias, String cedula, String clave){
        for (Local objVen : Farmacias){
            if(objVen.getVendedor().getCedula().equals(cedula) && objVen.getVendedor().getClave().equals(clave)) 
                return true;
        }
        return false;
    }
    public boolean mailValido(String email) {       
       Pattern pat = 
       Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
       Matcher mat = pat.matcher(email);
       if(mat.find()){
          return true;
       }else{
          return false;
     }
    }
}
