/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import clases.Bodeguero;
import clases.Local;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *

 */
public class LogicaBodeguero {
    static String fichero = "archivos/bodegueros.dat";
    
    public static void EscribirBodeguerosDAT (ArrayList ArrayObjetos) throws IOException{
        archivos.ArchivoGeneral.EscribirDAT(ArrayObjetos, fichero);
    }
    
    public static void LeerBodegueroDAT (ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException{
        archivos.ArchivoGeneral.LeerDAT(ArrayObjetos, fichero);
    }
    
    public Boolean validarBodeguero(ArrayList<Local> Farmacias, String cedula, String clave){
        for (Local objLoc : Farmacias){
            if(objLoc.getBodeguero().getCedula().equals(cedula) && objLoc.getBodeguero().getClave().equals(clave))
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
