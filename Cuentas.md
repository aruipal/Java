# 💳 CRUD de Cuentas Bancarias
### 🗃️ Tabla cuentas
```sql
CREATE TABLE cuentas (
    id INT PRIMARY KEY,
    titular VARCHAR(100),
    saldo DOUBLE,
    tipo VARCHAR(20)
);
```
- `id`: ID único de la cuenta
- `titular`: Nombre del propietario de la cuenta
- `saldo`: Dinero disponible
- `tipo`: Tipo de cuenta (por ejemplo, "ahorros", "corriente")

### 📦 Clase Cuenta
```java
public class Cuenta {
    private int id;
    private String titular;
    private double saldo;
    private String tipo;

    public Cuenta(int id, String titular, double saldo, String tipo) {
        this.id = id;
        this.titular = titular;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    public int getId() { return id; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }
    public String getTipo() { return tipo; }

    public void setId(int id) { this.id = id; }
    public void setTitular(String titular) { this.titular = titular; }
    public void setSaldo(double saldo) { this.saldo = saldo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public String toString() {
        return "Cuenta ID: " + id + ", Titular: " + titular +
               ", Saldo: " + saldo + ", Tipo: " + tipo;
    }
}
```
### 🛠 Clase CuentaDAO
```java
import java.sql.*;
import java.util.*;

public class CuentaDAO {

    public void insertar(Cuenta c) throws SQLException {
        String sql = "INSERT INTO cuentas (id, titular, saldo, tipo) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, c.getId());
            ps.setString(2, c.getTitular());
            ps.setDouble(3, c.getSaldo());
            ps.setString(4, c.getTipo());
            ps.executeUpdate();
        }
    }

    public List<Cuenta> obtenerTodas() throws SQLException {
        List<Cuenta> lista = new ArrayList<>();
        String sql = "SELECT * FROM cuentas";
        try (Connection con = ConexionBD.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Cuenta c = new Cuenta(
                    rs.getInt("id"),
                    rs.getString("titular"),
                    rs.getDouble("saldo"),
                    rs.getString("tipo")
                );
                lista.add(c);
            }
        }
        return lista;
    }

    public void actualizarSaldo(int id, double nuevoSaldo) throws SQLException {
        String sql = "UPDATE cuentas SET saldo = ? WHERE id = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, nuevoSaldo);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM cuentas WHERE id = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
```
### 🎮 Clase Main
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CuentaDAO dao = new CuentaDAO();

        while (true) {
            System.out.println("\nGESTIÓN DE CUENTAS BANCARIAS");
            System.out.println("1. Crear nueva cuenta");
            System.out.println("2. Ver todas las cuentas");
            System.out.println("3. Actualizar saldo");
            System.out.println("4. Eliminar cuenta");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = sc.nextInt(); sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Titular: "); String titular = sc.nextLine();
                        System.out.print("Saldo inicial: "); double saldo = sc.nextDouble(); sc.nextLine();
                        System.out.print("Tipo de cuenta: "); String tipo = sc.nextLine();
                        dao.insertar(new Cuenta(id, titular, saldo, tipo));
                        System.out.println("Cuenta creada.");
                        break;
                    case 2:
                        List<Cuenta> cuentas = dao.obtenerTodas();
                        cuentas.forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("ID de la cuenta: "); int idSaldo = sc.nextInt();
                        System.out.print("Nuevo saldo: "); double nuevoSaldo = sc.nextDouble();
                        dao.actualizarSaldo(idSaldo, nuevoSaldo);
                        System.out.println("Saldo actualizado.");
                        break;
                    case 4:
                        System.out.print("ID a eliminar: "); int idEliminar = sc.nextInt();
                        dao.eliminar(idEliminar);
                        System.out.println("Cuenta eliminada.");
                        break;
                    case 5:
                        System.out.println("¡Adiós!");
                        return;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
```
