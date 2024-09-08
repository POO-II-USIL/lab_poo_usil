package com.usil.hampcode.usil_pre_ejercicio_2_semana_3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private String nombreProducto;
    private int cantidad;    
    
    @Override
    public String toString(){
        return nombreProducto+","+cantidad;
    }
}
