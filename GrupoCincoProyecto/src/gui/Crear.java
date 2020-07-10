/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import clases.Vendedor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import logica.LogicaVendedor;

/**
 *
 * @author diegomerino
 */
public class Crear {
    static LogicaVendedor objLogVen = new LogicaVendedor();
    static ArrayList<Vendedor> ArrayVendedores = new ArrayList<>();
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        CrearVendedores();
        ListarVendedores();
    }
    static void CrearVendedores() throws IOException, FileNotFoundException, ClassNotFoundException{
        //ArrayVendedores.add(new Vendedor(0,400,"1900","Eduardo","Carrion","ec@gmail.com","vvvv"));
      //  ArrayVendedores.add(new Vendedor(0,500,"1901","Andrea","Abad","aa@gmail.com","vvvv"));
        
        objLogVen.EscribirVendedorDAT(ArrayVendedores);
    }
    static void ListarVendedores() throws IOException, FileNotFoundException, ClassNotFoundException{
        ArrayVendedores.clear();
        objLogVen.LeerVendedoresDAT(ArrayVendedores);
        for(int i = 0; i < ArrayVendedores.size();i++){
            System.out.println(ArrayVendedores.get(i).getCedula()+"\n"+ArrayVendedores.get(i).getNombre());
        }
    }
}
