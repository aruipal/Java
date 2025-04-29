# 🚗 CRUD de Alquiler de Coches
### 🗃️ Tabla coches
```sql
CREATE TABLE coches (
    id INT PRIMARY KEY,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    disponible BOOLEAN
);
```
- id: Identificador único del coche
- marca: Marca del coche (ej. Toyota)
- modelo: Modelo del coche (ej. Corolla)
- disponible: true si está disponible para alquilar, false si está alquilado

### 📦 Clase Coche.java
```java
public class Coche {
    private int id;
    private String marca;
    private String modelo;
    private boolean disponible;

    public Coche(int id, String marca, String modelo, boolean disponible) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.disponible = disponible;
    }

    public int getId() { return id; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public boolean isDisponible() { return disponible; }

    public void setId(int id) { this.id = id; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return "ID: " + id + ", Marca: " + marca + ", Modelo: " + modelo +
               ", Disponible: " + (disponible ? "Sí" : "No");
    }
}
```
### 🛠 Clase CocheDAO.java
```java
import java.sql.*;
import java.util.*;

public class CocheDAO {

    public void insertar(Coche coche) throws SQLException {
        String sql = "INSERT INTO coches (id, marca, modelo, disponible) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, coche.getId());
            ps.setString(2, coche.getMarca());
            ps.setString(3, coche.getModelo());
            ps.setBoolean(4, coche.isDisponible());
            ps.executeUpdate();
        }
    }

    public List<Coche> obtenerTodos() throws SQLException {
        List<Coche> lista = new ArrayList<>();
        String sql = "SELECT * FROM coches";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Coche coche = new Coche(
                    rs.getInt("id"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getBoolean("disponible")
                );
                lista.add(coche);
            }
        }
        return lista;
    }

    public void actualizarDisponibilidad(int id, boolean disponible) throws SQLException {
        String sql = "UPDATE coches SET disponible = ? WHERE id = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, disponible);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM coches WHERE id = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
```
### 🎮 Clase Main.java
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CocheDAO dao = new CocheDAO();

        while (true) {
            System.out.println("\nMENÚ ALQUILER DE COCHES");
            System.out.println("1. Registrar coche");
            System.out.println("2. Ver todos los coches");
            System.out.println("3. Actualizar disponibilidad");
            System.out.println("4. Eliminar coche");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int op = sc.nextInt(); sc.nextLine();

            try {
                switch (op) {
                    case 1:
                        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Marca: "); String marca = sc.nextLine();
                        System.out.print("Modelo: "); String modelo = sc.nextLine();
                        System.out.print("¿Está disponible? (true/false): "); boolean disponible = sc.nextBoolean();
                        dao.insertar(new Coche(id, marca, modelo, disponible));
                        System.out.println("Coche registrado.");
                        break;
                    case 2:
                        List<Coche> coches = dao.obtenerTodos();
                        coches.forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("ID del coche: "); int idCoche = sc.nextInt();
                        System.out.print("¿Nuevo estado disponible? (true/false): "); boolean nuevoEstado = sc.nextBoolean();
                        dao.actualizarDisponibilidad(idCoche, nuevoEstado);
                        System.out.println("Disponibilidad actualizada.");
                        break;
                    case 4:
                        System.out.print("ID a eliminar: "); int idEliminar = sc.nextInt();
                        dao.eliminar(idEliminar);
                        System.out.println("Coche eliminado.");
                        break;
                    case 5:
                        System.out.println("Gracias por usar el sistema.");
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
