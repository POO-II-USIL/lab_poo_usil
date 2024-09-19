package com.hampcode.usil_pre_funcional_stream;

import java.util.ArrayList;
import java.util.List;

public class Usil_pre_funcional_stream {

    public static void main(String[] args) {
        
        List<Integer> numeros = List.of(1,2,3,4,5,6,7,8,9,10);
        
        //Programación Imperativa: Estructuras de control
        List<Integer> pares = new ArrayList<>();
        int suma =0;
        
        for (Integer numero : numeros) {
            if(numero % 2 == 0){
                pares.add(numero);
                suma += numero;
            }
        }
        
        System.out.println("Programación Imperativa");
        System.out.println("========================");
        System.out.println("Numeros pares:"+ pares);
        System.out.println("Suma de los numeros pares:"+ suma);
        System.out.println("================================================");
        
        //Programación Declarativa: Programación Funcional en JAVA ==> API STREAM
        List<Integer> paresFuncional =  numeros.stream()
                .filter(numero -> numero %2==0)
                .toList();
        
        int sumaFuncional = numeros.stream()
                .filter(numero -> numero %2==0)
                .reduce(0, Integer::sum);
        
        System.out.println("Programación Declarativa: Programación Funcional");
        System.out.println("================================================");
        System.out.println("Numeros pares:"+ paresFuncional);
        System.out.println("Suma de los numeros pares:"+ sumaFuncional);
        System.out.println("================================================");
        
        
        //stream: flujo de datos, sobre el cual concatenas operaciones intermedias
        //operaciones intermedias
        //  - filter(predicate(T))
        //  - map(function(T,R)) => transformar una variable origen a una variable destino. OJO que la variable
        //    por lo general son objetos
        
        List<Integer> numerosAlCuadrado = numeros.stream()
                .map(numero-> numero*2)
                .toList();
                //.filter(numero -> numero%2==0)
                //.reduce(0, Integer::sum);
        
        System.out.println("Lista de numeros al cuadrado:"+ numerosAlCuadrado);
        
        
        //En programación funcional. La unidad minima de representacion es una FUNCION
        //Una FUNCION en programación se le conoce como EXPRESION LAMBDA
        //   numero-> numero*2 
        
        //EXPRESION LAMBDA
        //Sintaxis:
        //    (arg1, arg2,...argn) ->  cuerpo
        
        //EN JAVA para escribir o crear una EXPRESION LAMBDA Se utiliza interfaces funcionales
        
        //Crear una expresion lambda ==> FUNCIONES ANONIMAS
        Operaciones sum = (x,y) -> x+y;
        
        Operaciones resta = (x,y)-> x-y;
        
        
        System.out.println("Suma es :"+ sum.operar(2, 3));
        System.out.println("Resta es :"+ resta.operar(2, 3));
        
        
    }
}
