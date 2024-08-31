package com.usil.hampcode;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Vehiculo {
    private TipoVehiculo tipo;
    private double tarifa;
    
    public Vehiculo(TipoVehiculo tipo){
        this.tipo =tipo;
        this.tarifa = tipo.getTarifa();
    }
}
