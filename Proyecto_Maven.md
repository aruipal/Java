# ✅ Proyecto Maven: mi-proyecto
**📁 Estructura del proyecto:**
```
mi-proyecto/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── miempresa/
                    ├── Persona.java
                    ├── PersonaDAO.java
                    └── Main.java
```
**🔹 pom.xml**
- Este archivo declara el proyecto y las dependencias (MySQL, exec plugin).
```
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.miempresa</groupId>
    <artifactId>mi-proyecto</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <!-- Driver MySQL -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <version>8.3.0</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!-- Plugin para ejecutar clases Java -->
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>3.1.0</version>
                <configuration>
                    <mainClass>com.miempresa.Main</mainClass>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```
**🔹 Persona.java**
```
package com.miempresa;

public class Persona {
    private String nombre;
    private int anioNacimiento;

    public Persona(String nombre, int anioNacimiento) {
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public int calcularEdad(int anioActual) {
        return anioActual - anioNacimiento;
    }

    public void mostrarInformacion(int anioActual) {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + calcularEdad(anioActual));
    }
}
```
**🔹 PersonaDAO.java**
```
package com.miempresa;

import java.sql.*;

public class PersonaDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/mi_basedatos";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "tu_contraseña"; // Cambia esto

    public void insertarPersona(Persona persona) {
        String sql = "INSERT INTO personas (nombre, anio_nacimiento) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, persona.getNombre());
            stmt.setInt(2, persona.getAnioNacimiento());

            stmt.executeUpdate();
            System.out.println("Persona insertada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarPersonas() {
        String sql = "SELECT * FROM personas";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int anio = rs.getInt("anio_nacimiento");
                Persona p = new Persona(nombre, anio);
                p.mostrarInformacion(2025);
                System.out.println("--------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```
**🔹 Main.java**
```
package com.miempresa;

public class Main {
    public static void main(String[] args) {
        PersonaDAO dao = new PersonaDAO();

        // Insertar una persona
        Persona nueva = new Persona("Carlos", 1995);
        dao.insertarPersona(nueva);

        // Listar todas las personas
        dao.listarPersonas();
    }
}
```
**📌 Pasos finales para ejecutarlo:**
- Crea la base de datos en MySQL:
```
CREATE DATABASE mi_basedatos;
USE mi_basedatos;

CREATE TABLE personas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    anio_nacimiento INT
);
```
- Cambia tu contraseña en PersonaDAO.java
```
private static final String CONTRASENA = "tu_contraseña";
```
- Compila y ejecuta en terminal:
```
mvn compile
mvn exec:java
```
