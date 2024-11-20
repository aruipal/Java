import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.SQLException;  // Asegúrate de agregar esto en UsuarioCRUD.java


public class UsuarioCRUD {

    private static final String URL = "jdbc:mysql://192.168.7.41:3306/gestion_usuarios"; // Cambia si tu base de datos tiene un puerto diferente
    private static final String USER = "root";  // Cambia esto con tu usuario de MySQL
    private static final String PASSWORD = "Tic2024P@55W0rD";  // Cambia esto con tu contraseña de MySQL

    private Connection connection;

    public UsuarioCRUD() throws SQLException {
        // Establecer la conexión con la base de datos
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Crear un nuevo usuario
    public Usuario crearUsuario(String nombre, String correo) throws SQLException {
        String query = "INSERT INTO usuarios (nombre, correo) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, nombre);
            statement.setString(2, correo);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    return new Usuario(id, nombre, correo);
                }
            }
            return null;
        }
    }

    // Leer todos los usuarios
    public List<Usuario> obtenerUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuarios";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String correo = resultSet.getString("correo");
                usuarios.add(new Usuario(id, nombre, correo));
            }
        }
        return usuarios;
    }

    // Leer un usuario por ID
    public Optional<Usuario> obtenerUsuarioPorId(int id) throws SQLException {
        String query = "SELECT * FROM usuarios WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String correo = resultSet.getString("correo");
                return Optional.of(new Usuario(id, nombre, correo));
            }
        }
        return Optional.empty();
    }

    // Actualizar un usuario por ID
    public boolean actualizarUsuario(int id, String nuevoNombre, String nuevoCorreo) throws SQLException {
        String query = "UPDATE usuarios SET nombre = ?, correo = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nuevoNombre);
            statement.setString(2, nuevoCorreo);
            statement.setInt(3, id);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    // Eliminar un usuario por ID
    public boolean eliminarUsuario(int id) throws SQLException {
        String query = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public void cerrarConexion() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
