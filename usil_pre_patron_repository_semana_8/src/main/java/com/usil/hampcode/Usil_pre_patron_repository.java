package com.usil.hampcode;

import com.usil.hampcode.model.Empleado;
import com.usil.hampcode.repository.EmpleadoRepository;
import com.usil.hampcode.repository.EmpleadoRepositoryArchivo;
import com.usil.hampcode.repository.EmpleadoRepositoryMySQL;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Usil_pre_patron_repository {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { 
            EmpleadoRepository repo = null;

            System.out.println("Seleccione la fuente de datos: ");
            System.out.println("1. MySQL");
            System.out.println("2. Archivo de Texto");
            System.out.println("3. Salir del Programa");
            int opcion = scanner.nextInt();

            if (opcion == 3) {
                System.out.println("Saliendo del programa.");
                break; 
            }

            try {
                switch (opcion) {
                    case 1:
                        // Inicializar el repositorio para MySQL
                        repo = new EmpleadoRepositoryMySQL();
                        break;
                    case 2:
                        // Inicializar el repositorio para Archivo de Texto
                        repo = new EmpleadoRepositoryArchivo();
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                        continue; // Volver a la elección de la fuente de datos
                }
            } catch (SQLException e) {
                System.err.println("Error al conectar a la base de datos.");
                e.printStackTrace();
                continue; // Volver a la elección de la fuente de datos
            }

            // Menú de opciones CRUD
            int seleccion;
            do {
                System.out.println("\n--- Menu de Gestión de Empleados ---");
                System.out.println("1. Agregar Empleado");
                System.out.println("2. Obtener Empleado");
                System.out.println("3. Listar Todos los Empleados");
                System.out.println("4. Actualizar Empleado");
                System.out.println("5. Eliminar Empleado");
                System.out.println("6. Volver al Menú Principal");
                System.out.print("Seleccione una opción: ");
                seleccion = scanner.nextInt();
                scanner.nextLine();  

                switch (seleccion) {
                    case 1 -> {
                        System.out.print("Ingrese el nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese la edad: ");
                        int edad = scanner.nextInt();
                        scanner.nextLine(); // Consumir nueva línea
                        System.out.print("Ingrese el departamento: ");
                        String departamento = scanner.nextLine();

                        Empleado nuevoEmpleado = new Empleado(0, nombre, edad, departamento);
                        repo.agregarEmpleado(nuevoEmpleado);
                        System.out.println("Empleado agregado correctamente.");
                    }

                    case 2 -> {
                        System.out.print("Ingrese el ID del empleado: ");
                        int id = scanner.nextInt();
                        Empleado empleado = repo.obtenerEmpleado(id);
                        if (empleado != null) {
                            System.out.println("Empleado encontrado: " + empleado);
                        } else {
                            System.out.println("Empleado no encontrado.");
                        }
                    }

                    case 3 -> {
                        List<Empleado> empleados = repo.obtenerTodosLosEmpleados();
                        System.out.println("\n--- Lista de Empleados ---");
                        empleados.forEach(System.out::println);
                    }

                    case 4 -> {
                        System.out.print("Ingrese el ID del empleado a actualizar: ");
                        int idActualizar = scanner.nextInt();
                        scanner.nextLine();  // Consumir nueva línea
                        Empleado empleadoExistente = repo.obtenerEmpleado(idActualizar);
                        if (empleadoExistente != null) {
                            System.out.print("Ingrese el nuevo nombre: ");
                            empleadoExistente.setNombre(scanner.nextLine());
                            System.out.print("Ingrese la nueva edad: ");
                            empleadoExistente.setEdad(scanner.nextInt());
                            scanner.nextLine(); // Consumir nueva línea
                            System.out.print("Ingrese el nuevo departamento: ");
                            empleadoExistente.setDepartamento(scanner.nextLine());

                            repo.actualizarEmpleado(empleadoExistente);
                            System.out.println("Empleado actualizado correctamente.");
                        } else {
                            System.out.println("Empleado no encontrado.");
                        }
                    }

                    case 5 -> {
                        System.out.print("Ingrese el ID del empleado a eliminar: ");
                        int idEliminar = scanner.nextInt();
                        repo.eliminarEmpleado(idEliminar);
                        System.out.println("Empleado eliminado si existía.");
                    }

                    case 6 -> System.out.println("Regresando al menú principal.");

                    default -> System.out.println("Opción no valida. Intente nuevamente.");
                }
            } while (seleccion != 6);
        }

        scanner.close();
    }
}
