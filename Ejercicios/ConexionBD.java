package Ejercicios;
// Organizaremos la aplicación en cuatro clases:
// - `ConexionBD`: se encarga de la conexión a la base de datos.
// - `Alumno`: representa la entidad `alumnos`.
// - `AlumnoDAO`: contiene los métodos CRUD.
// - `Main`: interfaz por consola para el usuario.

// Esta separación mejora la legibilidad, mantenimiento y escalabilidad del proyecto.

import java.sql.*;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/escuela?useSSL=false&serverTimezone=UTC"; //"jdbc:mysql://192.168.7.41:3306/escuela";
    private static final String USUARIO = "aruipal";
    private static final String CLAVE = "Neptuno4";

    public static Connection conectar() throws SQLException {
        
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}
