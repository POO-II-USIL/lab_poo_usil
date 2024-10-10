package com.usil.hampcode.repository;

import com.usil.hampcode.model.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepositoryMySQL implements EmpleadoRepository {
    private Connection connection;

    public EmpleadoRepositoryMySQL() throws SQLException {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public void agregarEmpleado(Empleado empleado) {
        String query = "INSERT INTO empleados(nombre, edad, departamento) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, empleado.getNombre());
            pstmt.setInt(2, empleado.getEdad());
            pstmt.setString(3, empleado.getDepartamento());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Empleado obtenerEmpleado(int id) {
        String query = "SELECT * FROM empleados WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Empleado(rs.getInt("id"), rs.getString("nombre"), rs.getInt("edad"), rs.getString("departamento"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Empleado> obtenerTodosLosEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM empleados";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                empleados.add(new Empleado(rs.getInt("id"), rs.getString("nombre"), rs.getInt("edad"), rs.getString("departamento")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    @Override
    public void actualizarEmpleado(Empleado empleado) {
        String query = "UPDATE empleados SET nombre = ?, edad = ?, departamento = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, empleado.getNombre());
            pstmt.setInt(2, empleado.getEdad());
            pstmt.setString(3, empleado.getDepartamento());
            pstmt.setInt(4, empleado.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarEmpleado(int id) {
        String query = "DELETE FROM empleados WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}