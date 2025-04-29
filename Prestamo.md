# 📚 CRUD de Préstamos de Libros
Este ejemplo gestiona los préstamos de libros con los siguientes campos:
- id: identificador del préstamo
- titulo_libro: título del libro prestado
- nombre_usuario: nombre de quien toma el préstamo
- fecha_prestamo: fecha en la que se prestó
- devuelto: booleano (true o false) que indica si fue devuelto

### 🧱 Tabla prestamos (MySQL)
```sql
CREATE TABLE prestamos (
    id INT PRIMARY KEY,
    titulo_libro VARCHAR(150),
    nombre_usuario VARCHAR(100),
    fecha_prestamo DATE,
    devuelto BOOLEAN
);
```
### 📦 Clase Prestamo
```java
import java.sql.Date;

public class Prestamo {
    private int id;
    private String tituloLibro;
    private String nombreUsuario;
    private Date fechaPrestamo;
    private boolean devuelto;

    public Prestamo(int id, String tituloLibro, String nombreUsuario, Date fechaPrestamo, boolean devuelto) {
        this.id = id;
        this.tituloLibro = tituloLibro;
        this.nombreUsuario = nombreUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.devuelto = devuelto;
    }

    public int getId() { return id; }
    public String getTituloLibro() { return tituloLibro; }
    public String getNombreUsuario() { return nombreUsuario; }
    public Date getFechaPrestamo() { return fechaPrestamo; }
    public boolean isDevuelto() { return devuelto; }

    public void setId(int id) { this.id = id; }
    public void setTituloLibro(String tituloLibro) { this.tituloLibro = tituloLibro; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public void setFechaPrestamo(Date fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }
    public void setDevuelto(boolean devuelto) { this.devuelto = devuelto; }

    @Override
    public String toString() {
        return "ID: " + id + ", Libro: " + tituloLibro + ", Usuario: " + nombreUsuario +
               ", Fecha: " + fechaPrestamo + ", Devuelto: " + (devuelto ? "Sí" : "No");
    }
}
```
### 🛠 Clase PrestamoDAO
```java
Copiar
Editar
import java.sql.*;
import java.util.*;

public class PrestamoDAO {

    public void insertar(Prestamo p) throws SQLException {
        String sql = "INSERT INTO prestamos (id, titulo_libro, nombre_usuario, fecha_prestamo, devuelto) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, p.getId());
            ps.setString(2, p.getTituloLibro());
            ps.setString(3, p.getNombreUsuario());
            ps.setDate(4, p.getFechaPrestamo());
            ps.setBoolean(5, p.isDevuelto());
            ps.executeUpdate();
        }
    }

    public List<Prestamo> obtenerTodos() throws SQLException {
        List<Prestamo> lista = new ArrayList<>();
        String sql = "SELECT * FROM prestamos";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Prestamo p = new Prestamo(
                    rs.getInt("id"),
                    rs.getString("titulo_libro"),
                    rs.getString("nombre_usuario"),
                    rs.getDate("fecha_prestamo"),
                    rs.getBoolean("devuelto")
                );
                lista.add(p);
            }
        }
        return lista;
    }

    public void marcarDevuelto(int id) throws SQLException {
        String sql = "UPDATE prestamos SET devuelto = true WHERE id = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM prestamos WHERE id = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
```
### 🧪 Clase Main
```java
import java.sql.Date;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrestamoDAO dao = new PrestamoDAO();

        while (true) {
            System.out.println("\nGESTIÓN DE PRÉSTAMOS");
            System.out.println("1. Registrar préstamo");
            System.out.println("2. Ver todos los préstamos");
            System.out.println("3. Marcar como devuelto");
            System.out.println("4. Eliminar préstamo");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt(); sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Título del libro: "); String libro = sc.nextLine();
                        System.out.print("Nombre del usuario: "); String usuario = sc.nextLine();
                        Date fecha = new Date(System.currentTimeMillis());
                        dao.insertar(new Prestamo(id, libro, usuario, fecha, false));
                        System.out.println("Préstamo registrado.");
                        break;
                    case 2:
                        List<Prestamo> prestamos = dao.obtenerTodos();
                        prestamos.forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("ID del préstamo a marcar como devuelto: ");
                        int idDev = sc.nextInt();
                        dao.marcarDevuelto(idDev);
                        System.out.println("Préstamo marcado como devuelto.");
                        break;
                    case 4:
                        System.out.print("ID del préstamo a eliminar: ");
                        int idDel = sc.nextInt();
                        dao.eliminar(idDel);
                        System.out.println("Préstamo eliminado.");
                        break;
                    case 5:
                        System.out.println("¡Hasta luego!");
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
```
