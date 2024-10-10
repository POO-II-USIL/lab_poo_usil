package com.usil.hampcode.repository;

import com.usil.hampcode.model.Empleado;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepositoryArchivo implements EmpleadoRepository {
    private final String archivoEmpleados = "empleados.txt";

    @Override
    public void agregarEmpleado(Empleado empleado) {
        // Obtener el siguiente ID disponible
        int nuevoId = obtenerSiguienteId();

        // Asignar el nuevo ID al empleado
        empleado.setId(nuevoId);

        // Escribir el empleado en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoEmpleados, true))) {
            writer.write(empleado.getId() + "," + empleado.getNombre() + "," + empleado.getEdad() + "," + empleado.getDepartamento());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener el próximo ID disponible
    private int obtenerSiguienteId() {
        int maxId = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoEmpleados))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                int id = Integer.parseInt(datos[0]);
                if (id > maxId) {
                    maxId = id;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maxId + 1;
    }

    @Override
    public Empleado obtenerEmpleado(int id) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoEmpleados))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (Integer.parseInt(datos[0]) == id) {
                    return new Empleado(id, datos[1], Integer.parseInt(datos[2]), datos[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Empleado> obtenerTodosLosEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoEmpleados))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                empleados.add(new Empleado(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2]), datos[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    @Override
    public void actualizarEmpleado(Empleado empleado) {
        List<Empleado> empleados = obtenerTodosLosEmpleados();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoEmpleados))) {
            for (Empleado e : empleados) {
                if (e.getId() == empleado.getId()) {
                    writer.write(empleado.getId() + "," + empleado.getNombre() + "," + empleado.getEdad() + "," + empleado.getDepartamento());
                } else {
                    writer.write(e.getId() + "," + e.getNombre() + "," + e.getEdad() + "," + e.getDepartamento());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarEmpleado(int id) {
        List<Empleado> empleados = obtenerTodosLosEmpleados();
        empleados.removeIf(e -> e.getId() == id);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoEmpleados))) {
            for (Empleado e : empleados) {
                writer.write(e.getId() + "," + e.getNombre() + "," + e.getEdad() + "," + e.getDepartamento());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
