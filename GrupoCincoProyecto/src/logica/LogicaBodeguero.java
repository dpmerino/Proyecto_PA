/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import clases.Bodeguero;
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
    
    public Boolean validarBodeguero(ArrayList<Bodeguero> ArrayBodegueros, String cedula, String clave){
        for(Bodeguero objBod: ArrayBodegueros){
            if(objBod.getCedula().equals(cedula) && objBod.getClave().equals(clave))
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
