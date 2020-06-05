/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author diegomerino
 */
public class ArchivoGeneral {

    public static void EscribirDAT(ArrayList ArrayObjetos, String fichero) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero, false));
        for (Object objAux : ArrayObjetos) {
            oos.writeObject(objAux);
        }
        oos.close();
    }

    public static void LeerDAT(ArrayList ArrayObjetos, String fichero) throws FileNotFoundException, IOException, ClassNotFoundException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            Object aux = ois.readObject();
            while (aux != null) {
                if (aux instanceof Object) {
                    ArrayObjetos.add(aux);
                }
                aux = ois.readObject();
            }
            ois.close();
        } catch (EOFException e1) {
        } catch (IOException | ClassNotFoundException e2) {
        }
    }
     public static void anhadeFichero (ArrayList ArrayObjetos,String fichero)
    {
        try
        {
            // Se usa un ObjectOutputStream que no escriba una cabecera en
            // el stream.
            MiObjectOutputStream oos = new MiObjectOutputStream(
                    new FileOutputStream(fichero,true));
            // Se hace el new fuera del bucle, s�lo hay una instancia de persona.
            // Se debe usar entonces writeUnshared().
            for (Object ObjAux:  ArrayObjetos){
             //ObjCliente =  (Cliente) ArrayClientes.get(i);
                oos.writeUnshared(ObjAux);
                //System.out.println("añadir");
        }
        oos.close();  // Se cierra al terminar.
            oos.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
