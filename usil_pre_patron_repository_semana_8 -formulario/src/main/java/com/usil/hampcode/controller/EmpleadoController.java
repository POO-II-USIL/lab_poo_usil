package com.usil.hampcode.controller;

import com.usil.hampcode.model.Empleado;
import com.usil.hampcode.repository.EmpleadoRepository;
import com.usil.hampcode.repository.EmpleadoRepositoryArchivo;
import com.usil.hampcode.repository.EmpleadoRepositoryMySQL;
import java.sql.SQLException;
import java.util.List;

public class EmpleadoController {
     private EmpleadoRepository repo;
     
     public EmpleadoController(String fuenteDatos) {
        // Seleccionar el repositorio basado en la fuente de datos
        try {
            switch (fuenteDatos.toLowerCase()) {
                case "mysql":
                    this.repo = new EmpleadoRepositoryMySQL();
                    break;
                case "archivo":
                    this.repo = new EmpleadoRepositoryArchivo();
                    break;
                default:
                    throw new IllegalArgumentException("Fuente de datos no válida: " + fuenteDatos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al conectar a la base de datos.");
        }
    }
     
     // Método para agregar un empleado
    public String agregarEmpleado(Empleado empleado) {
        repo.agregarEmpleado(empleado);
        return "Empleado agregado correctamente.";
    }

    // Método para obtener un empleado por ID
    public Empleado obtenerEmpleado(int id) {
        return repo.obtenerEmpleado(id);
    }

    // Método para obtener todos los empleados
    public List<Empleado> obtenerTodosLosEmpleados() {
        return repo.obtenerTodosLosEmpleados();
    }

    // Método para actualizar un empleado
    public String actualizarEmpleado(Empleado empleado) {
        repo.actualizarEmpleado(empleado);
        return "Empleado actualizado correctamente.";
    }

    // Método para eliminar un empleado
    public String eliminarEmpleado(int id) {
        repo.eliminarEmpleado(id);
        return "Empleado eliminado si existía.";
    }
}
