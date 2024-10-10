package com.usil.hampcode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    private int id;
    private String nombre;
    private int edad;
    private String departamento;
}
