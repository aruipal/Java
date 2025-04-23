# Métodos en Java: Definición, Parámetros y Retorno. 🧠
### ¿Qué es un método?
Un método es un bloque de código que realiza una tarea específica y puede ser llamado múltiples veces. Facilita la organización, reutilización y mantenimiento del código.

**Sintaxis general:**
```
tipoDeRetorno nombreDelMetodo(tipoParametro nombreParametro) {
    // Código
    return valor; // si hay retorno
}
```
### 1. Método sin parámetros y sin retorno
<image src="https://github.com/aruipal/Java/blob/main/recursos/metodo1.JPG" alt="metodo1" width="550" height="100">

:pushpin: void significa que no retorna ningún valor.
### 2. Método con parámetro
<image src="https://github.com/aruipal/Java/blob/main/recursos/metodo2.JPG" alt="metodo1" width="550" height="100">

:pushpin: Este método recibe un parámetro tipo String llamado nombre.
### 3. Método con múltiples parámetros
<image src="https://github.com/aruipal/Java/blob/main/recursos/metodo5.JPG" alt="metodo5" width="600" height="200">

:pushpin: **Reglas importantes:**
- Los parámetros se declaran con su **tipo y nombre.**
- Pueden ser de **distintos tipos** de datos.
- El orden **sí importa** al llamar el método.
### 4. Método con retorno (entero)
<image src="https://github.com/aruipal/Java/blob/main/recursos/metodo6.JPG" alt="metodo6" width="600" height="300">

🔍 **¿Qué está pasando aquí?**
- static int sumar(int a, int b)<br>
👉 Es un método que retorna un int.
- Dentro del método, se calcula a + b y se guarda en resultado.
- Luego se retorna ese valor usando return resultado;.

🧠 **Nota rápida sobre el return:**
- El return finaliza la ejecución del método y devuelve el valor al lugar donde fue llamado.
- El tipo de valor que se retorna debe coincidir con el tipo declarado en el método (int en este caso).<br>

### 5. Método con retorno (String)
<image src="https://github.com/aruipal/Java/blob/main/recursos/metodo7.JPG" alt="metodo7" width="600" height="300">

🔍 **¿Qué pasa aquí?**
static String saludar(String nombre)<br>
👉 Este método **recibe un parámetro tipo** String y retorna un **mensaje personalizado** también de tipo String.
- Se construye una cadena con "Hola, " + nombre + "..." y se retorna.
- En main, guardamos el resultado en la variable mensaje y luego lo mostramos.

📌 **Tipos de retorno comunes**
- int, double, boolean, String, objetos personalizados, etc.
- El tipo de retorno **debe coincidir** con lo que dice la firma del método.
