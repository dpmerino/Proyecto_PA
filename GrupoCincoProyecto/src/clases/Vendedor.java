package clases;
//
//

import java.io.Serializable;

//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Vendedor.java
//  @ Date : 6/4/2020
//  @ Author : Jean Chuquimarca - Diego Merino - Raul Condolo
//
//




public class Vendedor extends Empleado implements Serializable{
	public Local local;

    public Vendedor(Local local, int turno, double sueldo, String cedula, String nombre, String apellido, String mail, String clave) {
        super(turno, sueldo, cedula, nombre, apellido, mail, clave);
        this.local = local;
    }

    public Vendedor(Local local) {
        this.local = local;
    }

    public Vendedor() {
    }


    public Local getPedidoRealizados() {
        return local;
    }

    public void setPedidoRealizado(Local local) {
        this.local = local;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "local=" + local + '}';
    }
        
        
}
