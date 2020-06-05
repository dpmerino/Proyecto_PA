/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import clases.Local;
import java.util.ArrayList;

/**
 *
 * @author diegomerino
 */
public class ValorCombo {
    
    public ArrayList CargarFarmacias(ArrayList<Local> ArrayFarmacias){
        ArrayList<String> listaFarmacias = new ArrayList<>();
        for (Local objLoc : ArrayFarmacias){
            listaFarmacias.add(objLoc.getNombre());
        }
        return listaFarmacias;
    }
}
