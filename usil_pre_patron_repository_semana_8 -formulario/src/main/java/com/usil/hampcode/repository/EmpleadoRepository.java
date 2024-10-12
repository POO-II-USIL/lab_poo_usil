package com.usil.hampcode.repository;

import com.usil.hampcode.model.Empleado;
import java.util.List;

public interface EmpleadoRepository {
    void agregarEmpleado(Empleado empleado);
    Empleado obtenerEmpleado(int id);
    List<Empleado> obtenerTodosLosEmpleados();
    void actualizarEmpleado(Empleado empleado);
    void eliminarEmpleado(int id);
}