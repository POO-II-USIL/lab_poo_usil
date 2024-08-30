package com.usil.hampcode;

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
        vehiculos.add(vehiculo);
    }
    
    public void generarReporte(){
     int livianoCount = 0;   
     int medianoCount = 0;
     int pesadoCount = 0;
     int motoCount = 0;
     double totalRecaudado = 0.0;
     
     
    }
}
