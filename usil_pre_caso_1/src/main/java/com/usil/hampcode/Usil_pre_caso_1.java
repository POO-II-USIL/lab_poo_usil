package com.usil.hampcode;

import java.util.Random;
import java.util.Scanner;

public class Usil_pre_caso_1 {
    
    public static void main(String[] args) {
        Caseta caseta = new Caseta();
        Random random = new Random(); 
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        
        while(!salir){
            System.out.println("Menu Caseta de Peaje");
            System.out.println("=====================");
            System.out.println("1. Simular entrada de vehiculo");
            System.out.println("2. Generar reporte");
            System.out.println("3. Salir");
            System.out.println("Selecciona una opción");
            int opcion = scanner.nextInt();
            
            switch(opcion){
                case 1 -> {
                    int tipoIndex = random.nextInt(TipoVehiculo.values().length);
                    TipoVehiculo tipoVehAleatorio = TipoVehiculo.values()[tipoIndex];
                    /*Vehiculo vehiculo = new Vehiculo(tipoVehAleatorio);
                    System.out.println("tipoIndex:"+tipoIndex);
                    System.out.println("tipoVehAleatorio:"+tipoVehAleatorio);
                    System.out.println("vehiculo:"+vehiculo.toString());*/
                    
                    Vehiculo vehiculo = new Vehiculo(tipoVehAleatorio);
                    caseta.agregarVehiculo(vehiculo);
                    System.out.println("Vehiculo de tipo: "+tipoVehAleatorio +" ingresado. Tarifa S/."+ vehiculo.getTarifa());
                }
                
                case 2 -> caseta.generarReporte();
                case 3 -> salir = true;
                default -> System.out.println("Por favor, debes ingresar un número de opción correcto");
            }                       
        }
        
        System.out.println("Saliendo del programa.....!Nos vemos");
        scanner.close();
    }
}

