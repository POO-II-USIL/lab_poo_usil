package com.usil.hampcode.usil_pre_caso_2;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Planilla {

    private List<Trabajador> trabajadores;
    
    public Planilla(){
        trabajadores = new ArrayList<>();
    }
    
    public void agregarTrabajador(Trabajador trabajador){
        trabajadores.add(trabajador);
    }
    
    public void generarReportePlanilla(){
        int cantidadTrabajadores = trabajadores.size();
        float totalSueldoNeto = 0.0f;
        float totalImpuestos = 0.0f;
        float sueldoNetoPromedio = 0.0f;
        
        for (Trabajador trabajador : trabajadores) {
            totalSueldoNeto += trabajador.getSueldoNeto();
            totalImpuestos += trabajador.getSueldoBruto()*0.11f;
        }
        
        if(cantidadTrabajadores>0){
         sueldoNetoPromedio = totalSueldoNeto/cantidadTrabajadores;   
        }        
        
        System.out.println("Reporte de Planilla");
        System.out.println("======================");
        System.out.println("Cantidad de trabajadores en planilla:"+cantidadTrabajadores);
        System.out.println("Monto total a pagar:"+totalSueldoNeto);
        System.out.println("Impuestos a pagar:"+totalImpuestos);
        System.out.println("Sueldo neto promedio:"+sueldoNetoPromedio);        
    }
    
}
