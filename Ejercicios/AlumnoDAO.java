package Ejercicios;

// - `AlumnoDAO`: contiene los métodos CRUD.

import java.sql.*;
import java.util.*;

public class AlumnoDAO {

    public void insertar(Alumno2 alumno) throws SQLException {
        String sql = "INSERT INTO alumnos (id, nombre, edad, curso) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, alumno.getId());
            ps.setString(2, alumno.getNombre());
            ps.setInt(3, alumno.getEdad());
            ps.setString(4, alumno.getCurso());
            ps.executeUpdate();
        }
    }

    public List<Alumno2> obtenerTodos() throws SQLException {
        List<Alumno2> lista = new ArrayList<>();
        String sql = "SELECT * FROM alumnos";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Alumno2 a = new Alumno2(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getString("curso")
                );
                lista.add(a);
            }
        }
        return lista;
    }

    public void actualizar(Alumno2 alumno) throws SQLException {
        String sql = "UPDATE alumnos SET nombre = ?, edad = ?, curso = ? WHERE id = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, alumno.getNombre());
            ps.setInt(2, alumno.getEdad());
            ps.setString(3, alumno.getCurso());
            ps.setInt(4, alumno.getId());
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM alumnos WHERE id = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}