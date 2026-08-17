/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taller1.biblioteca.git;

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
    
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
          int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Selecciona una opcion: ");
            switch (opcion) {
                case 1 -> crearCliente();
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }
    
    private static void mostrarMenu() {
        System.out.println("\n===== SISTEMA DE BIBLIOTECA MUNICIPAL DE VALLEDUPAR =====");
        System.out.println("--- Clientes ---");
        System.out.println("1. Crear cliente");
    }
    
     private static void crearCliente() {
        System.out.println("\n-- Crear cliente --");
        String id = leerTexto("Id: ");
        String nombre = leerTexto("Nombre: ");
        String telefono = leerTexto("Telefono: ");
        String email = leerTexto("Email: ");
        client.add(new Client(id, nombre, telefono, email));
        System.out.println("Cliente creado correctamente.");
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
