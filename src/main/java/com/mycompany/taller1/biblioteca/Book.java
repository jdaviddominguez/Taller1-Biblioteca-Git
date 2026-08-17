/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller1.biblioteca;

/**
 *
 * @author jxsxs
 */
public class Book extends Material {
    private String autor;
    private boolean disponible;
 
    public Book(String codigo, String titulo, int anioPublicacion, String autor) {
        super(codigo, titulo, anioPublicacion);
        this.autor = autor;
        this.disponible = true;
    }
 
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
 
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
 
    @Override
    public String toString() {
        return super.toString() + ", autor=" + autor + ", disponible=" + (disponible ? "Si" : "No");
    }
}
