# 🧾 Ejercicio CRUD: Gestión de Clientes
### 1. Estructura de la tabla clientes
```sql
CREATE TABLE clientes (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    correo VARCHAR(100),
    telefono VARCHAR(20)
);
```
### 2. Clase Cliente
```java
public class Cliente {
    private int id;
    private String nombre;
    private String correo;
    private String telefono;

    public Cliente(int id, String nombre, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Correo: " + correo + ", Teléfono: " + telefono;
    }
}
```
### 3. Clase ClienteDAO
```java
import java.sql.*;
import java.util.*;

public class ClienteDAO {

    public void insertar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (id, nombre, correo, telefono) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, cliente.getId());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getTelefono());
            ps.executeUpdate();
        }
    }

    public List<Cliente> obtenerTodos() throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cliente c = new Cliente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("telefono")
                );
                lista.add(c);
            }
        }
        return lista;
    }

    public void actualizar(Cliente cliente) throws SQLException {
        String sql = "UPDATE clientes SET nombre = ?, correo = ?, telefono = ? WHERE id = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getCorreo());
            ps.setString(3, cliente.getTelefono());
            ps.setInt(4, cliente.getId());
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM clientes WHERE id = ?";
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
        ClienteDAO dao = new ClienteDAO();

        while (true) {
            System.out.println("\nMENÚ CLIENTES");
            System.out.println("1. Insertar nuevo cliente");
            System.out.println("2. Listar todos los clientes");
            System.out.println("3. Actualizar cliente existente");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt(); sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Nombre: "); String nombre = sc.nextLine();
                        System.out.print("Correo: "); String correo = sc.nextLine();
                        System.out.print("Teléfono: "); String telefono = sc.nextLine();
                        dao.insertar(new Cliente(id, nombre, correo, telefono));
                        System.out.println("Cliente insertado correctamente.");
                        break;
                    case 2:
                        List<Cliente> clientes = dao.obtenerTodos();
                        if (clientes.isEmpty())
                            System.out.println("No hay clientes registrados.");
                        else
                            clientes.forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("ID del cliente a actualizar: "); int idUpd = sc.nextInt(); sc.nextLine();
                        System.out.print("Nuevo nombre: "); String nombreUpd = sc.nextLine();
                        System.out.print("Nuevo correo: "); String correoUpd = sc.nextLine();
                        System.out.print("Nuevo teléfono: "); String telUpd = sc.nextLine();
                        dao.actualizar(new Cliente(idUpd, nombreUpd, correoUpd, telUpd));
                        System.out.println("Cliente actualizado correctamente.");
                        break;
                    case 4:
                        System.out.print("ID del cliente a eliminar: "); int idDel = sc.nextInt();
                        dao.eliminar(idDel);
                        System.out.println("Cliente eliminado correctamente.");
                        break;
                    case 5:
                        System.out.println("¡Gracias por usar el sistema!");
                        return;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
```
