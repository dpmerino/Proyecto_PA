/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import archivos.DATCLiente;
import clases.Cliente;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 */
public class LogicaCliente {
    
    static String fichero = "archivos/clientes.dat";
    DATCLiente objDATCliente= new DATCLiente();
    
    public static void EscribirClientesDAT(ArrayList ArrayObjetos) throws IOException{
        archivos.ArchivoGeneral.EscribirDAT(ArrayObjetos, fichero);
    }
    
    public static void LeerClientesDAT(ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException{
        archivos.ArchivoGeneral.LeerDAT(ArrayObjetos, fichero);
    }
   
    public Boolean validarCliente (ArrayList<Cliente> ArrayClientes, String cedula, String clave){
        for (Cliente objCli : ArrayClientes){
            if(objCli.getCedula().equals(cedula) && objCli.getClave().equals(clave))
                return true;
        }
        return false;
    }
    
    public static Cliente cargarCliente (ArrayList<Cliente> ArrayClientes, String cedula){
        Cliente objCliente = new Cliente();
        for (Cliente objAux : ArrayClientes){
            if (objAux.getCedula().equals(cedula))
                objCliente = objAux;
        }
        return objCliente;
    }
    public static Boolean ExistenciaCliente (ArrayList<Cliente> ArrayCliente, String cedula){
        boolean flag = false;
        for (Cliente objCliente : ArrayCliente){
            if (objCliente.getCedula().equals(cedula))
                flag = true;
        }
        return flag;
    }
    public void InsertarCliente(Cliente objeto) throws SQLException, ClassNotFoundException{
        objDATCliente.InsertarExterno(objeto);
    }
}
