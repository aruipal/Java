# Ejercicio: CRUD para gestionar una tabla de Libros
### 1. Estructura de la Base de Datos
- La base de datos tiene una tabla llamada `libros`, con los siguientes atributos:
```sql
CREATE TABLE libros (
    id INT PRIMARY KEY,
    titulo VARCHAR(100),
    autor VARCHAR(100),
    anio_publicacion INT,
    precio DECIMAL(10, 2)
);
```
### 2. Clase Libro
```java
public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private double precio;

    public Libro(int id, String titulo, String autor, int anioPublicacion, double precio) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.precio = precio;
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public double getPrecio() { return precio; }

    public void setId(int id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion = anioPublicacion; }
    public void setPrecio(double precio) { this.precio = precio; }

    @Override
    public String toString() {
        return "ID: " + id + ", Título: " + titulo + ", Autor: " + autor + ", Año: " + anioPublicacion + ", Precio: $" + precio;
    }
}
```
### 3. Clase LibroDAO (Data Access Object)
java
Copiar
Editar
import java.sql.*;
import java.util.*;

public class LibroDAO {

    public void insertar(Libro libro) throws SQLException {
        String sql = "INSERT INTO libros (id, titulo, autor, anio_publicacion, precio) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, libro.getId());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getAutor());
            ps.setInt(4, libro.getAnioPublicacion());
            ps.setDouble(5, libro.getPrecio());
            ps.executeUpdate();
        }
    }

    public List<Libro> obtenerTodos() throws SQLException {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Libro libro = new Libro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getInt("anio_publicacion"),
                    rs.getDouble("precio")
                );
                lista.add(libro);
            }
        }
        return lista;
    }

    public void actualizar(Libro libro) throws SQLException {
        String sql = "UPDATE libros SET titulo = ?, autor = ?, anio_publicacion = ?, precio = ? WHERE id = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getAnioPublicacion());
            ps.setDouble(4, libro.getPrecio());
            ps.setInt(5, libro.getId());
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM libros WHERE id = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
### 4. Clase Main
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibroDAO dao = new LibroDAO();

        while (true) {
            System.out.println("\nMENÚ DE OPCIONES CRUD");
            System.out.println("1. Insertar nuevo libro");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Actualizar libro existente");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = sc.nextInt(); sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Título: "); String titulo = sc.nextLine();
                        System.out.print("Autor: "); String autor = sc.nextLine();
                        System.out.print("Año de publicación: "); int anio = sc.nextInt(); sc.nextLine();
                        System.out.print("Precio: "); double precio = sc.nextDouble();
                        dao.insertar(new Libro(id, titulo, autor, anio, precio));
                        System.out.println("Libro insertado correctamente.");
                        break;
                    case 2:
                        List<Libro> libros = dao.obtenerTodos();
                        if (libros.isEmpty())
                            System.out.println("No hay libros registrados.");
                        else
                            libros.forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("ID del libro a actualizar: "); int idUpd = sc.nextInt(); sc.nextLine();
                        System.out.print("Nuevo título: "); String tituloUpd = sc.nextLine();
                        System.out.print("Nuevo autor: "); String autorUpd = sc.nextLine();
                        System.out.print("Nuevo año de publicación: "); int anioUpd = sc.nextInt(); sc.nextLine();
                        System.out.print("Nuevo precio: "); double precioUpd = sc.nextDouble();
                        dao.actualizar(new Libro(idUpd, tituloUpd, autorUpd, anioUpd, precioUpd));
                        System.out.println("Libro actualizado correctamente.");
                        break;
                    case 4:
                        System.out.print("ID a eliminar: "); int idDel = sc.nextInt();
                        dao.eliminar(idDel);
                        System.out.println("Libro eliminado correctamente.");
                        break;
                    case 5:
                        System.out.println("Gracias por utilizar el sistema. ¡Hasta pronto!");
                        return;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Se ha producido un error: " + e.getMessage());
            }
        }
    }
}
```
### Clase ConexionBD
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USUARIO = "aruipal";
    private static final String CLAVE = "Neptuno4";

    // Método para establecer la conexión con la base de datos
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}
```
### Explicación del ejercicio:
**1. Clase Libro**: Representa un libro con atributos como id, titulo, autor, anioPublicacion y precio. Tiene los métodos getters y setters para acceder y modificar estos atributos.

**2. Clase LibroDAO**: Proporciona métodos para realizar operaciones CRUD sobre la tabla libros en la base de datos:
- insertar(): Inserta un nuevo libro en la base de datos.
- obtenerTodos(): Obtiene todos los libros de la base de datos y los devuelve en una lista.
- actualizar(): Actualiza los detalles de un libro existente en la base de datos.
- eliminar(): Elimina un libro de la base de datos dado su id.
- 
**3. Clase Main**: Proporciona una interfaz de consola con un menú interactivo para que el usuario elija qué operación CRUD desea realizar con los libros. Se utiliza un objeto LibroDAO para realizar las operaciones en la base de datos.
  
**4. Clase ConexionBD**: conectarte a una base de datos MySQL llamada `biblioteca`.
___
