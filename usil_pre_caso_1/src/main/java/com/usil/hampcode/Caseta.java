package com.usil.hampcode;

import static com.usil.hampcode.TipoVehiculo.LIVIANO;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Caseta {    
    private List<Vehiculo> vehiculos;
    
    public Caseta(){
        //TODO: La asociación que existe entre Case y Vehiculo es una
        //composicion
        vehiculos = new ArrayList<>();
    }
    
    public void agregarVehiculo(Vehiculo vehiculo){
        //TODO: agregar un objeto vehiculo a la colección de vehiculos
        this.vehiculos.add(vehiculo);
    }
    
    public void generarReporte(){
     int livianoCount = 0;   
     int medianoCount = 0;
     int pesadoCount = 0;
     int motoCount = 0;
     double totalRecaudado = 0.0;
     
     for (Vehiculo vehiculo : vehiculos) {
         totalRecaudado+= vehiculo.getTarifa();         
         
         switch(vehiculo.getTipo()){
             case LIVIANO -> livianoCount++;
             case MEDIANO -> medianoCount++;
             case PESADO -> pesadoCount++;
             case MOTO -> motoCount++;             
         }
     }
     
     System.out.println("Reporte de Vehiculos");
     System.out.println("Livianos:"+ livianoCount);
     System.out.println("Medianos:"+ medianoCount);
     System.out.println("Pesados:"+ pesadoCount);
     System.out.println("Motos:"+ motoCount);
     System.out.println("Monto total recaudado S/."+ totalRecaudado);
    }
}
