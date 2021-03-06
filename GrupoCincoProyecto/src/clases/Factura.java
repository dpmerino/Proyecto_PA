package clases;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Factura.java
//  @ Date : 6/4/2020
//  @ Author : Jean Chuquimarca - Diego Merino - Raul Condolo
//
//




public class Factura {
	public String leyenda;
	public int formaDePago;
	public double descuento;
	public double valorTotal;
	public Pedido pedido;

    public Factura(String leyenda, int formaDePago, double descuento, double valorTotal, Pedido pedido) {
        this.leyenda = leyenda;
        this.formaDePago = formaDePago;
        this.descuento = descuento;
        this.valorTotal = valorTotal;
        this.pedido = pedido;
    }

    public Factura() {
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }

    public int getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(int formaDePago) {
        this.formaDePago = formaDePago;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Factura{" + "leyenda=" + leyenda + ", formaDePago=" + formaDePago + ", descuento=" + descuento + ", valorTotal=" + valorTotal + ", pedido=" + pedido + '}';
    }
        

}
