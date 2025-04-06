# Tipos de Datos y Variables. :floppy_disk:
### ¿Qué es una variable?
- Una variable es un espacio en memoria con un nombre único que se usa para almacenar información<br> que puede cambiar durante la ejecución del programa.
- La declaración de una variable sigue una estructura básica:
>tipo_de_dato nombre_variable = valor;
```
int numero = 10;
System.out.println("El valor de la variable numero es: " + numero);
```
**Los tipos de datos en Java se dividen en dos categorías: <ins>tipos de datos primitivos y tipos de datos no primitivos.</ins>**
### 1. Tipos de Datos Primitivos:
**Enteros, decimales, caracteres y booleanos:**
- Java, al ser un lenguaje de programación fuertemente tipado, exige que se defina el tipo de dato de cada variable, lo que proporciona un control estricto sobre los datos, mejorando así la seguridad y el rendimiento del código.
<image src="https://github.com/aruipal/Java/blob/main/recursos/TipoDeDatos.JPG" alt="datos" width="890" height="330">

### 2. Tipos de Datos no Primitivos:
Cualquier tipo de dato que <ins>no es uno de los ocho tipos de datos primitivos</ins> en Java.<br> 
En lugar de almacenar directamente el valor de la variable, almacenan una dirección o referencia a un objeto en la memoria.<br>
Lo que realmente estás manipulando es una referencia a un objeto o a una estructura de datos más compleja, como una instancia<br> de una clase o un arreglo.
- **String**: Cadena de texto.
- **Arrays**: Estructura que almacena múltiples elementos del mismo tipo.
- **Objetos**: Instancias de clases, que pueden contener métodos y atributos.
- **Clases Envoltorio**: Versiones objeto de tipos primitivos, como Integer para int.<br>

**2.1 Características de los tipos de datos no primitivos:**
- Son más complejos que los tipos de datos primitivos
- Normalmente no están predefinidos, sino que los determina el programador
- Empiezan con mayúscula
- No almacenan directamente el valor, sino una referencia a la ubicación en memoria donde se encuentra el objeto
