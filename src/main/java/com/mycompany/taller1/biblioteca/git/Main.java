/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taller1.biblioteca.git;

import com.mycompany.taller1.biblioteca.Book;
import com.mycompany.taller1.biblioteca.Client;
import com.mycompany.taller1.biblioteca.Loan;
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
    static ArrayList<Loan> loan = new ArrayList<>();


    
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
                case 7 -> listarLibros();
                case 8 -> buscarLibro();
                case 9 -> actualizarLibro();
                case 10 -> eliminarLibro();
                case 11 -> crearPrestamo();
                case 12 -> registrarDevolucion();


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
        System.out.println("7. Listar libros");
        System.out.println("8. Buscar libro por codigo");
        System.out.println("9. Actualizar libro");
        System.out.println("10. Eliminar libro");
        System.out.println("--- Prestamos ---");
        System.out.println("11. Registrar prestamo");
        System.out.println("12. Registrar devolucion");


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
    
    private static void listarLibros() {
        System.out.println("\n-- Listado de libros --");
        if (books.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        for (Book l : books) {
            System.out.println(l);
        }
    }
    
    private static Book buscarLibroPorCodigo(String codigo) {
        for (Book l : books) {
            if (l.getCodigo().equalsIgnoreCase(codigo)) {
                return l;
            }
        }
        return null;
    }
 
    private static void buscarLibro() {
        System.out.println("\n-- Buscar libro --");
        String codigo = leerTexto("Codigo del libro: ");
        Book l = buscarLibroPorCodigo(codigo);
        System.out.println(l != null ? l : "Libro no encontrado.");
    }
    
    private static void actualizarLibro() {
        System.out.println("\n-- Actualizar libro --");
        String codigo = leerTexto("Codigo del libro a actualizar: ");
        Book l = buscarLibroPorCodigo(codigo);
        if (l == null) {
            System.out.println("Libro no encontrado.");
            return;
        }
        l.setTitulo(leerTexto("Nuevo titulo: "));
        l.setAnioPublicacion(leerEntero("Nuevo anio de publicacion: "));
        l.setAutor(leerTexto("Nuevo autor: "));
        System.out.println("Libro actualizado.");
    }
    
    private static void eliminarLibro() {
        System.out.println("\n-- Eliminar libro --");
        String codigo = leerTexto("Codigo del libro a eliminar: ");
        Book l = buscarLibroPorCodigo(codigo);
        if (l == null) {
            System.out.println("Libro no encontrado.");
            return;
        }
        books.remove(l);
        System.out.println("Libro eliminado.");
    }
    
    
        // ===================== CRUD DE PRESTAMO =====================
    
    private static void crearPrestamo() {
        System.out.println("\n-- Registrar prestamo --");
        String idPrestamo = leerTexto("Id del prestamo: ");
        String idCliente = leerTexto("Id del cliente: ");
        Client c = buscarClientePorId(idCliente);
        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        String codigoLibro = leerTexto("Codigo del libro: ");
        Book l = buscarLibroPorCodigo(codigoLibro);
        if (l == null) {
            System.out.println("Libro no encontrado.");
            return;
        }
        if (!l.isDisponible()) {
            System.out.println("El libro no esta disponible.");
            return;
        }
        Loan p = new Loan(idPrestamo, c, l, LocalDate.now());
        loan.add(p);
        l.setDisponible(false);
        System.out.println("Prestamo registrado correctamente.");
    }
    
    private static void registrarDevolucion() {
        System.out.println("\n-- Registrar devolucion --");
        String idPrestamo = leerTexto("Id del prestamo: ");
        for (Loan p : loan) {
            if (p.getIdPrestamo().equalsIgnoreCase(idPrestamo) && p.getEstado().equals("ACTIVO")) {
                p.setEstado("DEVUELTO");
                p.getLibro().setDisponible(true);
                System.out.println("Devolucion registrada correctamente.");
                return;
            }
        }
        System.out.println("Prestamo activo no encontrado.");
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
