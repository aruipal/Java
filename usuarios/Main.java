public class Main {
    public static void main(String[] args) {
        try {
            UsuarioCRUD usuarioCRUD = new UsuarioCRUD();

            // Crear usuarios
            Usuario usuario1 = usuarioCRUD.crearUsuario("Juan Pérez", "juan@email.com");
            Usuario usuario2 = usuarioCRUD.crearUsuario("Ana Gómez", "ana@email.com");

            // Mostrar todos los usuarios
            System.out.println("Usuarios actuales:");
            usuarioCRUD.obtenerUsuarios().forEach(System.out::println);

            // Leer un usuario por ID
            System.out.println("\nObteniendo usuario con ID 1:");
            usuarioCRUD.obtenerUsuarioPorId(1).ifPresent(System.out::println);

            // Actualizar un usuario
            System.out.println("\nActualizando usuario con ID 1:");
            usuarioCRUD.actualizarUsuario(1, "Juan Pérez actualizado", "juan.actualizado@email.com");

            // Mostrar todos los usuarios después de la actualización
            System.out.println("\nUsuarios después de actualización:");
            usuarioCRUD.obtenerUsuarios().forEach(System.out::println);

            // Eliminar un usuario
            System.out.println("\nEliminando usuario con ID 2:");
            usuarioCRUD.eliminarUsuario(2);

            // Mostrar todos los usuarios después de la eliminación
            System.out.println("\nUsuarios después de eliminación:");
            usuarioCRUD.obtenerUsuarios().forEach(System.out::println);

            // Cerrar la conexión a la base de datos
            usuarioCRUD.cerrarConexion();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
