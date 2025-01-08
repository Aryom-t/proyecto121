package com.mycompany.empresa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Empresa empresa = new Empresa();

        empresa.mostrar();

        System.out.println("\nIngrese los datos del nuevo empleado:");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        // Verificar si el empleado ya existe
        if (empresa.existeEmpleado(nombre)) {
            System.out.println("El empleado ya existe en la empresa. No se puede registrar.");
        } else {
            // Solicitar los demás datos solo si el empleado no existe
            System.out.print("Cargo: ");
            String cargo = sc.nextLine();

            System.out.print("Sueldo: ");
            String sueldo = sc.nextLine();

            Empleado nuevoEmpleado = new Empleado(nombre, cargo, sueldo);

            boolean agregado = empresa.adicionarEmpleado(nuevoEmpleado);

            if (agregado) {
                System.out.println("Empleado agregado exitosamente.");
            } else {
                System.out.println("Ocurrió un error al agregar al empleado.");
            }
        }

        System.out.println("\nInformación actualizada de la empresa:");
        empresa.mostrar();
    }
}