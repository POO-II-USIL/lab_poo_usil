package com.usil.hampcode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
   
    private String isbn;
    private String titulo;    
    private String genero;
    private String sinopsis;
    private boolean leido;
    private boolean loTengo;
    private Autor autor;

    
}
