package com.usil.hampcode.controller;

import com.usil.hampcode.model.Libro;
import com.usil.hampcode.persistence.LibroRepository;
import java.io.IOException;
import java.util.List;

public class LibroController {
     // Método para guardar un libro
    public void guardarLibro(Libro libro) throws IOException {
        LibroRepository.guardarLibro(libro);  // Guardar el libro en el archivo
    }

    // Método para cargar todos los libros
    public List<Libro> listarLibros() throws IOException {
        return LibroRepository.cargarLibros();  // Cargar los libros desde el archivo
    }
    
     // Método para buscar libros por ISBN
    public List<Libro> buscarLibroPorIsbn(String isbn) throws IOException {
        return LibroRepository.buscarPorIsbn(isbn);  // Buscar libros por ISBN
    }

    // Método para buscar libros por Título
    public List<Libro> buscarLibroPorTitulo(String titulo) throws IOException {
        return LibroRepository.buscarPorTitulo(titulo);  // Buscar libros por Título
    }

    // Método para buscar libros por Autor
    public List<Libro> buscarLibroPorAutor(String autorNombre) throws IOException {
        return LibroRepository.buscarLibroPorAutor(autorNombre);  // Buscar libros por Autor
    }
}
