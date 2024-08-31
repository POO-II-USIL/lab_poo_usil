package com.usil.hampcode.usil_pre_caso_2;

import lombok.Data;

@Data
public class Trabajador {
    private String nombre;
    private String apellido;
    private String cargo;
    private float sueldoBruto;
    private float sueldoNeto;
    
    public Trabajador(String nombre, String apellido, String cargo, float sueldoBruto){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.sueldoBruto = sueldoBruto;
        this.sueldoNeto = sueldoBruto - (sueldoBruto*0.11f);
    }
}
