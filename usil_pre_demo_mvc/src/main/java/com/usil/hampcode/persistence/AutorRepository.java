package com.usil.hampcode.persistence;

import com.usil.hampcode.model.Autor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AutorRepository {
    private static final String FILE_PATH = "autores.txt";

    
    public static void guardarAutor(Autor autor) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {  // 'true' para agregar al archivo
            writer.write(autor.getNombre());  
            writer.newLine();
        }
    }

    
    public static List<Autor> cargarAutores() throws IOException {
        List<Autor> autores = new ArrayList<>();
        File file = new File(FILE_PATH);
        
        if (!file.exists()) {
            return autores;  
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                autores.add(new Autor(line));  // Creamos un autor con el nombre leído de cada línea
            }
        }
        
        return autores;
    }
}
