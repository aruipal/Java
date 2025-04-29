# Clase `Alumno` - Explicación

- Esta clase representa a un alumno con sus atributos básicos y métodos de acceso.

```java
package com.escano;

public class Alumno {
    private int id;
    private String nombre;
    private int edad;
    private String curso;

    public Alumno(int id, String nombre, int edad, String curso) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getCurso() { return curso; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setCurso(String curso) { this.curso = curso; }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad + ", Curso: " + curso;
    }
}
```
### 📦 Paquete
```java
package com.escano;
```
- Ubica la clase dentro del paquete com.escano para mantener el código organizado.

### 🧱 Atributos privados
```java
private int id;
private String nombre;
private int edad;
private String curso;
```
- id: Identificador del alumno.
- nombre: Nombre completo.
- edad: Edad del alumno.
- curso: Curso o materia en la que está inscrito.

### 🔧 Constructor
```java
public Alumno(int id, String nombre, int edad, String curso) { ... }
```
- Permite crear objetos Alumno con sus atributos completos.
Ejemplo:
```java
Alumno a = new Alumno(1, "Juan", 20, "Matemáticas");
```

### 📥 Getters y Setters
- Proveen acceso controlado a los atributos privados.
```java
alumno.getNombre(); // Devuelve el nombre
alumno.setEdad(21); // Cambia la edad
```

### 🖨 Método toString()
```java
@Override
public String toString() {
    return "ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad + ", Curso: " + curso;
}
```
- Devuelve una representación legible del objeto cuando se imprime por consola:
```java
System.out.println(alumno);
```

