## Ejercicio resuelto de un CRUD (Crear, Leer, Actualizar, Eliminar) en Java con almacenamiento en memoria utilizando una lista de objetos.
- Imaginemos que estamos gestionando una lista de usuarios. Cada usuario tiene un ID, un nombre y un correo electrónico.
- Conectarlo a una base de datos MySQL.
**1. Crear la clase Usuario:**
**2. Clase UsuarioCRUD conectada a la base de datos:**
**3. Clase Main para probar el CRUD:**

### Explicación:
**1. Conexión a la base de datos (JDBC):**
- Se establece una conexión con la base de datos MySQL usando DriverManager.getConnection().
- Se utiliza la URL de la base de datos (jdbc:mysql://localhost:3306/gestion_usuarios), junto con el nombre de usuario y la contraseña.

**2. Operaciones CRUD:**
- crearUsuario: Inserta un nuevo usuario en la tabla usuarios y devuelve el usuario con su ID generado automáticamente.
- obtenerUsuarios: Obtiene todos los usuarios de la tabla usuarios.
- obtenerUsuarioPorId: Obtiene un usuario específico por su ID.
- actualizarUsuario: Actualiza el nombre y correo de un usuario con el ID proporcionado.
- eliminarUsuario: Elimina un usuario de la base de datos por su ID.

**3. Cierre de la conexión:**
- Es importante cerrar la conexión a la base de datos una vez que las operaciones han terminado con connection.close().

### Consideraciones:
- Asegúrate de que MySQL esté ejecutándose en tu máquina y que los datos de conexión sean correctos (usuario, contraseña, nombre de la base de datos).
- Puedes usar un servidor local de MySQL como XAMPP o MAMP para pruebas locales. 
