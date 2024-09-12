package com.usil.hampcode.controller;

import com.usil.hampcode.model.Autor;
import com.usil.hampcode.persistence.AutorRepository;
import java.io.IOException;
import java.util.List;


public class AutorController {
    // Método para guardar un autor
    public void guardarAutor(Autor autor) throws IOException {
        AutorRepository.guardarAutor(autor);  // Guardar el autor en el archivo
    }

    // Método para cargar todos los autores
    public List<Autor> listarAutores() throws IOException {
        return AutorRepository.cargarAutores();  // Cargar los autores desde el archivo
    }
}
