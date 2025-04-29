# Ejercicio: CRUD para gestionar una tabla de Productos
### 1. Estructura de la Base de Datos
- La base de datos tiene una tabla llamada productos, con los siguientes atributos:
```sql
CREATE TABLE productos (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    categoria VARCHAR(50),
    precio DECIMAL(10, 2),
    cantidad INT
);
```
### 2. Clase Producto
```java
public class Producto {
    private int id;
    private String nombre;
    private String categoria;
    private double precio;
    private int cantidad;

    public Producto(int id, String nombre, String categoria, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Categoría: " + categoria + ", Precio: $" + precio + ", Cantidad: " + cantidad;
    }
}
```
### 3. Clase ProductoDAO (Data Access Object)
```java
import java.sql.*;
import java.util.*;

public class ProductoDAO {

    public void insertar(Producto producto) throws SQLException {
        String sql = "INSERT INTO productos (id, nombre, categoria, precio, cantidad) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, producto.getId());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getCategoria());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getCantidad());
            ps.executeUpdate();
        }
    }

    public List<Producto> obtenerTodos() throws SQLException {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producto p = new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("categoria"),
                    rs.getDouble("precio"),
                    rs.getInt("cantidad")
                );
                lista.add(p);
            }
        }
        return lista;
    }

    public void actualizar(Producto producto) throws SQLException {
        String sql = "UPDATE productos SET nombre = ?, categoria = ?, precio = ?, cantidad = ? WHERE id = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getCategoria());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getCantidad());
            ps.setInt(5, producto.getId());
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
```
### 4. Clase Main
```java
import java.util.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductoDAO dao = new ProductoDAO();

        while (true) {
            System.out.println("\nMENÚ DE OPCIONES CRUD");
            System.out.println("1. Insertar nuevo producto");
            System.out.println("2. Listar todos los productos");
            System.out.println("3. Actualizar producto existente");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = sc.nextInt(); sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Nombre: "); String nombre = sc.nextLine();
                        System.out.print("Categoría: "); String categoria = sc.nextLine();
                        System.out.print("Precio: "); double precio = sc.nextDouble(); sc.nextLine();
                        System.out.print("Cantidad: "); int cantidad = sc.nextInt(); sc.nextLine();
                        dao.insertar(new Producto(id, nombre, categoria, precio, cantidad));
                        System.out.println("Producto insertado correctamente.");
                        break;
                    case 2:
                        List<Producto> productos = dao.obtenerTodos();
                        if (productos.isEmpty())
                            System.out.println("No hay productos registrados.");
                        else
                            productos.forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("ID del producto a actualizar: "); int idUpd = sc.nextInt(); sc.nextLine();
                        System.out.print("Nuevo nombre: "); String nombreUpd = sc.nextLine();
                        System.out.print("Nueva categoría: "); String categoriaUpd = sc.nextLine();
                        System.out.print("Nuevo precio: "); double precioUpd = sc.nextDouble(); sc.nextLine();
                        System.out.print("Nueva cantidad: "); int cantidadUpd = sc.nextInt(); sc.nextLine();
                        dao.actualizar(new Producto(idUpd, nombreUpd, categoriaUpd, precioUpd, cantidadUpd));
                        System.out.println("Producto actualizado correctamente.");
                        break;
                    case 4:
                        System.out.print("ID a eliminar: "); int idDel = sc.nextInt();
                        dao.eliminar(idDel);
                        System.out.println("Producto eliminado correctamente.");
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
