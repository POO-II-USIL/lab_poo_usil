package com.usil.hampcode;

public enum TipoVehiculo {
    LIVIANO(6.50),//tipoIndex 0
    MEDIANO(7.20),//tipoIndex 1
    PESADO(11.40),//tipoIndex 2
    MOTO(0.00);//tipoIndex 3
    
    private final double tarifa;
    
    TipoVehiculo(double tarifa){
        this.tarifa = tarifa;
    }
            
    public double getTarifa(){
        return tarifa;
    }
    
}
