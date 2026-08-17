/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller1.biblioteca;

import java.time.LocalDate;

/**
 *
 * @author jxsxs
 */
public class Loan {
    private String idPrestamo;
    private Client cliente;
    private Book libro;
    private LocalDate fecha;
    private String estado; // "ACTIVO" o "DEVUELTO"
 
    public Loan(String idPrestamo, Client client, Book libro, LocalDate fecha) {
        this.idPrestamo = idPrestamo;
        this.cliente = cliente;
        this.libro = libro;
        this.fecha = fecha;
        this.estado = "ACTIVO";
    }
 
    public String getIdPrestamo() { return idPrestamo; }
    public void setIdPrestamo(String idPrestamo) { this.idPrestamo = idPrestamo; }
 
    public Client getCliente() { return cliente; }
    public void setCliente(Client cliente) { this.cliente = cliente; }
 
    public Book getLibro() { return libro; }
    public void setLibro(Book libro) { this.libro = libro; }
 
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
 
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
 
    @Override
    public String toString() {
        return "idPrestamo=" + idPrestamo
                + ", cliente=" + cliente.getNombre()
                + ", libro=" + libro.getTitulo()
                + ", fecha=" + fecha
                + ", estado=" + estado;
    }
}
