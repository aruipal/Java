# Clase `ConexionBD` - Explicación

- Esta clase se encarga de establecer una conexión con una base de datos MySQL utilizando JDBC.

```java
import java.sql.*;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://192.168.7.41:3306/escuela";
    private static final String USUARIO = "SuPeRuSeR";
    private static final String CLAVE = "SuPeR2024Us3R";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}
```
### 🔐 Atributos de conexión
```java
private static final String URL = "jdbc:mysql://192.168.7.41:3306/escuela";
private static final String USUARIO = "SuPeRuSeR";
private static final String CLAVE = "SuPeR2024Us3R";
```
- Estos campos contienen los datos necesarios para conectarse a la base de datos:
1. `URL`: La dirección del servidor MySQL (192.168.7.41), puerto (3306) y nombre de la base de datos (escuela).
2. `USUARIO`: El nombre de usuario con permisos de acceso.
3. `CLAVE`: La contraseña del usuario.

🔒 Nota: En entornos reales, las credenciales deben guardarse en archivos de configuración externos o variables de entorno, no en el código fuente.

### 🔌 Método conectar()
``` java
public static Connection conectar() throws SQLException {
    return DriverManager.getConnection(URL, USUARIO, CLAVE);
}
```
- Este método:
1. Es estático, por lo que se puede llamar sin crear una instancia de la clase.
2. Llama a DriverManager.getConnection(...) para abrir una conexión con los parámetros definidos.
3. Lanza una excepción SQLException si ocurre un error (por ejemplo, si el servidor no está disponible o las credenciales son incorrectas).

### ✅ Ejemplo de uso
```java
try (Connection conn = ConexionBD.conectar()) {
    System.out.println("Conexión establecida correctamente.");
} catch (SQLException e) {
    System.out.println("Error al conectar: " + e.getMessage());
}
```
### 🧠 Conclusión
- La clase `ConexionBD` es una utilidad sencilla para centralizar la lógica de conexión a la base de datos MySQL.
- Es útil para reutilizar la conexión desde distintas clases del proyecto.
