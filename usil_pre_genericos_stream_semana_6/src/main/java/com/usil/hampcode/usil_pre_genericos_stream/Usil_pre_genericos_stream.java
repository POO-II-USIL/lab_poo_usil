package com.usil.hampcode.usil_pre_genericos_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Usil_pre_genericos_stream {

    public static void main(String[] args) {
        //Lista de productos => Representar mi fuentes de datos (DATASOURCE)
        //List<E> Significa que E es un tipo de dato GENERIO por lo tanto la lista (list) puede almacenar cualquier tipo de OBJETO
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200),
                new Product("Smartphone", "Electronics", 800),
                new Product("Tablet", "Electronics", 600),
                new Product("Keyboard", "Accessories", 100),
                new Product("Monitor", "Accessories", 300),
                new Product("USB Cable", "Accessories", 20)
        );
        
        //API Stream ==> Flujo de datos ==> API se utiliza para poder realizar operaciones en una COLECCIÓN de OBJETOS
        //Operaciones: filter, map, flatmap, grouping, tolist
        //Para poder utilizar API Stream
        //Requisitos
        // Paso 1: Dispongas de una fuente de datos ==> Arreglo, Colección de OBJETOS, API Externas, Base de Datos
        // Paso 2: Realices la conversión de la fuentes a datos a un FLUJO DE DATOS (Stream)
        // Paso 3: Concatenar las operaciones que sean necesaria o que permitan llegar al resultado DESEADO/SOLICITADO
        
        //Caracteristica
        //Las operaciones de API STREAM no modifican contenido de las COLECCIONES por ese motivo se indican que estas operaciones
        //SON INMUTABLES 
        
        //SE APROVECHA cuando tienes que REALIZAR EL PROCESAMIENTO DE GRANDES CONTENIDOS QUE SE OBTIENES DE UNA FUENTE DATOS
        
        //TODO: Obtener solo los nombre de los productos List<Product> (input) ===== map ==> List<String> (output) 
        List<String> productNames = products.stream()
                .map(Product::getName)
                .toList();
        
        System.out.println("Nombres de productos"+productNames);
        
        //TODO: Usar reduce para calcular el costo total de todos los productos
        double totalCost = products.stream() //List<Product>
                 .map(Product::getPrice) //List<Double>
                 .reduce(0.0, Double::sum);
        System.out.println("Costo total de los productos:"+totalCost);
        
        //TODO: Agrupar productos por categoria
        //Output
        // Category - Products                           Map<K,V> K: Indice/Key V: Value ==> Map<String, List<Product>>
        // ======================
        // Electronics - Laptop, Tablet,Smartphone 
          
        Map<String, List<Product>> productsByCategory = products.stream().collect(Collectors.groupingBy(Product::getCategory));        
        System.out.println("Productos agrupados por categoria:"+ productsByCategory);
        
        
        //Forma imperativa ==> Utilizando estructura repetitivas        
        Map<String, List<Product>> productsByCategory1 = new HashMap<>();
        
        for (Product product : products) {
            
            String category = product.getCategory();
            
            if(!productsByCategory1.containsKey(category)){
                productsByCategory1.put(category, new ArrayList<>());
            }
            
            productsByCategory1.get(category).add(product);                        
        }        
        System.out.println("Productos agrupados por categoria:"+ productsByCategory1);
        
        
        //Clases Genericos
        //Por ejemplo: 
        //JAVA!
        // tipo de dato primitivo : int, double, long, boolean, String
        // tipos de datos OBJETO Clases Wrapper: Integer, Double, Long, Boolean, String
        // List<Integer> numbers;
        // List<String> letters;
        
        //Agregar numeros a la lista: numbers.add(number) 
        //Agregar letras a la lista:  letters.add(letter) 
        
        
        // T: Es un tipo de dato GENERICO que representa cualquiero tipo de dato ESPECIFICO. OJO este tipo de dato debe ser UN OBJETO
        // void add(T t){
        
        //} 
        
        
        //Crear una lista de pares para representar una MAPA
        //E ==> Par<String, Integer>
        List<Pair<String, Integer>> listPares = new ArrayList<>();
        listPares.add(new Pair<>("Manzanas", 5));
        listPares.add(new Pair<>("Naranjas", 3));
        listPares.add(new Pair<>("Platanos", 7));
        
        for (Pair<String, Integer> par : listPares) {
            System.out.println(par.getClave() +":"+par.getValor());
        }
        
        
        List<Pair<Integer, String>> listParesDos = new ArrayList<>();
        listPares.add(new Pair<>("Manzanas", 5));
        listPares.add(new Pair<>("Naranjas", 3));
        listPares.add(new Pair<>("Platanos", 7));
        
        //Aplicación X (Movil, Consola, Web, Desktop) == Operaciones Transaccionales ==> Base Datos ==> Tabla 
        //Operaciones que repiten
        // CRUD: C(Create) R(Read) U(Update) D(Delete) ==> Operaciones GENERICAS
        
                 
        
    }
}

