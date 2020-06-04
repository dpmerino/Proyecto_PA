package clases;
//
//

import java.io.Serializable;

//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Local.java
//  @ Date : 6/4/2020
//  @ Author : Jean Chuquimarca - Diego Merino - Raul Condolo
//
//




public class Local implements Serializable{
	public String direccion;
	public boolean estaDeTurno;
	public Pedido pedido;
	public Vendedor vendedor;
	public Bodeguero bodeguero;
	public Gerente gerente;
	public Inventario inventario;

    public Local(String direccion, boolean estaDeTurno, Pedido pedido, Vendedor vendedor, Bodeguero bodeguero, Gerente gerente, Inventario inventario) {
        this.direccion = direccion;
        this.estaDeTurno = estaDeTurno;
        this.pedido = pedido;
        this.vendedor = vendedor;
        this.bodeguero = bodeguero;
        this.gerente = gerente;
        this.inventario = inventario;
    }

    public Local() {
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEstaDeTurno() {
        return estaDeTurno;
    }

    public void setEstaDeTurno(boolean estaDeTurno) {
        this.estaDeTurno = estaDeTurno;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Bodeguero getBodeguero() {
        return bodeguero;
    }

    public void setBodeguero(Bodeguero bodeguero) {
        this.bodeguero = bodeguero;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    @Override
    public String toString() {
        return "Local{" + "direccion=" + direccion + ", estaDeTurno=" + estaDeTurno + ", pedido=" + pedido + ", vendedor=" + vendedor + ", bodeguero=" + bodeguero + ", gerente=" + gerente + ", inventario=" + inventario + '}';
    }
        
        
}
