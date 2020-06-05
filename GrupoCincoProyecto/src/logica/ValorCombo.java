/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import clases.Inventario;
import clases.Local;
import java.util.ArrayList;

/**
 *
 */
public class ValorCombo {
    
    public ArrayList CargarFarmacias(ArrayList<Local> ArrayFarmacias){
        ArrayList<String> listaFarmacias = new ArrayList<>();
        for (Local objLoc : ArrayFarmacias){
            listaFarmacias.add(objLoc.getNombre());
        }
        return listaFarmacias;
    }
    
    public ArrayList CargarCantidad(ArrayList<Local> ArrayFarmacias, Local farmacia){
        ArrayList<String> cantidadProductos = new ArrayList<>();
        for (Local objLoc : ArrayFarmacias){
            if (objLoc.getCodigo().equals(farmacia.getCodigo()))
                for(int i = 0; i < objLoc.inventarioGeneral.size(); i++){
                    cantidadProductos.add(String.valueOf(objLoc.inventarioGeneral.get(i).getCantidad()));
                }
        }
        return cantidadProductos;
    }
}
