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
}
