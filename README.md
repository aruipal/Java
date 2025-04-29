<image src="https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/1200px-Java_programming_language_logo.svg.png" alt="logo" width="80" height="160">&nbsp;&nbsp;&nbsp; 0️⃣: [**ÍNDICE:**](https://github.com/aruipal/Java/blob/main/README.md)
 
### :point_right:	1️⃣:	[Tipos de datos y variables.](https://github.com/aruipal/Java/blob/main/Tipos%20de%20datos%20y%20variables.md)
### :point_right:	2️⃣:	[Operadores y expresiones.](https://github.com/aruipal/Java/blob/main/Operadores%20y%20Expresiones%20en%20Java.md)
### :point_right:   3️⃣: [Control de Flujo: if, else, switch.](https://github.com/aruipal/Java/blob/main/Control%20de%20Flujo.md)
### :point_right:   4️⃣: [Bucles for, while, do-while.](https://github.com/aruipal/Java/blob/main/Bucles%20for,%20while,%20do-while.md)
### :point_right:   5️⃣: [Métodos: Definición, Parámetros y Retorno.](https://github.com/aruipal/Java/blob/main/Metodos%20Definicion%20Parametros%20y%20Retorno.md)
### :point_right:   6️⃣: [Manejo de excepciones básicas.](https://github.com/aruipal/Java/blob/main/Manejo%20de%20Excepciones%20B%C3%A1sicas.md)
### :point_right:   7️⃣: [Clases y Objetos.](https://github.com/aruipal/Java/blob/main/Clases%20y%20Objetos.md)
### :point_right:   8️⃣: [Maven en Java.](https://github.com/aruipal/Java/blob/main/Maven.md)

___

## Estructura Básica de un Programa en Java
---
### 1. Elementos fundamentales de un programa Java

Un programa típico en Java consta de los siguientes elementos:
- **Package**: Organización de clases en grupos.
- **Importaciones**: Inclusión de clases externas o estándar.
- **Clase principal**: Punto de entrada del programa.
- **Método main**: Método donde comienza la ejecución.
- **Instrucciones**: Código que realiza las acciones.

### 1.1 Package
Sirve para organizar el código en proyectos grandes.
```
package com.miempresa.proyecto;
```
### 1.2 Importaciones
Permiten acceder a clases ya existentes, como Scanner para leer del teclado.
```
import java.util.Scanner;
```
### 1.3 Clase principal
Toda aplicación en Java debe tener una clase pública que coincida con el nombre del archivo.
```
public class HolaMundo {
```
### 1.4 Método main
Es el punto de entrada del programa Java.
```
    public static void main(String[] args) {
        System.out.println("Hola, Mundo!");

        // Leer nombre del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce tu nombre: ");
        String nombre = scanner.nextLine();

        // Mostrar saludo
        System.out.println("Hola, " + nombre + ", ¡bienvenido a Java!");
    }
}
```
### 2. Compilar y ejecutar un programa Java
- **Compilar**: esto genera el archivo HolaMundo.class.
```
javac HolaMundo.java
```
- **Ejecutar**
```
java HolaMundo.java
```
### 3. Detalles clave
- El orden correcto: **package → imports → clase → método main.**
- El nombre del archivo debe coincidir con el de la clase pública.
- Usa comentarios (// y /* */) para mejorar la legibilidad del código.
- Sigue las convenciones de nomenclatura Java *(CamelCase para clases, minúscula para métodos y variables)*.
