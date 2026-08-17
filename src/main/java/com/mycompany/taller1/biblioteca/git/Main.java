/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taller1.biblioteca.git;

import com.mycompany.taller1.biblioteca.Book;
import com.mycompany.taller1.biblioteca.Client;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jxsxs
 */
public class Main {
    
    static ArrayList<Client> client = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();

    
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
          int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Selecciona una opcion: ");
            switch (opcion) {
                case 1 -> crearCliente();
                case 2 -> listarClientes();
                case 3 -> buscarCliente();
                case 4 -> actualizarCliente();
                case 5 -> eliminarCliente();
                case 6 -> crearLibro();



                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }
    
    private static void mostrarMenu() {
        System.out.println("\n===== SISTEMA DE BIBLIOTECA MUNICIPAL DE VALLEDUPAR =====");
        System.out.println("--- Clientes ---");
        System.out.println("1. Crear cliente");
        System.out.println("2. Listar clientes");
        System.out.println("3. Buscar cliente por id");
        System.out.println("4. Actualizar cliente");
        System.out.println("5. Eliminar cliente");
        System.out.println("--- Libros ---");
        System.out.println("6. Crear libro");
    }
    
    // ===================== CCRUD DE CLIENTE =====================
    
     private static void crearCliente() {
        System.out.println("\n-- Crear cliente --");
        String id = leerTexto("Id: ");
        String nombre = leerTexto("Nombre: ");
        String telefono = leerTexto("Telefono: ");
        String email = leerTexto("Email: ");
        client.add(new Client(id, nombre, telefono, email));
        System.out.println("Cliente creado correctamente.");
    }
     
     private static void listarClientes() {
        System.out.println("\n-- Listado de clientes --");
        if (client.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        for (Client c : client) {
            System.out.println(c);
        }
    }
     
     private static Client buscarClientePorId(String id) {
        for (Client c : client) {
            if (c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }
     
     private static void buscarCliente() {
        System.out.println("\n-- Buscar cliente --");
        String id = leerTexto("Id del cliente: ");
        Client c = buscarClientePorId(id);
        System.out.println(c != null ? c : "Cliente no encontrado.");
    }
     
     private static void actualizarCliente() {
        System.out.println("\n-- Actualizar cliente --");
        String id = leerTexto("Id del cliente a actualizar: ");
        Client c = buscarClientePorId(id);
        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        c.setNombre(leerTexto("Nuevo nombre: "));
        c.setTelefono(leerTexto("Nuevo telefono: "));
        c.setEmail(leerTexto("Nuevo email: "));
        System.out.println("Cliente actualizado.");
    }
     
     private static void eliminarCliente() {
        System.out.println("\n-- Eliminar cliente --");
        String id = leerTexto("Id del cliente a eliminar: ");
        Client c = buscarClientePorId(id);
        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        client.remove(c);
        System.out.println("Cliente eliminado.");
    }
     
     // ===================== CRUD DE LIBROS(BOOOKS) =====================
 
    private static void crearLibro() {
        System.out.println("\n-- Crear libro --");
        String codigo = leerTexto("Codigo: ");
        String titulo = leerTexto("Titulo: ");
        int anio = leerEntero("Anio de publicacion: ");
        String autor = leerTexto("Autor: ");
        books.add(new Book(codigo, titulo, anio, autor));
        System.out.println("Libro creado correctamente.");
    }
     
         // ===================== UTILIDADES DE ENTRADA =====================

      private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }
 
    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.println("Por favor ingresa un numero valido.");
            System.out.print(mensaje);
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }
    
}
