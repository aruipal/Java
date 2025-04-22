# Manejo de Excepciones Básicas.
### ¿Qué es una excepción?
💡 Aprender a manejar excepciones en Java es clave para evitar que tu programa crashee cuando algo inesperado sucede (como dividir por cero o leer un archivo que no existe).\
- Una excepción es un evento inesperado que **interrumpe** el flujo normal del programa.\
- Java usa bloques especiales para **capturar y manejar** esos errores sin detener el programa.
```
int resultado = 10 / 0; // Esto genera una ArithmeticException
```
### ✅ Estructura básica de manejo de excepciones
<image src="https://github.com/aruipal/Java/blob/main/recursos/excepcion1.JPG" alt="excepcion1" width="550" height="150">

### 1. Uso de try y catch
🧩 **¿Qué hacen try y catch?**\
🔹 **try:** Aquí va el código que podría fallar.\
🔹 **catch:** Aquí defines qué hacer si ocurre un error (excepción).\
<image src="https://github.com/aruipal/Java/blob/main/recursos/excepcion2.JPG" alt="excepcion2" width="600" height="300">

🔍 **En este caso:**
- $${\color{grey}numero1 / numero2}$$ genera una excepción (ArithmeticException).
- El $${\color{grey}catch}$$ captura el error y muestra un mensaje en vez de que el programa se detenga.
 
### 2. Manejo de múltiples excepciones
- Puedes manejar múltiples excepciones usando varios bloques catch o un solo bloque que maneje varias a la vez.
- Esto es útil cuando un bloque try puede **lanzar diferentes tipos de errores.**
  
<image src="https://github.com/aruipal/Java/blob/main/recursos/excepcion3.JPG" alt="excepcion3" width="600" height="300">

🔍 **¿Qué pasa aquí?**
- Si el parseInt falla, entra en el primer catch.
- Si el texto es null, entra en el segundo catch.

### 3. Uso del bloque finally
- Es un bloque opcional que se escribe después del/los catch. Sirve para liberar recursos, cerrar conexiones, o simplemente hacer limpieza al final de un proceso.
- Se usa cuando necesitas ejecutar código que debe correr sí o sí, ocurra o no una excepción.

<image src="https://github.com/aruipal/Java/blob/main/recursos/excepcion4.JPG" alt="excepcion4" width="600" height="300">
  
🧠 **Salida esperada:**
```
¡Error! División por cero.
Este bloque se ejecuta siempre.
```

### Ejemplo completo con Scanner
<image src="https://github.com/aruipal/Java/blob/main/recursos/excepcion5.JPG" alt="excepcion5" width="650" height="600">
  
🧪 **¿Qué cubre este ejemplo?**

✅ Entrada de texto con Scanner\
✅ Conversión de texto a int con Integer.parseInt()\
✅ Captura de errores por:
- letras o símbolos no numéricos (NumberFormatException)
- división entre cero (ArithmeticException)

✅ Cierre seguro del Scanner con finally
