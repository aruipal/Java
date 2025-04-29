# Ejercicio: CRUD para gestionar una tabla de Empleados
### 1. Estructura de la Base de Datos
La base de datos tiene una tabla llamada empleados, con los siguientes atributos:
```sql
CREATE TABLE empleados (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    departamento VARCHAR(50),
    salario DECIMAL(10, 2),
    fecha_ingreso DATE
);
```

### 2. Clase Empleado
```java
public class Empleado {
    private int id;
    private String nombre;
    private String departamento;
    private double salario;
    private java.sql.Date fechaIngreso;

    public Empleado(int id, String nombre, String departamento, double salario, java.sql.Date fechaIngreso) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
        this.fechaIngreso = fechaIngreso;
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDepartamento() { return departamento; }
    public double getSalario() { return salario; }
    public java.sql.Date getFechaIngreso() { return fechaIngreso; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
    public void setSalario(double salario) { this.salario = salario; }
    public void setFechaIngreso(java.sql.Date fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Departamento: " + departamento + ", Salario: $" + salario + ", Fecha de Ingreso: " + fechaIngreso;
    }
}
```
### 3. Clase EmpleadoDAO (Data Access Object)
```java
import java.sql.*;
import java.util.*;

public class EmpleadoDAO {

    public void insertar(Empleado empleado) throws SQLException {
        String sql = "INSERT INTO empleados (id, nombre, departamento, salario, fecha_ingreso) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, empleado.getId());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getDepartamento());
            ps.setDouble(4, empleado.getSalario());
            ps.setDate(5, empleado.getFechaIngreso());
            ps.executeUpdate();
        }
    }

    public List<Empleado> obtenerTodos() throws SQLException {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Empleado e = new Empleado(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("departamento"),
                    rs.getDouble("salario"),
                    rs.getDate("fecha_ingreso")
                );
                lista.add(e);
            }
        }
        return lista;
    }

    public void actualizar(Empleado empleado) throws SQLException {
        String sql = "UPDATE empleados SET nombre = ?, departamento = ?, salario = ?, fecha_ingreso = ? WHERE id = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getDepartamento());
            ps.setDouble(3, empleado.getSalario());
            ps.setDate(4, empleado.getFechaIngreso());
            ps.setInt(5, empleado.getId());
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM empleados WHERE id = ?";
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
        EmpleadoDAO dao = new EmpleadoDAO();

        while (true) {
            System.out.println("\nMENÚ DE OPCIONES CRUD");
            System.out.println("1. Insertar nuevo empleado");
            System.out.println("2. Listar todos los empleados");
            System.out.println("3. Actualizar empleado existente");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = sc.nextInt(); sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Nombre: "); String nombre = sc.nextLine();
                        System.out.print("Departamento: "); String departamento = sc.nextLine();
                        System.out.print("Salario: "); double salario = sc.nextDouble(); sc.nextLine();
                        System.out.print("Fecha de Ingreso (YYYY-MM-DD): "); String fechaStr = sc.nextLine();
                        Date fechaIngreso = Date.valueOf(fechaStr);
                        dao.insertar(new Empleado(id, nombre, departamento, salario, fechaIngreso));
                        System.out.println("Empleado insertado correctamente.");
                        break;
                    case 2:
                        List<Empleado> empleados = dao.obtenerTodos();
                        if (empleados.isEmpty())
                            System.out.println("No hay empleados registrados.");
                        else
                            empleados.forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("ID del empleado a actualizar: "); int idUpd = sc.nextInt(); sc.nextLine();
                        System.out.print("Nuevo nombre: "); String nombreUpd = sc.nextLine();
                        System.out.print("Nuevo departamento: "); String depUpd = sc.nextLine();
                        System.out.print("Nuevo salario: "); double salarioUpd = sc.nextDouble(); sc.nextLine();
                        System.out.print("Nueva fecha de ingreso (YYYY-MM-DD): "); String fechaUpdStr = sc.nextLine();
                        Date fechaUpd = Date.valueOf(fechaUpdStr);
                        dao.actualizar(new Empleado(idUpd, nombreUpd, depUpd, salarioUpd, fechaUpd));
                        System.out.println("Empleado actualizado correctamente.");
                        break;
                    case 4:
                        System.out.print("ID a eliminar: "); int idDel = sc.nextInt();
                        dao.eliminar(idDel);
                        System.out.println("Empleado eliminado correctamente.");
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
