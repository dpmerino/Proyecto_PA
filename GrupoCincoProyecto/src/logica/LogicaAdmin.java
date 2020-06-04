/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import clases.Administrador;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author diegomerino
 */
public class LogicaAdmin {
    
    static String fichero = "archivo/admins.dat";
    
    public static void EscribirAdminDAT(ArrayList ArrayObjetos) throws IOException{
        archivos.ArchivoGeneral.EscribirDAT(ArrayObjetos, fichero);
    }
    
    public static void LeerAdminDAT (ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException{
        archivos.ArchivoGeneral.LeerDAT(ArrayObjetos, fichero);
    }
    
    public Boolean validarAdmin (ArrayList<Administrador> ArrayAdmins, String cedula, String clave){
        for (Administrador objAdm : ArrayAdmins){
            if(objAdm.getCedula().equals(cedula) && objAdm.getClave().equals(clave))
                return true;
        }
        return false;
    }
}
