package clases;
//
//

import java.io.Serializable;

//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Producto.java
//  @ Date : 6/4/2020
//  @ Author : Jean Chuquimarca - Diego Merino - Raul Condolo
//
//




public class Producto implements Serializable{
	public String codigo;
	public String nombre;
	public double precio;
	public String vencimiento;

    public Producto(String codigo, String nombre, double precio, String vencimiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.vencimiento = vencimiento;
    }

   

    public Producto() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", vencimiento=" + vencimiento + '}';
    }
        
        
}
