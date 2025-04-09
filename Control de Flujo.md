# Control de Flujo: if, else, switch. :question:
- Permite que el programa tome decisiones y siga caminos distintos <mark>según condiciones</mark> evaluadas.
```
int edad = 20;
if (edad >= 18) {
    System.out.println("Eres mayor de edad.");
}
```
### 1. Sentencia if
- La sentencia if evalúa una condición booleana (que da true o false).
- Si la condición es verdadera, se ejecuta el bloque de código.
```
int nota = 90;
if (nota >= 50) {
    System.out.println("Has aprobado.");
}
```
### 2. Sentencia if-else
- Si la condición es verdadera, se ejecuta el bloque del if.
- Si es falsa, se ejecuta el bloque del else.
```
int hora = 10;
if (hora < 12) {
    System.out.println("Buenos días.");
} else {
    System.out.println("Buenas tardes.");
}
```
### 3. Sentencia if-else if
- Se evalúan las condiciones en orden.
- La primera condición verdadera se ejecuta, y el resto se ignora.
- Si ninguna condición se cumple, se ejecuta el bloque else (si está presente).
```
int nota = 85;
if (nota >= 90) {
    System.out.println("Sobresaliente");
} else if (nota >= 80) {
    System.out.println("Notable");
} else if (nota >= 70) {
    System.out.println("Aprobado");
} else {
    System.out.println("Suspenso");
}
```
### 4. Sentencia switch
- Evalúa el valor de una variable y ejecuta el bloque de código que coincida con uno de los casos **(case)**.<br>
✅ **Sintaxis básica**
<image src="https://github.com/aruipal/Java/blob/main/recursos/switch.jpg" alt="switch" width="400" height="300">

🔍 **Ejemplo: menú de opciones**

<image src="https://github.com/aruipal/Java/blob/main/recursos/switch2.jpg" alt="switch" width="450" height="400">

📝 **Ejercicios**
1. Escribe un programa que diga si un número es positivo, negativo o cero usando if-else-if.
<image src="https://github.com/aruipal/Java/blob/main/recursos/if_elseif_else.JPG" alt="switch" width="450" height="450">

2. Escribe un programa que evalúe una nota del 0 al 100 y devuelva "Excelente", "Bueno", "Regular" o "Insuficiente".
<image src="https://github.com/aruipal/Java/blob/main/recursos/if_else.JPG" alt="switch" width="500" height="520">




