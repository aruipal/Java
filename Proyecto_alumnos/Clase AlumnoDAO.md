# Clase `AlumnoDAO` - Explicación

La clase `AlumnoDAO` es responsable de gestionar las operaciones de **persistencia** en la base de datos para los objetos `Alumno`. Realiza las operaciones **CRUD** (Crear, Leer, Actualizar, Eliminar).

```java
import java.sql.*;
import java.util.*;

public class AlumnoDAO {

    public void insertar(Alumno alumno) throws SQLException {
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

    public List<Alumno> obtenerTodos() throws SQLException {
        List<Alumno> lista = new ArrayList<>();
        String sql = "SELECT * FROM alumnos";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Alumno a = new Alumno(
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

    public void actualizar(Alumno alumno) throws SQLException {
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
```

### 🧱 Métodos de la clase AlumnoDAO
**1. insertar(Alumno alumno)**
```java
public void insertar(Alumno alumno) throws SQLException { ... }
```
- Este método inserta un nuevo Alumno en la base de datos. Utiliza una sentencia `SQL INSERT INTO` y un PreparedStatement para evitar la inyección de SQL.
- Se asignan los valores del objeto Alumno a los parámetros de la consulta.
- Luego, se ejecuta ps.executeUpdate() para ejecutar la inserción.

**2. obtenerTodos()**
```java
public List<Alumno> obtenerTodos() throws SQLException { ... }
```
- Este método recupera todos los registros de la tabla alumnos y los convierte en una lista de objetos Alumno.
- Se ejecuta una consulta `SQL SELECT * FROM alumnos`.
- Se recorre el ResultSet con while (rs.next()) y se crea un nuevo objeto Alumno para cada fila.
- Los objetos Alumno se agregan a una lista, que luego es devuelta.

**3. actualizar(Alumno alumno)**
```java
public void actualizar(Alumno alumno) throws SQLException { ... }
```
- Este método actualiza los datos de un Alumno en la base de datos.
- Utiliza una sentencia `SQL UPDATE` con un PreparedStatement para cambiar el nombre, edad y curso de un Alumno según su id.
- Los valores se asignan a los parámetros del PreparedStatement y se ejecuta ps.executeUpdate() para hacer efectiva la actualización.

**4. eliminar(int id)**
```java
public void eliminar(int id) throws SQLException { ... }
```
- Este método elimina un Alumno de la base de datos, dado su id.
- Utiliza una sentencia `SQL DELETE FROM alumnos WHERE id = ?`.
- El id del alumno a eliminar se pasa como parámetro en el PreparedStatement y se ejecuta ps.executeUpdate() para eliminar el registro correspondiente.

### 🔐 Conexión con la Base de Datos
Cada uno de los métodos utiliza la clase ConexionBD para obtener una conexión a la base de datos MySQL, utilizando `ConexionBD.conectar()`.

### ✅ Conclusión
- La clase `AlumnoDAO` proporciona una interfaz para interactuar con la base de datos y realizar operaciones CRUD en la tabla alumnos. 
- Utiliza JDBC y PreparedStatement para garantizar una conexión eficiente y segura a la base de datos.
