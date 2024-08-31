
package com.usil.hampcode.usil_pre_caso_2;

import java.util.Scanner;

public class Usil_pre_caso_2 {

    public static void main(String[] args) {
        Planilla planilla = new Planilla();        
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        
        while(!salir){
            System.out.println("Menu Caseta de Peaje");
            System.out.println("=====================");
            System.out.println("1. Agregar trabajador");
            System.out.println("2. Generar reporte");
            System.out.println("3. Salir");
            System.out.println("Selecciona una opción");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion){
                case 1 -> {
                    System.out.println("Ingrese el nombre del trabajador");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el apellido del trabajador");
                    String apellido = scanner.nextLine();
                    System.out.println("Ingrese el cargo del trabajador");
                    String cargo = scanner.nextLine();
                    System.out.println("Ingrese el sueldo bruto del trabajador");
                    float sueldoBruto = scanner.nextFloat();
                    
                    Trabajador trabajador = new Trabajador(nombre, apellido, cargo, sueldoBruto);
                    planilla.agregarTrabajador(trabajador);
                    System.out.println("Trabajador registrado");
                }
                
                case 2 -> planilla.generarReportePlanilla();
                case 3 -> salir = true;
                default -> System.out.println("Por favor, debes ingresar un número de opción correcto");
            }                       
        }
        
        System.out.println("Saliendo del programa.....!Nos vemos");
        scanner.close();
    }
}
