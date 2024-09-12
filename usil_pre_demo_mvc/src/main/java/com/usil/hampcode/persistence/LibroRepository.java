package com.usil.hampcode.persistence;

import com.usil.hampcode.model.Autor;
import com.usil.hampcode.model.Libro;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibroRepository {
    private static final String FILE_PATH = "libros.txt";

    // Método para guardar un solo libro
    public static void guardarLibro(Libro libro) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {  // 'true' para agregar al archivo
            writer.write(libro.getIsbn() + ";" +
                    libro.getTitulo() + ";" +                    
                    libro.getGenero() + ";" +
                    libro.getSinopsis()+ ";" +
                    libro.isLeido() + ";" +
                    libro.isLoTengo() + ";" +
                    libro.getAutor().getNombre());
            writer.newLine();
        }
    }

    // Método para cargar todos los libros desde el archivo
    public static List<Libro> cargarLibros() throws IOException {
        List<Libro> libros = new ArrayList<>();
        File file = new File(FILE_PATH);
        
        if (!file.exists()) {
            return libros;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 7) {
                    String isbn = parts[0];
                    String titulo = parts[1];                    
                    String genero = parts[2];
                    String sinopsis = parts[3];
                    boolean leido = Boolean.parseBoolean(parts[4]);
                    boolean loTengo = Boolean.parseBoolean(parts[5]);
                    Autor autor = new Autor(parts[6]);

                    libros.add(new Libro(isbn, titulo, genero, sinopsis,leido, loTengo,autor));
                }
            }
        }
        
        return libros;
    }
    
    // Método para buscar libros por ISBN
    public static List<Libro> buscarPorIsbn(String isbn) throws IOException {
        List<Libro> libros = cargarLibros();  
        List<Libro> resultado = new ArrayList<>();

        for (Libro libro : libros) {
            if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                resultado.add(libro);
            }
        }

        return resultado;
    }

    // Método para buscar libros por Título
    public static List<Libro> buscarPorTitulo(String titulo) throws IOException {
        List<Libro> libros = cargarLibros();  
        List<Libro> resultado = new ArrayList<>();

        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                resultado.add(libro);
            }
        }

        return resultado;
    }

    // Método para buscar libros por Autor
   public static List<Libro> buscarLibroPorAutor(String autorNombre) throws IOException {
        List<Libro> libros = LibroRepository.cargarLibros(); 
        List<Libro> librosFiltrados = new ArrayList<>();

        for (Libro libro : libros) {
            // Verificar si el nombre del autor coincide, ignorando mayúsculas y espacios en blanco
            if (libro.getAutor().getNombre().trim().equalsIgnoreCase(autorNombre.trim())) {
                librosFiltrados.add(libro); 
            }
        }

        return librosFiltrados;  
    }

}

