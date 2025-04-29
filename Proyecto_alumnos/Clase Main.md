# Clase `Main` - Explicación

La clase `Main` es la clase principal que contiene el **menú de opciones** para interactuar con las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los objetos `Alumno`. Permite al usuario realizar las operaciones correspondientes a través de la consola.

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AlumnoDAO dao = new AlumnoDAO();

        while (true) {
            System.out.println("\nMENÚ DE OPCIONES CRUD");
            System.out.println("1. Insertar nuevo alumno");
            System.out.println("2. Listar todos los alumnos");
            System.out.println("3. Actualizar alumno existente");
            System.out.println("4. Eliminar alumno");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = sc.nextInt(); sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Nombre: "); String nombre = sc.nextLine();
                        System.out.print("Edad: "); int edad = sc.nextInt(); sc.nextLine();
                        System.out.print("Curso: "); String curso = sc.nextLine();
                        dao.insertar(new Alumno(id, nombre, edad, curso));
                        System.out.println("Alumno insertado correctamente.");
                        break;
                    case 2:
                        List<Alumno> alumnos = dao.obtenerTodos();
                        if (alumnos.isEmpty())
                            System.out.println("No hay alumnos registrados.");
                        else
                            alumnos.forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("ID del alumno a actualizar: "); int idUpd = sc.nextInt(); sc.nextLine();
                        System.out.print("Nuevo nombre: "); String nomUpd = sc.nextLine();
                        System.out.print("Nueva edad: "); int edadUpd = sc.nextInt(); sc.nextLine();
                        System.out.print("Nuevo curso: "); String cursoUpd = sc.nextLine();
                        dao.actualizar(new Alumno(idUpd, nomUpd, edadUpd, cursoUpd));
                        System.out.println("Alumno actualizado correctamente.");
                        break;
                    case 4:
                        System.out.print("ID a eliminar: "); int idDel = sc.nextInt();
                        dao.eliminar(idDel);
                        System.out.println("Alumno eliminado correctamente.");
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
### 🧱 Explicación de la clase Main
- **Scanner para entrada de datos**
```java
Scanner sc = new Scanner(System.in);
```
Se crea un objeto `Scanner` para leer la entrada del usuario desde la consola. Se utiliza para capturar las opciones del menú y los datos de los alumnos (ID, nombre, edad y curso).

- **Instanciación de `AlumnoDAO`**
```java
AlumnoDAO dao = new AlumnoDAO();
```
Se crea un objeto `AlumnoDAO` para realizar las operaciones **CRUD** sobre la base de datos utilizando los métodos definidos en la clase `AlumnoDAO`.

### 🔧 Menú de Opciones
- El menú se muestra continuamente en un bucle while(true), lo que permite que el usuario ejecute múltiples operaciones hasta que decida salir.

**Operaciones CRUD:**
1. **Insertar nuevo alumno**
```java
System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
System.out.print("Nombre: "); String nombre = sc.nextLine();
System.out.print("Edad: "); int edad = sc.nextInt(); sc.nextLine();
System.out.print("Curso: "); String curso = sc.nextLine();
dao.insertar(new Alumno(id, nombre, edad, curso));
```
Solicita al usuario los datos del nuevo alumno y luego llama al método `insertar() de AlumnoDAO` para agregar el alumno a la base de datos.

2. **Listar todos los alumnos**
```java
List<Alumno> alumnos = dao.obtenerTodos();
if (alumnos.isEmpty())
    System.out.println("No hay alumnos registrados.");
else
    alumnos.forEach(System.out::println);
```
Recupera todos los alumnos de la base de datos a través de `dao.obtenerTodos()` y los muestra en consola.

3. **Actualizar alumno existente**
```java
System.out.print("ID del alumno a actualizar: "); int idUpd = sc.nextInt(); sc.nextLine();
System.out.print("Nuevo nombre: "); String nomUpd = sc.nextLine();
System.out.print("Nueva edad: "); int edadUpd = sc.nextInt(); sc.nextLine();
System.out.print("Nuevo curso: "); String cursoUpd = sc.nextLine();
dao.actualizar(new Alumno(idUpd, nomUpd, edadUpd, cursoUpd));
```
Permite al usuario actualizar los datos de un alumno, proporcionando su ID y los nuevos valores para nombre, edad y curso.\
Luego se llama al método `actualizar() de AlumnoDAO`.

4. **Eliminar alumno**
```java

System.out.print("ID a eliminar: "); int idDel = sc.nextInt();
dao.eliminar(idDel);
```
Solicita el **ID** del alumno a eliminar y llama al método `eliminar() de AlumnoDAO` para eliminar el alumno correspondiente.

5. **Salir**
```java
System.out.println("Gracias por utilizar el sistema. ¡Hasta pronto!");
return;
```
Si el usuario selecciona la opción 5, el programa termina con un mensaje de despedida.

### 🧠 Conclusión
- La clase `Main` proporciona una interfaz de consola interactiva que permite al usuario realizar operaciones **CRUD** sobre la base de datos de alumnos. 
- Utiliza las clases `AlumnoDAO` y `Alumno` para manejar las operaciones y muestra los resultados en la consola.




